package com.spring.practice.board.service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.practice.board.commons.SearchVO;
import com.spring.practice.board.model.CommentVO;
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
			vo.setCommentNum(mapper.commentNum(vo.getPostNo()));
		}
		return list;
	}

	@Override
	public int totalNumOfPosts(SearchVO search) {
		return mapper.totalNumOfPosts(search);
	}
	
	@Override
	public int commentNum(int postNo) {
		return mapper.commentNum(postNo);
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
		mapper.downViews(post.getPostNo());
		mapper.downViews(post.getPostNo());
		mapper.updatePost(post);
	}

	@Override
	public void deletePost(int postNo) {
		mapper.delAllComment(postNo);
		mapper.deletePost(postNo);
	}
	
	//좋아요 기능
	@Override
	public void postLike(PostVO post, String account) {
		mapper.downViews(post.getPostNo());
		int hashCode = account.hashCode();
		HashSet<Integer> likeSet = post.getLikes();
		HashSet<Integer> dislikeSet = post.getDislikes();
		HashMap<String, Object> map = new HashMap<String, Object>();
		boolean conLike = likeSet.contains(hashCode);
		boolean conDisL = dislikeSet.contains(hashCode);
		map.put("postNo", post.getPostNo());
		if(!(conLike^conDisL)) {
			likeSet.add(hashCode);
			post.setLike(true);
		}else if((conLike^conDisL) && conLike) {
			likeSet.remove(hashCode);
			post.setLike(false);
		}else {
			likeSet.add(hashCode);
			dislikeSet.remove(hashCode);
			post.setLike(true);
			post.setDislike(false);
			map.put("dislikes", dislikeSet);
			mapper.postDislike(map);
		}
		post.setLikes(likeSet);
		map.put("likes", likeSet);
		mapper.postLike(map);
	}
	
	@Override
	public void postDislike(PostVO post, String account) {
		mapper.downViews(post.getPostNo());
		int hashCode = account.hashCode();
		HashSet<Integer> likeSet = post.getLikes();
		HashSet<Integer> dislikeSet = post.getDislikes();
		HashMap<String, Object> map = new HashMap<String, Object>();
		boolean conLike = likeSet.contains(hashCode);
		boolean conDisL = dislikeSet.contains(hashCode);
		map.put("postNo", post.getPostNo());
		if(!(conLike^conDisL)) {
			dislikeSet.add(hashCode);
			post.setDislike(true);
		}else if((conLike^conDisL) && conDisL) {
			dislikeSet.remove(hashCode);
			post.setDislike(false);
		}else {
			likeSet.remove(hashCode);
			dislikeSet.add(hashCode);
			post.setLike(false);
			post.setDislike(true);
			map.put("likes", likeSet);
			mapper.postLike(map);
		}
		post.setLikes(likeSet);
		post.setDislikes(dislikeSet);
		map.put("dislikes",dislikeSet);
		mapper.postDislike(map);
	}

	@Override
	public void setComment(CommentVO comment) {
		mapper.setComment(comment);
	}
	
	@Override
	public void deleteComment(int commentNo) {
		mapper.downViews(commentNo);
		mapper.deleteComment(commentNo);
	}
	@Override
	public List<CommentVO> getComment(int postNo) {
		List<CommentVO> list = mapper.getComment(postNo);
		for(CommentVO vo:list) {
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
	public void updateComment(CommentVO comment) {
		mapper.downViews(comment.getPostNo());
		mapper.updateComment(comment);
	}
	
}
