package com.ssd.petMate.dao.mybatis.mapper;

import java.util.HashMap;
import java.util.List;

import com.ssd.petMate.domain.Answer;
import com.ssd.petMate.page.pageMaker;

public interface AnswerMapper {

	List<Answer> getAnswerList(pageMaker page);
	
	void insertAnswer(Answer reply);
	
	void updateAnswer(Answer reply);
	
	void deleteAnswer(int replyNum);
	
	Answer getAnswer(int replyNum);
	
	int answerCount(int boardNum);
	
	void setAnswerOrder(HashMap<String, Object> map);
	
	int findLastAnswerID(int replyNum);
	
	int countSameGID(int replyNum);
}
