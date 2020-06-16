package com.ssd.petMate.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssd.petMate.dao.AnswerDao;
import com.ssd.petMate.domain.Answer;

@Service
@Transactional
public class AnswerImpl implements AnswerFacade{

	@Autowired
	private AnswerDao answerDao;
	
	@Override
	public List<Answer> getReplyList(int boardNum) {
		// TODO Auto-generated method stub
		return answerDao.getReplyList(boardNum);
	}

	@Override
	public void insertReply(Answer reply) {
		// TODO Auto-generated method stub
		answerDao.insertReply(reply);
	}

	@Override
	public void updateReply(Answer reply) {
		// TODO Auto-generated method stub
		answerDao.updateReply(reply);
	}

	@Override
	public void deleteReply(int answerNum) {
		// TODO Auto-generated method stub
		answerDao.deleteReply(answerNum);
	}

	@Override
	public Answer replyDetail(int answerNum) {
		// TODO Auto-generated method stub
		return answerDao.replyDetail(answerNum);
	}

	@Override
	public int replyCnt(int boardNum) {
		// TODO Auto-generated method stub
		return answerDao.replyCnt(boardNum);
	}

	@Override
	public void setReplyOrder(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		answerDao.setReplyOrder(map);
	}

	@Override
	public int countSameGID(int answerNum) {
		// TODO Auto-generated method stub
		return 0;
	}
}
