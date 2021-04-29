package com.spring.practice.user.model;

import java.sql.Timestamp;

public class MailVO {
	
	private String email;
	private String userKey;
	private Timestamp regDate;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUserKey() {
		return userKey;
	}
	public void setUserKey(String userKey) {
		this.userKey = userKey;
	}
	public Timestamp getRegDate() {
		return regDate;
	}
	public void setRegDate(Timestamp regDate) {
		this.regDate = regDate;
	}
	@Override
	public String toString() {
		return "MailVO [email=" + email + ", userKey=" + userKey + ", regDate=" + regDate + "]";
	}
	
}
