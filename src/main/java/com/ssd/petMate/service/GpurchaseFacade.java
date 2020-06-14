package com.ssd.petMate.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.dao.DataAccessException;

import com.ssd.petMate.domain.Gpurchase;
import com.ssd.petMate.domain.GpurchaseCart;
import com.ssd.petMate.domain.Info;
import com.ssd.petMate.domain.Secondhand;
import com.ssd.petMate.page.BoardSearch;

public interface GpurchaseFacade {

	public List<Gpurchase> getGpurchaseList(BoardSearch boardSearch) throws DataAccessException; //게시글 목록
	
	public int getGpurchaseBoardCount(HashMap<String, Object> map) throws DataAccessException; //게시글 수 가져오기
	
//	public int boardCount(); //게시글 개수 가져오기
	
	public void insertGpurchase(Gpurchase gpurchase) throws DataAccessException; //게시글 작성
	
	public Gpurchase getGpurchaseDetail(int boardNum) throws DataAccessException; //게시글 상세보기
	
	public void updateGpurchase(Gpurchase gpurchase) throws DataAccessException; //게시글 수정
	
	public void deleteGpurchase(int boardNum) throws DataAccessException; //게시글 삭제
	
	
	public int getGpurchaseCartCount(int userId) throws DataAccessException; //장바구니 수 가져오기
	
	public void insertGpurchaseCart(GpurchaseCart gpurchaseCart) throws DataAccessException; //장바구니 추가
	
	public void deleteGpurchaseCart(GpurchaseCart gpurchaseCart) throws DataAccessException; //장바구니 삭제
	
	public List<GpurchaseCart> getGpurchaseCartListByGpurchase(String userID) throws DataAccessException; //cart+gpuchase
}