package com.ssd.petMate.dao;

import org.springframework.dao.DataAccessException;

import com.ssd.petMate.domain.UserList;

public interface UserDao {
	public UserList getUserByUserIDAndPwd(UserList user) throws DataAccessException;
	public void insertUser(UserList user) throws DataAccessException;
	public int countUserByUserID(String userID) throws DataAccessException;
	public UserList getUserByUserID(String userID) throws DataAccessException;
	public String getAthorityByUserID(String userID) throws DataAccessException;
	public void updateUser(UserList user) throws DataAccessException;
	public void deleteUser(String userID) throws DataAccessException;
}
