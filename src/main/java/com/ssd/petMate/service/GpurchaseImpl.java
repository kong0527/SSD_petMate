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
import com.ssd.petMate.domain.GpurchaseCartCommand;
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
	
	public void gpurchaseCartPlus(int boardNum) throws DataAccessException{
		gpurchaseDao.gpurchaseCartPlus(boardNum);
	} //장바구니 담은 수 증가
	
	public void gpurchaseCartMinus(int boardNum) throws DataAccessException{
		gpurchaseDao.gpurchaseCartPlus(boardNum);
	} //장바구니 담은 수 감소
	
	public List<GpurchaseCartCommand> getGpurchaseCartListByGpurchase(String userID) throws DataAccessException{
		return gpurchaseCartDao.getGpurchaseCartListByGpurchase(userID);
	} //cart+gpuchase
	
	public int getGpurchaseCartCount(int userId) throws DataAccessException{ //사용자가 담은 장바구니 수 가져오기
		return gpurchaseCartDao.getGpurchaseCartCount(userId);
	}
	
	public void insertGpurchaseCart(GpurchaseCart gpurchaseCart) throws DataAccessException{ //장바구니 추가
		gpurchaseCartDao.insertGpurchaseCart(gpurchaseCart);
	}
	
	public void deleteGpurchaseCart(GpurchaseCart gpurchaseCart) throws DataAccessException{  //장바구니 삭제
		gpurchaseCartDao.deleteGpurchaseCart(gpurchaseCart);
	}
	
	public int countCartByboardNum(int boardNum) { // 게시글에 대한 담은 장바구니 총 개수
		return gpurchaseCartDao.countCartByboardNum(boardNum);
	}
	
	public int isCart(GpurchaseCart gpurchaseCart) { //이 게시글을 사용자가 담았는지 확인
		return gpurchaseCartDao.isCart(gpurchaseCart);
	}
}