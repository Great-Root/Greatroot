package com.spring.practice.board.service;

import java.util.List;

import com.spring.practice.board.commons.SearchVO;
import com.spring.practice.board.model.PostVO;


public interface IBoardService {
	
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
	
	// 좋아요 증가
	
	// 싫어요 증가
	
}
