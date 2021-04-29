package com.spring.practice.board.model;

import java.sql.Date;
import java.util.HashSet;

public class CommentVO {
	
	private int postNo;
	private int commentNo;
	private String commentWriter;
	private String commentContent;
	private Date regDate;
	private String time;
	private HashSet<Integer> likes;
	private HashSet<Integer> dislikes;
	private String nickname;
	private String ismodify;
	
	public int getPostNo() {
		return postNo;
	}
	public void setPostNo(int postNo) {
		this.postNo = postNo;
	}
	public int getCommentNo() {
		return commentNo;
	}
	public void setCommentNo(int commentNo) {
		this.commentNo = commentNo;
	}
	public String getCommentWriter() {
		return commentWriter;
	}
	public void setCommentWriter(String commentWriter) {
		this.commentWriter = commentWriter.replaceAll("<%|%>|<!--|-->", "♡");
	}
	public String getCommentContent() {
		return commentContent;
	}
	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent.replaceAll("<%|%>|<!--|-->", "♡");
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
	public HashSet<Integer> getLikes() {
		return likes;
	}
	public void setLikes(HashSet<Integer> likes) {
		this.likes = likes;
	}
	public HashSet<Integer> getDislikes() {
		return dislikes;
	}
	public void setDislikes(HashSet<Integer> dislikes) {
		this.dislikes = dislikes;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getIsmodify() {
		return ismodify;
	}
	public void setIsmodify(String ismodify) {
		this.ismodify = ismodify;
	}
	@Override
	public String toString() {
		return "CommentVO [postNo=" + postNo + ", commentNo=" + commentNo + ", commentWriter=" + commentWriter
				+ ", commentContent=" + commentContent + ", regDate=" + regDate + ", likes=" + likes + ", dislikes="
				+ dislikes + "]";
	}

}
