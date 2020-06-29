package com.ssd.petMate.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.dao.DataAccessException;

import com.ssd.petMate.Controller.FilteringCommand;
import com.ssd.petMate.domain.Gpurchase;
import com.ssd.petMate.domain.Info;
import com.ssd.petMate.domain.Petsitter;
import com.ssd.petMate.page.BoardSearch;

public interface PetsitterFacade {
	List<Petsitter> getAllBoard(BoardSearch boardSearch);
	
	int boardPageCount(HashMap<String, Object> map);
	
	Petsitter boardDetail(int boardNum);
	
	void insertBoard(Petsitter petsitter); //게시글 작성
	
	void deleteBoard(int boardNum); //게시글 삭제
	
	void updateLike(Petsitter petsitter);
	
	void updateReplyCnt(Petsitter petsitter);
	
	void updateBoard(Petsitter petsitter) throws DataAccessException; //게시글 수정
	
	void updateViews(int boardNum); //조회수 증가
	
	List<Petsitter> filtering(FilteringCommand filter);
	
	void selectPetsitter(HashMap<String, Object> map);
	
	int filteringCount(FilteringCommand filter);
}
