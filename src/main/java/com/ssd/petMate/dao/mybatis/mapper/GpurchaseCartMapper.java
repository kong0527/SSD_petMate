package com.ssd.petMate.dao.mybatis.mapper;

import java.util.HashMap;
import java.util.List;

import com.ssd.petMate.domain.GpurchaseCart;
import com.ssd.petMate.page.BoardSearch;
import com.ssd.petMate.page.pageMaker;

public interface GpurchaseCartMapper {
	
	public List<GpurchaseCart> getGpurchaseCartList(BoardSearch boardSearch); //장바구니 목록
	
	public int getGpurchaseCartCount(Integer userId); //장바구니 수 가져오기
	
	public void insertGpurchaseCart(GpurchaseCart gpurchaseCart); //장바구니 추가
	
	public void deleteGpurchaseCart(GpurchaseCart gpurchaseCart); //장바구니 삭제

}
