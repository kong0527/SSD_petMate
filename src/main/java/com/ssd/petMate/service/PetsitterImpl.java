package com.ssd.petMate.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssd.petMate.dao.PetsitterDao;
import com.ssd.petMate.domain.Petsitter;
import com.ssd.petMate.page.BoardSearch;

@Service
@Transactional
public class PetsitterImpl implements PetsitterFacade {
	
	@Autowired
	private PetsitterDao petsitterDao;
	
	@Override
	public List<Petsitter> getAllBoard(BoardSearch boardSearch) {
		return petsitterDao.getAllBoard(boardSearch);
	}

	@Override
	public int boardPageCount(HashMap<String, Object> map) {
		return petsitterDao.boardPageCount(map);
	}

	@Override
	public Petsitter boardDetail(int boardNum) {
		return petsitterDao.boardDetail(boardNum);
	}

}