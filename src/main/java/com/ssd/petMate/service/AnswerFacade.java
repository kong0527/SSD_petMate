package com.ssd.petMate.service;

import java.util.HashMap;
import java.util.List;

import com.ssd.petMate.domain.Answer;

public interface AnswerFacade {

	List<Answer> getReplyList(int boardNum);
	
	void insertReply(Answer reply);
	
	void updateReply(Answer reply);
	
	void deleteReply(int replyNum);
	
	Answer replyDetail(int answerNum);
	
	int replyCnt(int boardNum);
	
	void setReplyOrder(HashMap<String, Object> map);
	
	int countSameGID(int answerNum);
}
