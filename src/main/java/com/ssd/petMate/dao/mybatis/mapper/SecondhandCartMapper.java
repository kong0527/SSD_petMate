package com.ssd.petMate.dao.mybatis.mapper;

import java.util.HashMap;
import java.util.List;

import com.ssd.petMate.domain.SecondhandCart;
import com.ssd.petMate.page.BoardSearch;
import com.ssd.petMate.page.pageMaker;

public interface SecondhandCartMapper {
	
	public List<SecondhandCart> getSecondhandCartList(BoardSearch boardSearch); //장바구니 목록
	
	public int getSecondhandCartCount(Integer userId); //장바구니 수 가져오기
	
	public void insertSecondhandCart(SecondhandCart secondhandCart); //장바구니 추가
	
	public void deleteSecondhandCart(SecondhandCart secondhandCart); //장바구니 삭

}
