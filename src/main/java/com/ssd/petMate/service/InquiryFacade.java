package com.ssd.petMate.service;

import java.util.HashMap;
import java.util.List;

import com.ssd.petMate.domain.Inquiry;
import com.ssd.petMate.page.BoardSearch;

public interface InquiryFacade {
	List<Inquiry> getAllBoard(BoardSearch boardSearch);
	int boardPageCount(HashMap<String, Object> map);
	Inquiry boardDetail(int boardNum);
	public void insertBoard(Inquiry inquiry); //게시글 작성
	void updateLike(Inquiry inquiry);
	void updateReplyCnt(Inquiry inquiry);
}
