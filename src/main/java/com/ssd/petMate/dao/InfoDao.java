package com.ssd.petMate.dao;

import java.util.HashMap;
import java.util.List;
import org.springframework.dao.DataAccessException;

import com.ssd.petMate.domain.Info;
import com.ssd.petMate.page.BoardSearch;

public interface InfoDao {
	public List<Info> getAllBoard(BoardSearch boardSearch) throws DataAccessException;
	public int boardPageCount(HashMap<String, Object> map) throws DataAccessException;
}
