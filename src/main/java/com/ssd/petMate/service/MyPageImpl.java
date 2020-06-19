package com.ssd.petMate.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssd.petMate.dao.MyPageDao;
import com.ssd.petMate.domain.Info;
import com.ssd.petMate.page.BoardSearch;

@Service
@Transactional
public class MyPageImpl implements MyPageFacade {
	@Autowired
	private MyPageDao myPageDao;

	@Override
	public int getPrivateInfoCount(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return myPageDao.getPrivateInfoCount(map);
	}

	@Override
	public List<Info> getPrivateInfoList(BoardSearch boardSearch) {
		// TODO Auto-generated method stub
		return myPageDao.getPrivateInfoList(boardSearch);
	}
}
