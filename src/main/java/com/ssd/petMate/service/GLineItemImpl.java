package com.ssd.petMate.service;

import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssd.petMate.dao.GLineItemDao;
import com.ssd.petMate.dao.GpurchaseCartDao;
import com.ssd.petMate.dao.GpurchaseDao;
import com.ssd.petMate.dao.InfoDao;
import com.ssd.petMate.dao.SecondhandDao;
import com.ssd.petMate.domain.Gpurchase;
import com.ssd.petMate.domain.GpurchaseCart;
import com.ssd.petMate.domain.GpurchaseCartCommand;
import com.ssd.petMate.domain.GpurchaseLineItem;
import com.ssd.petMate.domain.Info;
import com.ssd.petMate.domain.Secondhand;
import com.ssd.petMate.page.BoardSearch;

@Service
@Transactional
public class GLineItemImpl implements GLineItemFacade { 
	
	@Autowired
	private GLineItemDao gLineItemDao;

	
	public List<GpurchaseLineItem> getGpurchaseLineItemList(int orderNum) throws DataAccessException{
		return gLineItemDao.getGpurchaseLineItemList(orderNum);
	}
	
	public void insertGpurchaseLineItem(GpurchaseLineItem gpurchaseLineItem) throws DataAccessException{
		gLineItemDao.insertGpurchaseLineItem(gpurchaseLineItem);
	}

	
}