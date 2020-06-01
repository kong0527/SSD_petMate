package com.ssd.petMate.domain;

public class GpurchaseReply {
	private String userID;
	private int boardNum;
	private int replyNum;
	private String date;
	private String content;
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
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
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
