package com.ssd.petMate.dao.mybatis.mapper;

import java.util.HashMap;
import java.util.List;

import com.ssd.petMate.domain.Answer;

public interface AnswerMapper {

	List<Answer> getReplyList(int boardNum);
	
	void insertReply(Answer answer);
	
	void updateReply(Answer answer);
	
	void deleteReply(int answerNum);
	
	Answer replyDetail(int answerNum);
	
	int replyCnt(int boardNum);
	
	void setReplyOrder(HashMap<String, Object> map);
	
	int findLastReplyID(int answerNum);
	
	int countSameGID(int answerNum);
}
