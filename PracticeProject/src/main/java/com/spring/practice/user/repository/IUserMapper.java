package com.spring.practice.user.repository;

import java.util.List;
import java.util.Map;

import com.spring.practice.user.model.UserVO;


public interface IUserMapper {

	//회원 가입 기능
	void register(UserVO user);
	
	//아이디 중복 체크 기능
	int checkAccount(String account);
	
	//닉네임 중복 체크 기능
	int checkNickName(String nickname);
	
	//회원 정보 수정 기능
	void updateAccount(UserVO user);
	
	//회원 탈퇴 기능
	void deleteAccount(Map<String, Object> delInfo);
	
	//회원 정보 조회 기능
	UserVO getOneUserInfo(String account);
	
	//회원 정보 전체 조회 기능
	List<UserVO> getUserList();
	
	//자동 로그인 쿠키값 DB저장 처리.
	void keepLogin(Map<String, Object> datas);
	
	//세션아이디를 통한 회원 정보 조회 기능
	UserVO getUserWithSessionId(String sessionId);
	
}
