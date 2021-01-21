package com.spring.practice.board.commons;

public class SearchVO extends PageVO {

	private String keyword;
	private String condition;
	
	public SearchVO() {
		this.keyword = "";
		this.condition = "";
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

//	@Override
//	public String toString() {
//		return "SearchVO [page="+getPage()+"pagePerPage"+getCountPerPage()+"keyword=" + keyword + ", condition=" + condition + "]";
//	}
	
	
	
}
