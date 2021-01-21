package com.spring.practice.board.commons;

import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

public class PageCreator {
	
	private PageVO paging;
	private int postTotalCount; 
	private int beginPage; 
	private int endPage; 
	private boolean prev; 
	private boolean next; 
	
	private final int displayPageNum = 10;
	
	public String makeURI(int page) {
		UriComponents ucp = UriComponentsBuilder.newInstance().queryParam("page", page)
															  .queryParam("countPerPage", paging.getCountPerPage())
															  .queryParam("keyword", ((SearchVO)paging).getKeyword())
															  .queryParam("condition", ((SearchVO)paging).getCondition())
															  .build();
		return ucp.toUriString();
	}
	public String makeURI(SearchVO search) {
		UriComponents ucp = UriComponentsBuilder.newInstance().queryParam("page", search.getPage())
															  .queryParam("countPerPage", search.getCountPerPage())
															  .queryParam("keyword", search.getKeyword())
															  .queryParam("condition", search.getCondition())
															  .build();
		return ucp.toUriString();
	}
	
	
	
	private void calcDataOfPage() {
		
		endPage = (int) (Math.ceil(paging.getPage() / (double)displayPageNum) 
				* displayPageNum);
		
		beginPage = (endPage - displayPageNum) + 1;
		
		prev = (beginPage == 1) ? false : true;
		
		next = (postTotalCount <= (endPage * paging.getCountPerPage())) ? false : true;
		
		if(!isNext()) {
			endPage = (int) Math.ceil(postTotalCount / (double)paging.getCountPerPage()); 
		}
		
	}
	
	
	

	public PageVO getPaging() {
		return paging;
	}

	public void setPaging(PageVO paging) {
		this.paging = paging;
	}

	public int getPostTotalCount() {
		return postTotalCount;
	}

	public void setPostTotalCount(int postTotalCount) {
		this.postTotalCount = postTotalCount;
		calcDataOfPage();
	}

	public int getBeginPage() {
		return beginPage;
	}

	public void setBeginPage(int beginPage) {
		this.beginPage = beginPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public boolean isPrev() {
		return prev;
	}

	public void setPrev(boolean prev) {
		this.prev = prev;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}


	@Override
	public String toString() {
		return "PageCreator [paging=" + paging + ", postTotalCount=" + postTotalCount + ", beginPage=" + beginPage
				+ ", endPage=" + endPage + ", prev=" + prev + ", next=" + next + "]";
	}
	
	
	

}
