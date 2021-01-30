package com.spring.practice.user.model;

import java.sql.Timestamp;
import java.sql.Date;

public class UserVO {
	
	private String account;
	private String password;
	private String nickname;
	private Date birthday;
	private String email;
	private Timestamp regDate;
	private String sessionId;
	private Timestamp limitTime;
	private boolean autoLogin;
	private int authority;
	private Date delDate;
	
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account.replaceAll("<%|%>|<!--|-->", "♡");
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password.replaceAll("<%|%>|<!--|-->", "♡");
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email.replaceAll("<%|%>|<!--|-->", "♡");
	}
	public Timestamp getRegDate() {
		return regDate;
	}
	public void setRegDate(Timestamp regDate) {
		this.regDate = regDate;
	}
	public String getSessionId() {
		return sessionId;
	}
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
	public Timestamp getLimitTime() {
		return limitTime;
	}
	public void setLimitTime(Timestamp limitTime) {
		this.limitTime = limitTime;
	}
	public boolean isAutoLogin() {
		return autoLogin;
	}
	public void setAutoLogin(boolean autoLogin) {
		this.autoLogin = autoLogin;
	}
	public int getAuthority() {
		return authority;
	}
	public void setAuthority(int authority) {
		this.authority = authority;
	}
	public Date getDelDate() {
		return delDate;
	}
	public void setDelDate(Date delDate) {
		this.delDate = delDate;
	}
	
	
	
}
