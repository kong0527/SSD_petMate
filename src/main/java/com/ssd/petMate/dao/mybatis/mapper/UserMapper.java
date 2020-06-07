package com.ssd.petMate.dao.mybatis.mapper;

import com.ssd.petMate.domain.User;

//annotaion이 따로 없음 -> 이는 xml에서 정리가 되어있음
public interface UserMapper {

  User getUserByUserID(String userID);

  User getUserByUserIDAndPassword(String userID, String pwd);
  
  void insertUser(User user);

  void updateUser(User user);
  
  void deleteUser(User user);
}
