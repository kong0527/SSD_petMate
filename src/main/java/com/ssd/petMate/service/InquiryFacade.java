package com.ssd.petMate.service;

import java.util.HashMap;
import java.util.List;

import com.ssd.petMate.domain.Inquiry;
import com.ssd.petMate.page.BoardSearch;

public interface InquiryFacade {
	List<Inquiry> getAllBoard(BoardSearch boardSearch);
	int boardPageCount(HashMap<String, Object> map);
}
