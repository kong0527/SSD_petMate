package com.ssd.petMate.dao.mybatis;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.ssd.petMate.dao.MyPageDao;
import com.ssd.petMate.dao.mybatis.mapper.MyPageMapper;
import com.ssd.petMate.domain.Gpurchase;
import com.ssd.petMate.domain.Info;
import com.ssd.petMate.domain.Inquiry;
import com.ssd.petMate.domain.Petsitter;
import com.ssd.petMate.domain.Review;
import com.ssd.petMate.domain.Secondhand;
import com.ssd.petMate.page.BoardSearch;

@Repository
public class MybatisMyPageDao implements MyPageDao{
	
	@Autowired
	private MyPageMapper myPageMapper;

	@Override
	public int getPrivateInfoCount(HashMap<String, Object> map) throws DataAccessException {
		// TODO Auto-generated method stub
		return myPageMapper.getPrivateInfoCount(map);
	}

	@Override
	public List<Info> getPrivateInfoList(BoardSearch boardSearch) throws DataAccessException {
		// TODO Auto-generated method stub
		return myPageMapper.getPrivateInfoList(boardSearch);
	}
	
	@Override
	public int getPrivateReviewReplyCount(HashMap<String, Object> map) throws DataAccessException {
		// TODO Auto-generated method stub
		return myPageMapper.getPrivateReviewReplyCount(map);
	}

	@Override
	public List<Review> getPrivateReviewReplyList(BoardSearch boardSearch) throws DataAccessException {
		// TODO Auto-generated method stub
		return myPageMapper.getPrivateReviewReplyList(boardSearch);
	}

	@Override
	public int getPrivateInquiryReplyCount(HashMap<String, Object> map) throws DataAccessException {
		// TODO Auto-generated method stub
		return myPageMapper.getPrivateInquiryReplyCount(map);
	}

	@Override
	public List<Inquiry> getPrivateInquiryReplyList(BoardSearch boardSearch) throws DataAccessException {
		// TODO Auto-generated method stub
		return myPageMapper.getPrivateInquiryReplyList(boardSearch);
	}

	@Override
	public int getPrivateInfoReplyCount(HashMap<String, Object> map) throws DataAccessException {
		// TODO Auto-generated method stub
		return myPageMapper.getPrivateInfoReplyCount(map);
	}

	@Override
	public List<Info> getPrivateInfoReplyList(BoardSearch boardSearch) throws DataAccessException {
		// TODO Auto-generated method stub
		return myPageMapper.getPrivateInfoReplyList(boardSearch);
	}

	@Override
	public int getPrivateGpurchaseReplyCount(HashMap<String, Object> map) throws DataAccessException {
		// TODO Auto-generated method stub
		return myPageMapper.getPrivateGpurchaseReplyCount(map);
	}

	@Override
	public List<Gpurchase> getPrivateGpurchaseReplyList(BoardSearch boardSearch) throws DataAccessException {
		// TODO Auto-generated method stub
		return myPageMapper.getPrivateGpurchaseReplyList(boardSearch);
	}

	@Override
	public int getPrivateSecondhandReplyCount(HashMap<String, Object> map) throws DataAccessException {
		// TODO Auto-generated method stub
		return myPageMapper.getPrivateSecondhandReplyCount(map);
	}

	@Override
	public List<Secondhand> getPrivateSecondhandReplyList(BoardSearch boardSearch) throws DataAccessException {
		// TODO Auto-generated method stub
		return myPageMapper.getPrivateSecondhandReplyList(boardSearch);
	}

	@Override
	public int getPrivatePetsitterReplyCount(HashMap<String, Object> map) throws DataAccessException {
		// TODO Auto-generated method stub
		return myPageMapper.getPrivatePetsitterReplyCount(map);
	}

	@Override
	public List<Petsitter> getPrivatePetsitterReplyList(BoardSearch boardSearch) throws DataAccessException {
		// TODO Auto-generated method stub
		return myPageMapper.getPrivatePetsitterReplyList(boardSearch);
	}
}