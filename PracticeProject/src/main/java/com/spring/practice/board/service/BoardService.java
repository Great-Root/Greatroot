package com.spring.practice.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.practice.board.commons.SearchVO;
import com.spring.practice.board.model.PostVO;
import com.spring.practice.board.repository.IBoardMapper;


@Service
public class BoardService implements IBoardService{
	
	@Autowired
	private IBoardMapper mapper;

	@Override
	public List<PostVO> getBoardList(SearchVO search) {
		return mapper.getBoardList(search);
	}

	@Override
	public int totalNumOfPosts(SearchVO search) {
		return mapper.totalNumOfPosts(search);
	}
	
	@Override
	public PostVO getPost(int postNo) {
		mapper.updateViews(postNo);
		return mapper.getPost(postNo);
	}

	@Override
	public void insertPost(PostVO post) {
		mapper.insertPost(post);
	}

	@Override
	public void updatePost(PostVO post) {
		mapper.updatePost(post);
	}

	@Override
	public void deletePost(int postNo) {
		mapper.deletePost(postNo);
	}

	
}
