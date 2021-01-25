package com.spring.practice.user.commons;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.util.WebUtils;

import com.spring.practice.user.model.UserVO;
import com.spring.practice.user.service.IUserService;


public class AutoLoginInterceptor extends HandlerInterceptorAdapter {

	@Autowired
	private IUserService service;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		HttpSession session = request.getSession();

		Cookie loginCookie = WebUtils.getCookie(request, "loginCookie");
		if(loginCookie != null) { 
			
			UserVO user = service.getUserWithSessionId(loginCookie.getValue());
			if(user != null) {
				session.setAttribute("login", user);
			}
		}
		
		return true;
	}
	
}
























