package com.spring.practice.user.service;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.spring.practice.user.commons.MailUtils;
import com.spring.practice.user.commons.TempKey;
import com.spring.practice.user.model.MailVO;
import com.spring.practice.user.model.UserVO;
import com.spring.practice.user.repository.IUserMapper;

@Service
public class UserService implements IUserService {

	@Autowired
	private IUserMapper mapper;
	@Autowired
	private JavaMailSender mailSender;
	
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
		Date delDate = new Date(System.currentTimeMillis() + (1000L * 60 * 60 * 24 * 90));
		Map<String,Object> delInfo = new HashMap<>();
		delInfo.put("account", account);
		delInfo.put("delDate", delDate);
		mapper.deleteAccount(delInfo);
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
		UserVO user = mapper.getUserWithSessionId(sessionId);
		if(user == null || user.getLimitTime().getTime() < System.currentTimeMillis()) {
			user = null;
		}
		return user;
	}

	@Override
	public boolean sendConfirmEmail(MailVO vo) {
		boolean result = false;
		// 임의의 authkey 생성
		String authkey = new TempKey().getKey(50, false);
		vo.setUserKey(authkey);
		if (mapper.checkEmail(vo.getEmail()) == 0) {
			mapper.setAuthkey(vo);
		}else {
			mapper.updateAuthkey(vo);
		}
		try {
			// mail 작성 관련
			MailUtils sendMail = new MailUtils(mailSender);
			sendMail.setSubject("[GreatRoot] 회원가입 이메일 인증");
			sendMail.setText(new StringBuffer().append("<h1>[이메일 인증]</h1>")
					.append("<p>아래 링크를 클릭하시면 이메일 인증이 완료됩니다.</p>")
					.append("<a href='http://localhost/user/confirmNumCheck?email=")
					.append(vo.getEmail())
					.append("&userKey=")
					.append(authkey)
					.append("' target='_blenk'>이메일 인증 확인</a>")
					.toString());
			sendMail.setFrom("qhrmsqhrms12@naver.com", "GreatRoot");
			sendMail.setTo(vo.getEmail());
			sendMail.send();
			result = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	@Override
	public boolean confirmNumCheck(MailVO vo) {
		MailVO DBvo = mapper.getConfirmInfo(vo);
		boolean result;
		if(vo != null && DBvo.getUserKey().equals(vo.getUserKey())) {
			mapper.updateConfirmInfo(vo);
			result = true;
		}else {
			result = false;
		}
		return result;
	}
	
	@Override
	public boolean isConfirmEmail(String email) {
		MailVO vo = new MailVO();
		vo.setEmail(email);
		vo = mapper.getConfirmInfo(vo);
		boolean result = vo.getUserKey().equals("Y") ? true : false;
		return result;
	}
//	
//	@Override
//	public void deleteConfirmEmail(String email) {
//		mapper.deleteConfirmEmail(email.hashCode());
//	}

}
