package com.ssd.petMate.dao;

import java.util.HashMap;
import java.util.List;
import org.springframework.dao.DataAccessException;

import com.ssd.petMate.domain.Gpurchase;
import com.ssd.petMate.domain.GpurchaseCart;
import com.ssd.petMate.domain.Info;
import com.ssd.petMate.domain.Secondhand;
import com.ssd.petMate.page.BoardSearch;

public interface GpurchaseCartDao {

//	public List<GpurchaseCart> getGpurchaseCartList(BoardSearch boardSearch) throws DataAccessException; //장바구니 목록
//	
	public int getGpurchaseCartCount(int userId) throws DataAccessException; //장바구니 수 가져오기
	
	public void insertGpurchaseCart(GpurchaseCart gpurchaseCart) throws DataAccessException; //장바구니 추가
	
	public void deleteGpurchaseCart(GpurchaseCart gpurchaseCart) throws DataAccessException; //장바구니 삭제
	
	public List<GpurchaseCart> getGpurchaseCartListByGpurchase(String userID) throws DataAccessException; //cart+gpuchase
}
