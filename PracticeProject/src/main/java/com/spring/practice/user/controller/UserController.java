package com.spring.practice.user.controller;

import java.util.Date;

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

		if (dbData != null && encoder.matches(inputData.getPassword(), dbData.getPassword())) {
			session.setAttribute("login", dbData);
			// AutoLogin
			if (inputData.isAutoLogin()) {
				Cookie loginCookie = new Cookie("loginCookie", session.getId());
				long limitTime = 60 * 60 * 24 * 7;
				loginCookie.setPath("/");
				loginCookie.setMaxAge((int) limitTime);
				response.addCookie(loginCookie);
				long expiredDate = System.currentTimeMillis() + (limitTime * 1000);
				Date limitDate = new Date(expiredDate);
				service.keepLogin(session.getId(), limitDate, inputData.getAccount());
			}
			return "loginSuccess";
		}

		return "loginFail";
	}
	
	@GetMapping("/logout")
	public ModelAndView logout(HttpSession session, HttpServletRequest request, HttpServletResponse response) {
		UserVO vo = (UserVO) session.getAttribute("login");
		if(vo != null) {
			session.removeAttribute("login");
			session.invalidate();
			Cookie loginCookie = WebUtils.getCookie(request, "loginCookie");
			if(loginCookie != null) {
				loginCookie.setMaxAge(0);
				response.addCookie(loginCookie);
				service.keepLogin("none", new Date(), vo.getAccount());
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
	
	@GetMapping("/register")
	public ModelAndView register() {
		return new ModelAndView("/user/register");
	}
	
	@PostMapping("/register")
	public String register(@RequestBody UserVO user) {
		service.register(user);
		return "joinSuccess";
	}
	
}
