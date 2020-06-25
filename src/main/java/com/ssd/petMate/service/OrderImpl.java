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
import com.ssd.petMate.dao.OrderDao;
import com.ssd.petMate.dao.SecondhandDao;
import com.ssd.petMate.domain.Gpurchase;
import com.ssd.petMate.domain.GpurchaseCart;
import com.ssd.petMate.domain.GpurchaseCartCommand;
import com.ssd.petMate.domain.Info;
import com.ssd.petMate.domain.Order;
import com.ssd.petMate.domain.Secondhand;
import com.ssd.petMate.page.BoardSearch;

@Service
@Transactional
public class OrderImpl implements OrderFacade { 
	
	@Autowired
	private OrderDao orderDao;
	
//	@Autowired
//	private GpurchaseCartDao gpurchaseCartDao;
	
	public List<Order> getOrderList(int userID) throws DataAccessException{ //주문 목록 가져오기 
		return orderDao.getOrderList(userID);
	}
	
	public Order getOrder(Order order) throws DataAccessException{ // 주문 상세정보 가져오기
		return orderDao.getOrder(order);
	}
	
	public void insertGpurchase(Order order) throws DataAccessException{ // 주문 생성
		orderDao.insertOrder(order);
	}
	
}