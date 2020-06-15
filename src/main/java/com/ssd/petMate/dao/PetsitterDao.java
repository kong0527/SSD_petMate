package com.ssd.petMate.dao;

import java.util.HashMap;
import java.util.List;

import org.springframework.dao.DataAccessException;

import com.ssd.petMate.domain.Info;
import com.ssd.petMate.domain.Petsitter;
import com.ssd.petMate.page.BoardSearch;

public interface PetsitterDao {
	List<Petsitter> getAllBoard(BoardSearch boardSearch) throws DataAccessException;
	int boardPageCount(HashMap<String, Object> map) throws DataAccessException;
	Petsitter boardDetail(int boardNum) throws DataAccessException;
	void insertBoard(Petsitter petsitter); //게시글 작성
	void deleteBoard(int boardNum); //게시글 삭제
	void updateLike(Petsitter petsitter);
}
