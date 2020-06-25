package com.ssd.petMate.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.ssd.petMate.domain.Order;


public interface OrderFacade {

	public List<Order> getOrderList(int userID) throws DataAccessException; //게시글 목록
	
	public Order getOrder(Order order) throws DataAccessException; //게시글 수 가져오기
	
	public void insertGpurchase(Order order) throws DataAccessException; //게시글 작성
	
}