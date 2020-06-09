package com.ssd.petMate.service;

import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ssd.petMate.dao.InfoDao;
import com.ssd.petMate.domain.Info;
import com.ssd.petMate.page.BoardSearch;

@Service
@Transactional
public class InfoImpl implements InfoFacade { 
	@Autowired
	private InfoDao infoDao;

	//-------------------------------------------------------------------------
	// Operation methods, implementing the PetStoreFacade interface
	//-------------------------------------------------------------------------
	public List<Info> getAllBoard(BoardSearch boardSearch){
		return infoDao.getAllBoard(boardSearch);
	}
	
	public int boardPageCount(HashMap<String, Object> map) {
		return infoDao.boardPageCount(map);
	}
	
	public Info boardDetail(int boardNum) {
		return infoDao.boardDetail(boardNum);
	}

	public void insertBoard(Info info) {
		infoDao.insertBoard(info);
	}
}