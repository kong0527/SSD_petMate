package com.ssd.petMate.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssd.petMate.dao.MyPageDao;
import com.ssd.petMate.domain.Gpurchase;
import com.ssd.petMate.domain.Info;
import com.ssd.petMate.domain.Inquiry;
import com.ssd.petMate.domain.Petsitter;
import com.ssd.petMate.domain.Review;
import com.ssd.petMate.domain.Secondhand;
import com.ssd.petMate.page.BoardSearch;

@Service
@Transactional
public class MyPageImpl implements MyPageFacade {
	@Autowired
	private MyPageDao myPageDao;

	@Override
	public int getPrivateInfoCount(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return myPageDao.getPrivateInfoCount(map);
	}

	@Override
	public List<Info> getPrivateInfoList(BoardSearch boardSearch) {
		// TODO Auto-generated method stub
		return myPageDao.getPrivateInfoList(boardSearch);
	}
	
	@Override
	public int getPrivateReviewReplyCount(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return myPageDao.getPrivateReviewReplyCount(map);
	}

	@Override
	public List<Review> getPrivateReviewReplyList(BoardSearch boardSearch) {
		// TODO Auto-generated method stub
		return myPageDao.getPrivateReviewReplyList(boardSearch);
	}

	@Override
	public int getPrivateInquiryReplyCount(HashMap<String, Object> map) throws DataAccessException {
		// TODO Auto-generated method stub
		return myPageDao.getPrivateInquiryReplyCount(map);
	}

	@Override
	public List<Inquiry> getPrivateInquiryReplyList(BoardSearch boardSearch) throws DataAccessException {
		// TODO Auto-generated method stub
		return myPageDao.getPrivateInquiryReplyList(boardSearch);
	}

	@Override
	public int getPrivateInfoReplyCount(HashMap<String, Object> map) throws DataAccessException {
		// TODO Auto-generated method stub
		return myPageDao.getPrivateInfoReplyCount(map);
	}

	@Override
	public List<Info> getPrivateInfoReplyList(BoardSearch boardSearch) throws DataAccessException {
		// TODO Auto-generated method stub
		return myPageDao.getPrivateInfoReplyList(boardSearch);
	}

	@Override
	public int getPrivateGpurchaseReplyCount(HashMap<String, Object> map) throws DataAccessException {
		// TODO Auto-generated method stub
		return myPageDao.getPrivateGpurchaseReplyCount(map);
	}

	@Override
	public List<Gpurchase> getPrivateGpurchaseReplyList(BoardSearch boardSearch) throws DataAccessException {
		// TODO Auto-generated method stub
		return myPageDao.getPrivateGpurchaseReplyList(boardSearch);
	}

	@Override
	public int getPrivateSecondhandReplyCount(HashMap<String, Object> map) throws DataAccessException {
		// TODO Auto-generated method stub
		return myPageDao.getPrivateSecondhandReplyCount(map);
	}

	@Override
	public List<Secondhand> getPrivateSecondhandReplyList(BoardSearch boardSearch) throws DataAccessException {
		// TODO Auto-generated method stub
		return myPageDao.getPrivateSecondhandReplyList(boardSearch);
	}

	@Override
	public int getPrivatePetsitterReplyCount(HashMap<String, Object> map) throws DataAccessException {
		// TODO Auto-generated method stub
		return myPageDao.getPrivatePetsitterReplyCount(map);
	}

	@Override
	public List<Petsitter> getPrivatePetsitterReplyList(BoardSearch boardSearch) throws DataAccessException {
		// TODO Auto-generated method stub
		return myPageDao.getPrivatePetsitterReplyList(boardSearch);
	}
}
