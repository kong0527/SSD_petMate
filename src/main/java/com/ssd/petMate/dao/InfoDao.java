package com.ssd.petMate.dao;

import java.util.HashMap;
import java.util.List;
import org.springframework.dao.DataAccessException;

import com.ssd.petMate.domain.Info;
import com.ssd.petMate.domain.Petsitter;
import com.ssd.petMate.page.BoardSearch;

public interface InfoDao {
	public List<Info> getAllBoard(BoardSearch boardSearch) throws DataAccessException;
	public int boardPageCount(HashMap<String, Object> map) throws DataAccessException;
	public Info boardDetail(int boardNum) throws DataAccessException;
	public void insertBoard(Info info) throws DataAccessException; //게시글 작성
	public void updateLike(Info info) throws DataAccessException;
	public void updateReplyCnt(Info info) throws DataAccessException;
	public void updateBoard(Info info) throws DataAccessException; //게시글 수정
}
