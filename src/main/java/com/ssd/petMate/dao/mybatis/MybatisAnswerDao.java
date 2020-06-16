package com.ssd.petMate.dao.mybatis;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.ssd.petMate.dao.AnswerDao;
import com.ssd.petMate.dao.mybatis.mapper.AnswerMapper;
import com.ssd.petMate.domain.Answer;

@Repository
public class MybatisAnswerDao implements AnswerDao{

	@Autowired
	private AnswerMapper answerMapper;
	
	@Override
	public List<Answer> getReplyList(int boardNum) throws DataAccessException {
		// TODO Auto-generated method stub
		return answerMapper.getReplyList(boardNum);
	}

	@Override
	public Answer replyDetail(int answerNum) throws DataAccessException {
		// TODO Auto-generated method stub
		return answerMapper.replyDetail(answerNum);
	}

	@Override
	public void insertReply(Answer answer) throws DataAccessException {
		// TODO Auto-generated method stub
		answerMapper.insertReply(answer);
	}

	@Override
	public void updateReply(Answer answer) throws DataAccessException {
		// TODO Auto-generated method stub
		answerMapper.updateReply(answer);
	}

	@Override
	public void deleteReply(int answerNum) throws DataAccessException {
		// TODO Auto-generated method stub
		answerMapper.deleteReply(answerNum);
	}

	@Override
	public int replyCnt(int boardNum) throws DataAccessException {
		// TODO Auto-generated method stub
		return answerMapper.replyCnt(boardNum);
	}

	@Override
	public void setReplyOrder(HashMap<String, Object> map) throws DataAccessException {
		// TODO Auto-generated method stub
		answerMapper.setReplyOrder(map);
	}

	@Override
	public int countSameGID(int answerNum) throws DataAccessException {
		// TODO Auto-generated method stub
		return answerMapper.countSameGID(answerNum);
	}
}
