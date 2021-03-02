package com.spring.practice.board.repository;

import java.util.HashMap;
import java.util.List;

import com.spring.practice.board.commons.SearchVO;
import com.spring.practice.board.model.CommentVO;
import com.spring.practice.board.model.PostVO;


public interface IBoardMapper {

	// 게시글 전체 조회
	List<PostVO> getBoardList(SearchVO search);
	
	// 게시글 총 갯수 조회
	int totalNumOfPosts(SearchVO search);
	
	// 게시글 한개 조회
	PostVO getPost(int postNo);

	// 게시글 저장
	void insertPost(PostVO post);
	
	// 게시글 수정
	void updatePost(PostVO post);
	
	// 게시글 삭제
	void deletePost(int postNo);
	
	// 조회수 증가
	void updateViews(int postNo);
	
	// 조회수 감소(redirect 갯수 제거)
	void downViews(int postNo);
	
	// 좋아요 기능
	void postLike(HashMap<String, Object> map);
	
	// 좋아요 기능
	void postDislike(HashMap<String, Object> map);
	
	// 게시글 모든 댓글 삭제
	void delAllComment(int postNo);
	
	// 댓글 보기
	List<CommentVO> getComment(int postNo);
	
	// 댓글 추가
	void setComment(CommentVO comment);
	
	// 댓글 수정
	void updateComment(CommentVO comment);
	
	// 댓글 삭제
	void deleteComment(int commentNo);
	
	// 댓글 갯수 세기
	int commentNum(int postNo);

}
