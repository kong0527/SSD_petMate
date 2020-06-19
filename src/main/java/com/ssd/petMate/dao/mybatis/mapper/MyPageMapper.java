package com.ssd.petMate.dao.mybatis.mapper;

import java.util.HashMap;
import java.util.List;

import com.ssd.petMate.domain.Info;
import com.ssd.petMate.page.BoardSearch;

public interface MyPageMapper {
	int getPrivateInfoCount(HashMap<String, Object> map); 

	List<Info> getPrivateInfoList(BoardSearch boardSearch); 
}