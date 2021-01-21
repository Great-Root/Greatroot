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
		
//		System.out.println("글 작성 테스트 시작~");
//		
//		for (int i = 131; i <= 350; i++) {
//			PostVO post = new PostVO();
//			post.setTitle("테스트 제목 : " + i+"번째 글");
//			post.setWriter("테스트 작성자 : " + i + "번째 쓴 사람");
//			post.setContent("아~ 아~ 하나 둘 삼 넷  하나 둘 삼 넷 지금은 "+ i +"번째 테스트 중 입니다.");
//			mapper.insertPost(post);
//		}
//		
//		System.out.println("글작성을 완료했어요 게시판을 확인해 보세용~");
		
	}

}
