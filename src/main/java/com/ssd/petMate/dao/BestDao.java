package com.ssd.petMate.dao;

import java.util.Date;
import java.util.List;

import org.springframework.dao.DataAccessException;

import com.ssd.petMate.domain.Info;

public interface BestDao {
	List<Info> weeklyBestInfo(Date date) throws DataAccessException;
	Info dailyBestInfo() throws DataAccessException;
}
