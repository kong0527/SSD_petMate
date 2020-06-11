package com.ssd.petMate.service;

import java.util.HashMap;
import java.util.List;

import com.ssd.petMate.domain.Info;
import com.ssd.petMate.domain.Petsitter;
import com.ssd.petMate.page.BoardSearch;

public interface PetsitterFacade {
	List<Petsitter> getAllBoard(BoardSearch boardSearch);
	int boardPageCount(HashMap<String, Object> map);
	Petsitter boardDetail(int boardNum);
	public void insertBoard(Petsitter petsitter); //게시글 작성
	public void deleteBoard(int boardNum); //게시글 삭제
}
