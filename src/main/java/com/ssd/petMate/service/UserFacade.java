package com.ssd.petMate.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.ssd.petMate.domain.UserList;

public interface UserFacade extends UserDetailsService{
	int countUserByUserID(String userID);
	UserList getUserByUserID(String userID);
	UserList getUserByUserIDAndPwd(UserList user);
	String getAthorityByUserID(String userID);
	void insertUser(UserList user);
	void updateUser(UserList user);
	void deleteUser(String userID);
	UserDetails loadUserByUsername(String username);
	int isPetsitter(String userID);
}
