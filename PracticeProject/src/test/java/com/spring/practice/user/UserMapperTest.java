package com.spring.practice.user;

import java.sql.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.spring.practice.user.model.UserVO;
import com.spring.practice.user.repository.IUserMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/mvc-config.xml"})
public class UserMapperTest {
	
	@Autowired
	private IUserMapper mapper;
	
	
	@Test
	public void userRegisterTest() {
		UserVO user = new UserVO();
		System.out.println("회원가입 테스트 시작~");
		user.setAccount("testId");
		user.setPassword("testPw");
		user.setNickname("testNick");
		user.setEmail("testEmail");
		user.setBirthday(new Date(1993-10-22));
		mapper.register(user);
		
		System.out.println("회원가입 테스트끝");
		
	}

}
