package com.ssd.petMate.dao.mybatis;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.ssd.petMate.dao.MyPageDao;
import com.ssd.petMate.dao.mybatis.mapper.MyPageMapper;
import com.ssd.petMate.domain.Info;
import com.ssd.petMate.page.BoardSearch;

@Repository
public class MybatisMyPageDao implements MyPageDao{
	
	@Autowired
	private MyPageMapper myPageMapper;

	@Override
	public int getPrivateInfoCount(HashMap<String, Object> map) throws DataAccessException {
		// TODO Auto-generated method stub
		return myPageMapper.getPrivateInfoCount(map);
	}

	@Override
	public List<Info> getPrivateInfoList(BoardSearch boardSearch) throws DataAccessException {
		// TODO Auto-generated method stub
		return myPageMapper.getPrivateInfoList(boardSearch);
	}
}