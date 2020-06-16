package com.ssd.petMate.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.ssd.petMate.domain.Order;

public interface OrderDao {

  List<Order> getOrderList(int userID) throws DataAccessException;

  Order getOrder(Order order) throws DataAccessException;

  void insertOrder(Order order) throws DataAccessException;

}
