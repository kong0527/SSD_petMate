package com.ssd.petMate.service;

import java.util.HashMap;
import java.util.List;

import com.ssd.petMate.domain.Review;
import com.ssd.petMate.page.BoardSearch;

public interface ReviewFacade {
	List<Review> getAllBoard(BoardSearch boardSearch);
	int boardPageCount(HashMap<String, Object> map);
	Review boardDetail(int boardNum);
	public void insertBoard(Review review); //게시글 작성
}
