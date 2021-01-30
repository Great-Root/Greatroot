package com.spring.practice.user.controller;


import java.sql.Date;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.WebUtils;

import com.spring.practice.user.model.UserVO;
import com.spring.practice.user.service.IUserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private IUserService service;

	@PostMapping("/login")
	public String login(@RequestBody UserVO inputData, HttpSession session, HttpServletResponse response) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();		
		UserVO dbData = service.getOneUserInfo(inputData.getAccount());

		if (dbData != null && encoder.matches(inputData.getPassword(), dbData.getPassword()) && dbData.getDelDate() == null) {
			session.setAttribute("login", dbData);
			// AutoLogin
			if (inputData.isAutoLogin()) {
				Cookie loginCookie = new Cookie("loginCookie", session.getId());
				long limitTime = 60 * 60 * 24 * 7;
				loginCookie.setPath("/");
				loginCookie.setMaxAge((int) limitTime);
				response.addCookie(loginCookie);
				long expiredDate = System.currentTimeMillis() + (limitTime * 1000L);
				Date limitDate = new Date(expiredDate);
				service.keepLogin(session.getId(), limitDate, inputData.getAccount());
			}
			return "loginSuccess";
		}

		return "loginFail";
	}
	
	@GetMapping("/logout")
	public ModelAndView logout(HttpSession session, HttpServletRequest request, HttpServletResponse response) {
		UserVO loginData = (UserVO) session.getAttribute("login");
		if(loginData != null) {
			session.removeAttribute("login");
			session.invalidate();
			Cookie loginCookie = WebUtils.getCookie(request, "loginCookie");
			if(loginCookie != null) {
				loginCookie.setMaxAge(0);
				response.addCookie(loginCookie);
				service.keepLogin("none", new Date(System.currentTimeMillis()), loginData.getAccount());
			}
		}
		
		return new ModelAndView("redirect:/");
	}
	
	@PostMapping("/checkId")
	public String checkId(@RequestBody String account) {
		int checkNum = service.checkAccount(account);
		return (checkNum == 0 ? "OK" : "NO");
	}
	
	@PostMapping("/checkNickName")
	public String checkNickName(@RequestBody String nickname) {
		int checkNick = service.checkNickName(nickname);
		return (checkNick == 0 ? "OK" : "NO");
	}
	
	//회원가입
	@GetMapping("/register")
	public ModelAndView register() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("pageName", "회원가입");
		mv.setViewName("user/register");
		return mv;
	}
	
	@PostMapping("/register")
	public String register(@RequestBody UserVO user) {
		service.register(user);
		return "joinSuccess";
	}
	
	//회원정보변경
	@GetMapping("/modifyUserInfo")
	public ModelAndView modifyUserInfo(HttpSession session) {
		UserVO loginData = (UserVO) session.getAttribute("login");
		ModelAndView mv = new ModelAndView();
		if(loginData != null) {
			mv.setViewName("user/register");
			mv.addObject("user", service.getOneUserInfo(loginData.getAccount()));
			mv.addObject("pageName", "회원정보 변경");
		}else {
			mv.setViewName("redirect:/");
		}
		return mv;
	}
	
	@PostMapping("/modifyUserInfo")
	public String modifyUserInfo(@RequestBody UserVO user) {
		service.updateAccount(user);
		return "modifySuccess";
	}
	
	@PostMapping("/modifyChk")
	public String modifyChk(@RequestBody String pw, HttpSession session) {
		UserVO loginData = (UserVO) session.getAttribute("login");
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String result = encoder.matches(pw, loginData.getPassword()) ? "success" : "fail";
		return result;
	}
	
	//회원 탈퇴 기능
	@PostMapping("/deleteUserInfo")
	public String deleteUserInfo(@RequestBody UserVO delInfo,HttpSession session) {
		UserVO loginData = (UserVO) session.getAttribute("login");
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String result;
		if(loginData.getAccount().equals(delInfo.getAccount()) && encoder.matches(delInfo.getPassword(), loginData.getPassword())) {
			service.deleteAccount(delInfo.getAccount());
			result = "deleteSuccess";
		}else {
			result = "deleteFail";
		}
			
		return result;
	}
	
}
