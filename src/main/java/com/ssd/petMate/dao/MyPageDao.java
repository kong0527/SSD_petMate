package com.ssd.petMate.dao;

import java.util.HashMap;
import java.util.List;

import org.springframework.dao.DataAccessException;

import com.ssd.petMate.domain.Gpurchase;
import com.ssd.petMate.domain.Info;
import com.ssd.petMate.domain.Inquiry;
import com.ssd.petMate.domain.Petsitter;
import com.ssd.petMate.domain.Review;
import com.ssd.petMate.domain.Secondhand;
import com.ssd.petMate.page.BoardSearch;

public interface MyPageDao {
	int getPrivateInfoCount(HashMap<String, Object> map) throws DataAccessException; 

	List<Info> getPrivateInfoList(BoardSearch boardSearch) throws DataAccessException; 
	
	int getPrivateInquiryReplyCount(HashMap<String, Object> map) throws DataAccessException; 

	List<Inquiry> getPrivateInquiryReplyList(BoardSearch boardSearch) throws DataAccessException;
	
	int getPrivateInfoReplyCount(HashMap<String, Object> map) throws DataAccessException; 

	List<Info> getPrivateInfoReplyList(BoardSearch boardSearch) throws DataAccessException; 
	
	int getPrivateGpurchaseReplyCount(HashMap<String, Object> map) throws DataAccessException; 

	List<Gpurchase> getPrivateGpurchaseReplyList(BoardSearch boardSearch) throws DataAccessException;
	
	int getPrivateSecondhandReplyCount(HashMap<String, Object> map) throws DataAccessException; 

	List<Secondhand> getPrivateSecondhandReplyList(BoardSearch boardSearch) throws DataAccessException;
	
	int getPrivatePetsitterReplyCount(HashMap<String, Object> map) throws DataAccessException; 

	List<Petsitter> getPrivatePetsitterReplyList(BoardSearch boardSearch) throws DataAccessException; 
	
	int getPrivateReviewReplyCount(HashMap<String, Object> map) throws DataAccessException; 

	List<Review> getPrivateReviewReplyList(BoardSearch boardSearch) throws DataAccessException; 
}