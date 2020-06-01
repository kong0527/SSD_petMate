package com.ssd.petMate.domain;

public class SecondhandLineItem {
	private int orderNo;
	private int price;
	private int boardNum;
	private int lineItemNum;
	public int getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getBoardNum() {
		return boardNum;
	}
	public void setBoardNum(int boardNum) {
		this.boardNum = boardNum;
	}
	public int getLineItemNum() {
		return lineItemNum;
	}
	public void setLineItemNum(int lineItemNum) {
		this.lineItemNum = lineItemNum;
	}
}
