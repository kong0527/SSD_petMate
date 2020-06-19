package com.ssd.petMate.service;

import java.util.HashMap;
import java.util.List;

import com.ssd.petMate.domain.Info;
import com.ssd.petMate.page.BoardSearch;

public interface MyPageFacade {

	int getPrivateInfoCount(HashMap<String, Object> map); 

	List<Info> getPrivateInfoList(BoardSearch boardSearch);
}