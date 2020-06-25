package com.ssd.petMate.dao.mybatis;

import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.ssd.petMate.dao.GpurchaseCartDao;
import com.ssd.petMate.dao.GpurchaseDao;
import com.ssd.petMate.dao.InfoDao;
import com.ssd.petMate.dao.OrderDao;
import com.ssd.petMate.dao.SecondhandDao;
import com.ssd.petMate.dao.mybatis.mapper.GpurchaseCartMapper;
import com.ssd.petMate.dao.mybatis.mapper.GpurchaseMapper;
import com.ssd.petMate.dao.mybatis.mapper.InfoMapper;
import com.ssd.petMate.dao.mybatis.mapper.OrderMapper;
import com.ssd.petMate.dao.mybatis.mapper.SecondhandMapper;
import com.ssd.petMate.domain.Gpurchase;
import com.ssd.petMate.domain.GpurchaseCart;
import com.ssd.petMate.domain.GpurchaseCartCommand;
import com.ssd.petMate.domain.Info;
import com.ssd.petMate.domain.Order;
import com.ssd.petMate.domain.Secondhand;
import com.ssd.petMate.page.BoardSearch;

@Repository
public class MybatisOrderDao implements OrderDao {

	@Autowired
	private OrderMapper orderMapper;
	
	public List<Order> getOrderList(int userID) throws DataAccessException{ //주문 목록 가져오기
		return orderMapper.getOrderList(userID);
	}

	public Order getOrder(Order order) throws DataAccessException{ //주문 상세정보 가져오기 
		return orderMapper.getOrder(order);
	}

	public void insertOrder(Order order) throws DataAccessException{
		orderMapper.insertOrder(order);
	}
	
}