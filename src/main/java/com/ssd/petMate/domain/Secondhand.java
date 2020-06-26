package com.ssd.petMate.domain;

import java.util.Date;

public class Secondhand {
	private int boardNum;
	private String boardDate;
	private String userID;
	private String boardContent;
	private int cartAdded;
	private int price;
	private String boardImage;
	private int boardHit;
	private int replyCnt;
	private String boardTitle;
	private int isSold;
	
	public int getBoardNum() {
		return boardNum;
	}
	public void setBoardNum(int boardNum) {
		this.boardNum = boardNum;
	}
	public String getBoardDate() {
		return boardDate;
	}
	public void setBoardDate(String boardDate) {
		this.boardDate = boardDate;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getBoardContent() {
		return boardContent;
	}
	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}
	public int getCartAdded() {
		return cartAdded;
	}
	public void setCartAdded(int cartAdded) {
		this.cartAdded = cartAdded;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getBoardImage() {
		return boardImage;
	}
	public void setBoardImage(String boardImage) {
		this.boardImage = boardImage;
	}
	public int getBoardHit() {
		return boardHit;
	}
	public void setBoardHit(int boardHit) {
		this.boardHit = boardHit;
	}
	public int getReplyCnt() {
		return replyCnt;
	}
	public void setReplyCnt(int replyCnt) {
		this.replyCnt = replyCnt;
	}
	public String getBoardTitle() {
		return boardTitle;
	}
	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}
	public int getIsSold() {
		return isSold;
	}
	public void setIsSold(int isSold) {
		this.isSold = isSold;
	}
	@Override
	public String toString() {
		return "Secondhand [boardNum=" + boardNum + ", boardDate=" + boardDate + ", userID=" + userID
				+ ", boardContent=" + boardContent + ", cartAdded=" + cartAdded + ", price=" + price + ", boardImage="
				+ boardImage + ", boardHit=" + boardHit + ", replyCnt=" + replyCnt + ", boardTitle=" + boardTitle
				+ ", isSold=" + isSold + "]";
	}
	
}
