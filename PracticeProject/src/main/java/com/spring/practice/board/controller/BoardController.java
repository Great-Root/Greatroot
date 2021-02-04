package com.spring.practice.board.controller;


import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.practice.board.commons.PageCreator;
import com.spring.practice.board.commons.SearchVO;
import com.spring.practice.board.model.PostVO;
import com.spring.practice.board.service.IBoardService;
import com.spring.practice.user.model.UserVO;

@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired
	private IBoardService service;
	
	@GetMapping("/list")
	public String boardList(Model model, SearchVO search) {
		
		PageCreator pc = new PageCreator();
		pc.setPaging(search);
		pc.setPostTotalCount(service.totalNumOfPosts(search));
		model.addAttribute("pc", pc);
		model.addAttribute("boardList", service.getBoardList(search));
		return "board/list";
	}
	
	@GetMapping("/write")
	public void write() {
	}
	
	@PostMapping("/write")
	public String write(PostVO post) {
		service.insertPost(post);
		return "redirect:/board/list";
	}
	
	@GetMapping("/postView/{postNo}")
	public String postView(@PathVariable int postNo, SearchVO search, Model model,HttpSession session) {
		UserVO loginData = (UserVO) session.getAttribute("login");
		PostVO post = service.getPost(postNo);
		if(loginData != null) {
			post.setLike(post.getLikes().contains(loginData.getAccount().hashCode()));
			post.setDislike(post.getDislikes().contains(loginData.getAccount().hashCode()));
		}
		model.addAttribute("search", search);
		model.addAttribute("post", post);
		return "board/view";
	}
	
	@PostMapping("/modifyPost")
	public String modifyPost(PostVO post, Model model, boolean result, SearchVO search) {
		if(result) {
			service.updatePost(post);
			return "redirect:/board/postView/"+post.getPostNo()+new PageCreator().makeURI(search);
		}else {
			model.addAttribute("search", search);
			model.addAttribute("post", service.getPost(post.getPostNo()));
			return "board/write";
		}
		
	}
	
	@PostMapping("/deletePost")
	public String deletePost(int postNo, SearchVO search) {
		service.deletePost(postNo);
		return "redirect:/board/list"+new PageCreator().makeURI(search);
	}
	
	//좋아요 기능
	@PostMapping("/postLike")
	@ResponseBody
	public Map<String,Object> postLike(int postNo,@RequestBody String account) {
		Map<String, Object> map = new HashMap<String, Object>();
		PostVO post = service.getPost(postNo);
		service.postLike(post, account);
		map.put("like",post.isLike());
		map.put("likeNum", post.getLikesNum());
		map.put("dislike",post.isDislike());
		map.put("dislikeNum", post.getDislikesNum());
		return map;
	}
	
	//싫어요 기능
	@PostMapping("/postDislike")
	@ResponseBody
	public Map<String,Object> postDislike(int postNo,@RequestBody String account) {
		Map<String, Object> map = new HashMap<String, Object>();
		PostVO post = service.getPost(postNo);
		service.postDislike(post, account);
		map.put("like",post.isLike());
		map.put("dislike",post.isDislike());
		map.put("likeNum", post.getLikesNum());
		map.put("dislikeNum", post.getDislikesNum());
		return map;
	}

	
	
}
