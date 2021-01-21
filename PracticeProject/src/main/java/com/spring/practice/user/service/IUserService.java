package com.spring.practice.user.service;

import java.util.Date;
import java.util.List;

import com.spring.practice.user.model.UserVO;


public interface IUserService {
	
	//회원 가입 기능
	void register(UserVO user);
	
	//아이디 중복 체크 기능
	int checkAccount(String account);
	
	//닉네임 중복 체크 기능
	int checkNickName(String nickname);
	
	//회원 탈퇴 기능
	void deleteAccount(String account);
	
	//회원 정보 조회 기능
	UserVO getOneUserInfo(String account);
	
	//회원 정보 전체 조회 기능
	List<UserVO> getUserList();
	
	//자동 로그인 쿠키값 DB저장 처리.
	void keepLogin(String sessionId, Date limitDate, String account);
	
	//세션아이디를 통한 회원 정보 조회 기능
	UserVO getUserWithSessionId(String sessionId);

}
