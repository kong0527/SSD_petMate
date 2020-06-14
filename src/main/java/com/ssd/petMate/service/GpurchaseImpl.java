package com.ssd.petMate.service;

import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssd.petMate.dao.GpurchaseCartDao;
import com.ssd.petMate.dao.GpurchaseDao;
import com.ssd.petMate.dao.InfoDao;
import com.ssd.petMate.dao.SecondhandDao;
import com.ssd.petMate.domain.Gpurchase;
import com.ssd.petMate.domain.GpurchaseCart;
import com.ssd.petMate.domain.Info;
import com.ssd.petMate.domain.Secondhand;
import com.ssd.petMate.page.BoardSearch;

@Service
@Transactional
public class GpurchaseImpl implements GpurchaseFacade { 
	
	@Autowired
	private GpurchaseDao gpurchaseDao;
	
	@Autowired
	private GpurchaseCartDao gpurchaseCartDao;
	 
	
	public List<Gpurchase> getGpurchaseList(BoardSearch boardSearch) throws DataAccessException{
		return gpurchaseDao.getGpurchaseList(boardSearch);
	}
	
	public int getGpurchaseBoardCount(HashMap<String, Object> map) throws DataAccessException {
		return gpurchaseDao.getGpurchaseBoardCount(map);
	}
		
	public void insertGpurchase(Gpurchase gpurchase) throws DataAccessException{
		gpurchaseDao.insertGpurchase(gpurchase);
	}
		
	public Gpurchase getGpurchaseDetail(int boardNum) throws DataAccessException{
		return gpurchaseDao.getGpurchaseDetail(boardNum);
	}
		
	public void updateGpurchase(Gpurchase gpurchase) throws DataAccessException{
		gpurchaseDao.updateGpurchase(gpurchase);
	}
		
	public void deleteGpurchase(int boardNum) throws DataAccessException{
		gpurchaseDao.deleteGpurchase(boardNum);
	}
	
	public int getGpurchaseCartCount(int userId) throws DataAccessException{ //장바구니 수 가져오기
		return gpurchaseCartDao.getGpurchaseCartCount(userId);
	}
	
	public void insertGpurchaseCart(GpurchaseCart gpurchaseCart) throws DataAccessException{
		gpurchaseCartDao.insertGpurchaseCart(gpurchaseCart);
	} //장바구니 추가
	
	public void deleteGpurchaseCart(GpurchaseCart gpurchaseCart) throws DataAccessException{
		gpurchaseCartDao.deleteGpurchaseCart(gpurchaseCart);
	} //장바구니 삭제
	
	public List<GpurchaseCart> getGpurchaseCartListByGpurchase(String userID) throws DataAccessException{
		return gpurchaseCartDao.getGpurchaseCartListByGpurchase(userID);
	} //cart+gpuchase
}