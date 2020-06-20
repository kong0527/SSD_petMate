package com.ssd.petMate.dao.mybatis;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.ssd.petMate.dao.BestDao;
import com.ssd.petMate.dao.mybatis.mapper.BestMapper;
import com.ssd.petMate.domain.Info;

@Repository
public class MybatisBestDao implements BestDao{
	@Autowired
	private BestMapper bestMapper;

	@Override
	public List<Info> bestInfo(Date date) throws DataAccessException {
		// TODO Auto-generated method stub
		return bestMapper.bestInfo(date);
	}
}
