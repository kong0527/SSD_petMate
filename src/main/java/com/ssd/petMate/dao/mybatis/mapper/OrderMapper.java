/*
 *    Copyright 2010-2013 the original author or authors.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package com.ssd.petMate.dao.mybatis.mapper;

import java.util.List;

import com.ssd.petMate.domain.Order;

/**
 * @author Eduardo Macarron
 */
public interface OrderMapper {

  List<Order> getOrderList(int userID); // 주문 목록 가져오기
  
  Order getOrder(Order order); //주문 정보 가져오기
  
  void insertOrder(Order order); //주문 추가하기
  
}
