package com.ssd.petMate.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssd.petMate.dao.BestDao;
import com.ssd.petMate.domain.Info;

@Service
@Transactional
public class BestImpl implements BestFacade{

	@Autowired
	private BestDao bestDao;

	@Override
	public List<Info> bestInfo(Date date) {
		// TODO Auto-generated method stub
		return bestDao.bestInfo(date);
	}
}
