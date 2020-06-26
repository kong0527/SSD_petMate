package com.ssd.petMate.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.dao.DataAccessException;

import com.ssd.petMate.domain.Gpurchase;
import com.ssd.petMate.domain.GpurchaseCart;
import com.ssd.petMate.domain.GpurchaseCartCommand;
import com.ssd.petMate.domain.GpurchaseLineItem;
import com.ssd.petMate.domain.Info;
import com.ssd.petMate.domain.Secondhand;
import com.ssd.petMate.domain.SecondhandLineItem;
import com.ssd.petMate.page.BoardSearch;

public interface SLineItemFacade {

	public List<SecondhandLineItem> getSecondhandLineItemList(int orderNum) throws DataAccessException; //orderNum에 대한 
	
	public void insertSecondhandLineItem(SecondhandLineItem secondhandLineItem) throws DataAccessException; //공동구매 order에 대한 lineitem 추가
	
}