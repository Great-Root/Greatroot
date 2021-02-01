package com.spring.practice.board.model;

import java.sql.Date;

public class PostVO {

	private int postNo;
	private Date regDate;
	private String time;
	private int views;
	private int likes;
	private int dislikes;
	private String writer;
	private String title;
	private String content;
	
	public int getPostNo() {
		return postNo;
	}
	public void setPostNo(int postNo) {
		this.postNo = postNo;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public int getViews() {
		return views;
	}
	public void setViews(int views) {
		this.views = views;
	}
	public int getLikes() {
		return likes;
	}
	public void setLikes(int likes) {
		this.likes = likes;
	}
	public int getDislikes() {
		return dislikes;
	}
	public void setDislikes(int dislikes) {
		this.dislikes = dislikes;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer.replaceAll("<%|%>|<!--|-->", "♡");
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title.replaceAll("<%|%>|<!--|-->", "♡");
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content.replaceAll("<%|%>|<!--|-->", "♡");
	}
	@Override
	public String toString() {
		return "PostVO [postNo=" + postNo + ", regDate=" + regDate + ", views=" + views + ", likes=" + likes
				+ ", dislikes=" + dislikes + ", writer=" + writer + ", title=" + title + ", content=" + content + "]";
	}

}
