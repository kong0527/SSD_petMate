package com.ssd.petMate.service;

import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ssd.petMate.dao.InfoDao;
import com.ssd.petMate.dao.SecondhandDao;
import com.ssd.petMate.domain.Info;
import com.ssd.petMate.domain.Secondhand;
import com.ssd.petMate.page.BoardSearch;

@Service
@Transactional
public class InfoImpl implements InfoFacade { 
	
	@Autowired
	private InfoDao infoDao;
	
	@Autowired
	private SecondhandDao secondhandDao;

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
	
	public List<Secondhand> getSecondhandList(BoardSearch boardSearch) throws DataAccessException{
		return secondhandDao.getSecondhandList(boardSearch);
	}
	
	public int getSecondhandboardCount(HashMap<String, Object> map) throws DataAccessException {
		return secondhandDao.getSecondhandboardCount(map);
	}
		
	public void insertSecondhand(Secondhand secondhand) throws DataAccessException{
		secondhandDao.insertSecondhand(secondhand);
	}
		
	public Secondhand getSecondhandDetail(int boardNum) throws DataAccessException{
		return secondhandDao.getSecondhandDetail(boardNum);
	}
		
	public void updateSecondhand(Secondhand secondhand) throws DataAccessException{
		secondhandDao.updateSecondhand(secondhand);
	}
		
	public void deleteSecondhand(int boardNum) throws DataAccessException{
		secondhandDao.deleteSecondhand(boardNum);
	}
	
}