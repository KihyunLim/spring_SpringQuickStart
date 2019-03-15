package com.springbook.biz.board;

public class BoardCriteria {

	private int page;
	private int perPageNum;
//	private int startPage;		// 필요없는건데 다른 소스들에선 왜 쓴건지 모르겠다
	private BoardVO vo;
	
	public BoardCriteria(BoardVO vo) {
		this.page = 1;
		this.perPageNum = 3;
		this.vo = vo;
	}
	
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		if(page > 0) {
			this.page = page;
		} else {
			this.page = 1;
		}
	}

	public int getPerPageNum() {
		return perPageNum;
	}
	public void setPerPageNum(int perPageNum) {
		this.perPageNum = perPageNum;
	}
	
	/*public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}*/

	public BoardVO getVo() {
		return vo;
	}
	public void setVo(BoardVO vo) {
		this.vo = vo;
	}

	public int getPageStart() {
		return (this.page-1) * this.perPageNum;
	}

	@Override
	public String toString() {
		return "BoardCriteria [page=" + page + ", perPageNum=" + perPageNum + ", vo=" + vo
				+ "]";
	}
}
