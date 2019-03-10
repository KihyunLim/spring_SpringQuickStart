package com.springbook.biz.board;

public class PageMaker {

	private int totalCount;
	private int displayPageNum = 10;
	private int startPage;
	private int endPage;
	private boolean prev;
	private boolean next;
	private BoardPage boardPage;
	
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		
		calculatePaging();
	}
	
	public int getDisplayPageNum() {
		return displayPageNum;
	}
	public void setDisplayPageNum(int displayPageNum) {
		this.displayPageNum = displayPageNum;
	}
	
	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
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
	
	public BoardPage getBoardPage() {
		return boardPage;
	}
	public void setBoardPage(BoardPage boardPage) {
		this.boardPage = boardPage;
	}

	@Override
	public String toString() {
		return "PageMaker [totalCount=" + totalCount + ", displayPageNum=" + displayPageNum + ", startPage=" + startPage
				+ ", endPage=" + endPage + ", prev=" + prev + ", next=" + next + ", boardPage=" + boardPage + "]";
	}
	
	private void calculatePaging() {
		endPage = (int) (Math.ceil(boardPage.getPage() / (double) displayPageNum) * displayPageNum);
		
		startPage = (endPage - displayPageNum) + 1;
		
		int tempEndPage = (int) (Math.ceil(totalCount / (double) boardPage.getPerPageNum()));
		
		if(endPage > tempEndPage) {
			endPage = tempEndPage;
		}
		
		prev = startPage == 1 ? false : true;
		
		next = endPage * boardPage.getPerPageNum() >= totalCount ? false : true;
	}
}
