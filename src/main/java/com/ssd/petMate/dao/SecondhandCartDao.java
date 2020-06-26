package com.ssd.petMate.dao;

import java.util.HashMap;
import java.util.List;
import org.springframework.dao.DataAccessException;

import com.ssd.petMate.domain.Gpurchase;
import com.ssd.petMate.domain.GpurchaseCart;
import com.ssd.petMate.domain.GpurchaseCartCommand;
import com.ssd.petMate.domain.Info;
import com.ssd.petMate.domain.Secondhand;
import com.ssd.petMate.domain.SecondhandCart;
import com.ssd.petMate.domain.SecondhandCartCommand;
import com.ssd.petMate.page.BoardSearch;

public interface SecondhandCartDao {

//	public List<GpurchaseCart> getGpurchaseCartList(BoardSearch boardSearch) throws DataAccessException; //장바구니 목록
//	
	public int getSecondhandCartCount(int userId) throws DataAccessException; //장바구니 수 가져오기
	
	public void insertSecondhandCart(SecondhandCart secondhandCart) throws DataAccessException; //장바구니 추가
	
	public void deleteSecondhandCart(SecondhandCart secondhandCart) throws DataAccessException; //장바구니 삭제
	
	public List<SecondhandCartCommand> getSecondhandCartListBySecondhand(String userID) throws DataAccessException; //cart+gpuchase
	
	public int countCartByboardNum(int boardNum); // 게시글에 대한 담은 장바구니 총 개수
	
	public int isCart(SecondhandCart secondhandCart); //이 게시글을 사용자가 담았는지 확인
}
