package com.spring.practice.user;

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
//		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//		System.out.println("회원정보 수정 시작~");
//		user.setAccount("");
//		user.setPassword(encoder.encode(""));
//		user.setNickname("");
//		user.setEmail("@.");
//		user.setBirthday();
//		mapper.updateAccount();
//		
//		System.out.println("회원정보 수정 테스트끝");
		
	}

}
