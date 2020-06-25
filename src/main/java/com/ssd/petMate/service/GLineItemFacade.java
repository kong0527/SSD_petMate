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
import com.ssd.petMate.page.BoardSearch;

public interface GLineItemFacade {

	public List<GpurchaseLineItem> getGpurchaseLineItemList(int orderNum) throws DataAccessException; //orderNum에 대한 lineitem List
	
	public void insertGpurchaseLineItem(GpurchaseLineItem gpurchaseLineItem) throws DataAccessException; // lineItem 생성
	
}