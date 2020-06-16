package com.ssd.petMate.dao;

import java.util.HashMap;
import java.util.List;

import org.springframework.dao.DataAccessException;

import com.ssd.petMate.domain.Answer;

public interface AnswerDao {
	public List<Answer> getReplyList(int boardNum) throws DataAccessException;
	public Answer replyDetail(int replyNum) throws DataAccessException;
	public void insertReply(Answer answer)throws DataAccessException;
	public void updateReply(Answer answer)throws DataAccessException;
	public void deleteReply(int replyNum)throws DataAccessException;
	public int replyCnt(int boardNum) throws DataAccessException;
	public void setReplyOrder(HashMap<String, Object> map) throws DataAccessException;
	public int countSameGID(int replyNum) throws DataAccessException;
}
