package com.ssd.petMate.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.dao.DataAccessException;

import com.ssd.petMate.domain.Info;
import com.ssd.petMate.domain.Secondhand;
import com.ssd.petMate.page.BoardSearch;

public interface InfoFacade {

	List<Info> getAllBoard(BoardSearch boardSearch);
	int boardPageCount(HashMap<String, Object> map);
	Info boardDetail(int boardNum);
	public void insertBoard(Info info); //게시글 작성
}