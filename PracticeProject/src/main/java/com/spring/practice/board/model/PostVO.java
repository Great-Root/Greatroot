package com.spring.practice.board.model;

import java.sql.Date;
import java.util.HashSet;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PostVO {

	private int postNo;
	private Date regDate;
	private String time;
	private int views;
	private HashSet<Integer> likes;
	private boolean like;
	private HashSet<Integer> dislikes;
	private boolean dislike;
	private String writer;
	private String title;
	private String content;
	
	PostVO(){
		if(likes == null) {
			likes = new HashSet<Integer>();
		}
		if(dislikes == null) {
			dislikes = new HashSet<Integer>();
		}
	}
	
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
	
	public int getLikesNum() {
		return likes.size();
	}
	
	public HashSet<Integer> getLikes() {
		return likes;
	}
	public void setLikes(HashSet<Integer> likes) {
		this.likes = likes;
	}
	
	public boolean isLike() {
		return like;
	}

	public void setLike(boolean like) {
		this.like = like;
	}
	
	public int getDislikesNum() {
		return dislikes.size();
	}

	public HashSet<Integer> getDislikes() {
		return dislikes;
	}
	public void setDislikes(HashSet<Integer> dislikes) {
		this.dislikes = dislikes;
	}
	
	
	public boolean isDislike() {
		return dislike;
	}

	public void setDislike(boolean dislike) {
		this.dislike = dislike;
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
