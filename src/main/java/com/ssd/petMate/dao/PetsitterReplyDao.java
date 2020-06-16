package com.ssd.petMate.dao;

import java.util.HashMap;
import java.util.List;

import org.springframework.dao.DataAccessException;

import com.ssd.petMate.domain.PetsitterReply;

public interface PetsitterReplyDao {
	public List<PetsitterReply> getReplyList(int boardNum) throws DataAccessException;
	public PetsitterReply replyDetail(int replyNum) throws DataAccessException;
	public void insertReply(PetsitterReply petsitterReply)throws DataAccessException;
	public void updateReply(PetsitterReply petsitterReply)throws DataAccessException;
	public void deleteReply(int replyNum)throws DataAccessException;
	public int replyCnt(int boardNum) throws DataAccessException;
	public void setReplyOrder(HashMap<String, Object> map) throws DataAccessException;
	public int countSameGID(int replyNum) throws DataAccessException;
}
