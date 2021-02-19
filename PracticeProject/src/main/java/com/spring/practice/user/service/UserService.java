package com.spring.practice.user.service;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.spring.practice.board.commons.SendEmail;
import com.spring.practice.board.model.MailVO;
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
	public boolean sendConfirmEmail(String email) {
		if (mapper.checkEmail(email) == 0) {
			Map<String, Object> map = new HashMap<>();
			int emailHash = email.hashCode();
			MailVO vo = mapper.selectConfirmNum(emailHash);
			String confirmNum = "" + (int) (Math.random() * 999999 + 1);
			String SUBJECT = "GreatRoot 홈페이지 가입 인증 메일입니다!";
			String CONTENT = "<h2>메일인증을 하시려면 <a href=\"https://www.greatroot.net/user/confirmNumCheck?emailHash=" + emailHash
					+ "&confirmNum=" + confirmNum + "\">여기</a>를 클릭 해주세요!</h2>";
			map.put("emailHash", emailHash);
			map.put("confirmNum", confirmNum);
			if (vo != null) {
				mapper.deleteConfirmEmail(emailHash);
			}
			mapper.insertConfirmNum(map);
			try {
				new SendEmail(email, SUBJECT, CONTENT);
				return true;
			} catch (Exception e) {
				e.printStackTrace();
				mapper.deleteConfirmEmail(emailHash);
				return false;
			}
		} else {
			return false;
		}
	}
	
	@Override
	public boolean confirmNumCheck(int emailHash, String confirmNum) {
		MailVO vo = mapper.selectConfirmNum(emailHash);
		boolean result;
		if(vo != null && vo.getConfirmNum().equals(confirmNum)) {
			mapper.updateIsConfirm(emailHash);
			result = true;
		}else {
			result = false;
		}
		return result;
	}
	
	@Override
	public boolean isConfirmEmail(String email) {
		int emailHash = email.hashCode();
		int confirm = mapper.selectIsConfirm(emailHash);
		boolean result;
		if(confirm == 0) {
			result = false;
		}else {
			mapper.deleteConfirmEmail(emailHash);
			result = true;
		}
		mapper.deleteOldData(new Date(System.currentTimeMillis()-3600000L));
		return result;
	}
	
	@Override
	public void deleteConfirmEmail(String email) {
		mapper.deleteConfirmEmail(email.hashCode());
	}

}
