package com.ssd.petMate.domain;

public class GpurchaseReply {
	private String userID;
	private int boardNum;
	private int replyNum;
	private String boardDate;
	private String boardContent;
	private int replyGID;
	private int replyParents;
	private int replyOrder;
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public int getBoardNum() {
		return boardNum;
	}
	public void setBoardNum(int boardNum) {
		this.boardNum = boardNum;
	}
	public int getReplyNum() {
		return replyNum;
	}
	public void setReplyNum(int replyNum) {
		this.replyNum = replyNum;
	}
	public String getBoardDate() {
		return boardDate;
	}
	public void setBoardDate(String boardDate) {
		this.boardDate = boardDate;
	}
	public String getBoardContent() {
		return boardContent;
	}
	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}
	public int getReplyGID() {
		return replyGID;
	}
	public void setReplyGID(int replyGID) {
		this.replyGID = replyGID;
	}
	public int getReplyParents() {
		return replyParents;
	}
	public void setReplyParents(int replyParents) {
		this.replyParents = replyParents;
	}
	public int getReplyOrder() {
		return replyOrder;
	}
	public void setReplyOrder(int replyOrder) {
		this.replyOrder = replyOrder;
	}
	
	
}
