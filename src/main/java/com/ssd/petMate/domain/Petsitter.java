package com.ssd.petMate.domain;

public class Petsitter {
	private String boardNum;
	private String boardDate;
	private String userID;
	private String boardContent;
	private String petSize;
	private String petLocal;
	private int petPrice;
	private String petDay;
	private int boardLike;
	private String boardTitle;
	private int replyCnt;
	private int boardHit;
	private String boardImage;
	private String[] sizeCodes;
	private String[] dayCodes;
	
	
	public String getBoardNum() {
		return boardNum;
	}
	public void setBoardNum(String boardNum) {
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
	public String getPetSize() {
		return petSize;
	}
	public void setPetSize(String petSize) {
		this.petSize = petSize;
	}
	public String getPetLocal() {
		return petLocal;
	}
	public void setPetLocal(String petLocal) {
		this.petLocal = petLocal;
	}
	public int getPetPrice() {
		return petPrice;
	}
	public void setPetPrice(int petPrice) {
		this.petPrice = petPrice;
	}
	public String getPetDay() {
		return petDay;
	}
	public void setPetDay(String petDay) {
		this.petDay = petDay;
	}
	public int getBoardLike() {
		return boardLike;
	}
	public void setBoardLike(int boardLike) {
		this.boardLike = boardLike;
	}
	public String getBoardTitle() {
		return boardTitle;
	}
	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}
	public int getReplyCnt() {
		return replyCnt;
	}
	public void setReplyCnt(int replyCnt) {
		this.replyCnt = replyCnt;
	}
	public int getBoardHit() {
		return boardHit;
	}
	public void setBoardHit(int boardHit) {
		this.boardHit = boardHit;
	}
	public String getBoardImage() {
		return boardImage;
	}
	public void setBoardImage(String boardImage) {
		this.boardImage = boardImage;
	}
	public String[] getSizeCodes() {
		return sizeCodes;
	}
	public void setSizeCodes(String[] sizeCodes) {
		this.sizeCodes = sizeCodes;
	}
	public String[] getDayCodes() {
		return dayCodes;
	}
	public void setDayCodes(String[] dayCodes) {
		this.dayCodes = dayCodes;
	}
}
