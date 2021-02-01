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
		List<PostVO> list = mapper.getBoardList(search);
		for(PostVO vo:list) {
			long sec = (System.currentTimeMillis() - vo.getRegDate().getTime())/1000L;
			if(sec < 60) {
				vo.setTime(sec+"초 전");
			}else if(sec < 3600) {
				vo.setTime(sec/60+"분 전");
			}else if(sec < 86400) {
				vo.setTime(sec/3600+"시간 전");
			}else if(sec < 604800) {
				vo.setTime(sec/86400+"일 전");
			}else if(sec < 2592000) {
				vo.setTime(sec/604800+"주 전");
			}else if(sec < 31536000) {
				vo.setTime(sec/2592000+"개월 전");
			}else {
				vo.setTime(sec/31536000+"년 전");
			}
			
		}
		return list;
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
