package com.spring.practice.user.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.spring.practice.user.model.UserVO;
import com.spring.practice.user.repository.IUserMapper;

@Service
public class UserService implements IUserService {

	@Autowired
	private IUserMapper mapper;
	
	@Override
	public void register(UserVO user) {
		user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
		mapper.register(user);
	}

	@Override
	public int checkAccount(String account) {
		return mapper.checkAccount(account);
	}
	
	@Override
	public int checkNickName(String nickname) {
		return mapper.checkNickName(nickname);
	}
	
	@Override
	public void updateAccount(UserVO user) {
		user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
		mapper.updateAccount(user);
	}

	@Override
	public void deleteAccount(String account) {
		mapper.deleteAccount(account);
	}

	@Override
	public UserVO getOneUserInfo(String account) {
		return mapper.getOneUserInfo(account);
	}

	@Override
	public List<UserVO> getUserList() {
		return mapper.getUserList();
	}

	@Override
	public void keepLogin(String sessionId, Date limitDate, String account) {
		Map<String, Object> datas = new HashMap<>();
		datas.put("sessionId", sessionId);
		datas.put("limitDate", limitDate);
		datas.put("account", account);
		
		mapper.keepLogin(datas);
	}

	@Override
	public UserVO getUserWithSessionId(String sessionId) {
		return mapper.getUserWithSessionId(sessionId);
	}

}
