package com.spring.practice.board;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.spring.practice.board.model.PostVO;
import com.spring.practice.board.repository.IBoardMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/mvc-config.xml"})
public class BoardMapperTest {
	
	@Autowired
	private IBoardMapper mapper;
	
	//게시글 등록 테스트
	@Test
	public void postInsertTest() {
		
//		PostVO post = new PostVO();
//		post.setTitle("테스트 제목 입니다~");
//		post.setWriter("테스트 작성자 입니다!");
//		post.setContent("아~ 아~ 하나 둘 삼 넷  하나 둘 삼 넷 지금은 테스트 중 입니다.");
//		mapper.insertPost(post);

		
	}

}
