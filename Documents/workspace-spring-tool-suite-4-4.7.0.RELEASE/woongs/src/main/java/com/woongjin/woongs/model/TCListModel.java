package com.woongjin.woongs.model;

import java.util.ArrayList;

import java.util.List;

import com.woongjin.woongs.service.Paging;

public class TCListModel { 
	private int count;
	private List<TCDto> boardList;//���� ���������� ������ �۵�
	private int requestPage;//��û������
	private int totalPageCount;//��ü ������ ��
	private int startRow;//���۱�
	private Paging p;
	
	
	public TCListModel() {
		this(new ArrayList<TCDto>(), 0, 0, 0, new Paging(),0);	
	}
	
	public TCListModel(List<TCDto> boardList, int requestPage, int totalPageCount, int startRow, Paging p,int count) {
		super();
		this.boardList = boardList;
		this.requestPage = requestPage;
		this.totalPageCount = totalPageCount;
		this.startRow = startRow;
		this.p = p;
		this.count = count;
	
	}
	public List<TCDto> getBoardList() {
		return boardList;
	}
	public void setBoardList(List<TCDto> boardList) {
		this.boardList = boardList;
	}
	public int getRequestPage() {
		return requestPage;
	}
	public void setRequestPage(int requestPage) {
		this.requestPage = requestPage;
	}
	public int getTotalPageCount() {
		return totalPageCount;
	}
	public void setTotalPageCount(int totalPageCount) {
		this.totalPageCount = totalPageCount;
	}
	public int getStartRow() {
		return startRow;
	}
	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}

	public Paging getP() {
		return p;
	}

	public void setP(Paging p) {
		this.p = p;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getCount() {
		return count;
	}

	
	
	
}
