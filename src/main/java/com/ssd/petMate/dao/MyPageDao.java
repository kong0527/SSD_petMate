package com.ssd.petMate.dao;

import java.util.HashMap;
import java.util.List;

import org.springframework.dao.DataAccessException;

import com.ssd.petMate.domain.Info;
import com.ssd.petMate.page.BoardSearch;

public interface MyPageDao {
	int getPrivateInfoCount(HashMap<String, Object> map) throws DataAccessException; 

	List<Info> getPrivateInfoList(BoardSearch boardSearch) throws DataAccessException; 
}