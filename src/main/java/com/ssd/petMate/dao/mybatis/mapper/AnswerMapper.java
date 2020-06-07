package com.ssd.petMate.dao.mybatis.mapper;

import java.util.HashMap;
import java.util.List;

import com.ssd.petMate.domain.Answer;
import com.ssd.petMate.page.pageMaker;

public interface AnswerMapper {

	List<Answer> getReplyList(pageMaker page);
	
	void insertReply(Answer reply);
	
	void updateReply(Answer reply);
	
	void deleteReply(int replyNum);
	
	Answer getReply(int replyNum);
	
	int replyCount(int boardNum);
	
	void setReplyOrder(HashMap<String, Object> map);
	
	int findLastReplyID(int replyNum);
	
	int countSameGID(int replyNum);
}
