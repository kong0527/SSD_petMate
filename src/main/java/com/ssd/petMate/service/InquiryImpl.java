package com.ssd.petMate.service;

import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ssd.petMate.dao.InquiryDao;
import com.ssd.petMate.domain.Inquiry;
import com.ssd.petMate.page.BoardSearch;

@Service
@Transactional
public class InquiryImpl implements InquiryFacade { 
	@Autowired
	private InquiryDao inquiryDao;

	//-------------------------------------------------------------------------
	// Operation methods, implementing the PetStoreFacade interface
	//-------------------------------------------------------------------------
	public List<Inquiry> getAllBoard(BoardSearch boardSearch){
		return inquiryDao.getAllBoard(boardSearch);
	}
	
	public int boardPageCount(HashMap<String, Object> map) {
		return inquiryDao.boardPageCount(map);
	}
}