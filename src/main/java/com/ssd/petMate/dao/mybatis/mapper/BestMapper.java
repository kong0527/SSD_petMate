package com.ssd.petMate.dao.mybatis.mapper;

import java.util.Date;
import java.util.List;

import com.ssd.petMate.domain.Info;

public interface BestMapper {

	List<Info> bestInfo(Date date); 
}
