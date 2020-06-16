package com.ssd.petMate.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.dao.DataAccessException;

import com.ssd.petMate.domain.Info;
import com.ssd.petMate.domain.Petsitter;
import com.ssd.petMate.domain.Secondhand;
import com.ssd.petMate.page.BoardSearch;

public interface InfoFacade {

	List<Info> getAllBoard(BoardSearch boardSearch);
	int boardPageCount(HashMap<String, Object> map);
	Info boardDetail(int boardNum);
	void insertBoard(Info info);
	void updateLike(Info info);
	void updateReplyCnt(Info info);
	public void updateBoard(Info info) throws DataAccessException; //게시글 수정
}