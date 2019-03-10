package com.springbook.biz.board;

public class BoardPage {

	private BoardVO vo;
	private int page;
	private int perPageNum;
	
	public BoardVO getBoardVO() {
		return vo;
	}

	public void setBoardVO(BoardVO vo) {
		this.vo = vo;
	}
	public BoardPage() {
		this.page = 1;
		this.perPageNum = 3;
	}

	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}

	public int getPerPageNum() {
		return perPageNum;
	}
	public void setPerPageNum(int perPageNum) {
		this.perPageNum = perPageNum;
	}
	
	public int getPageStart() {
		return (this.page-1)*perPageNum;
	}

	@Override
	public String toString() {
		return "boardPage [page=" + page + ", perPageNum=" + perPageNum + "]";
	}
}
