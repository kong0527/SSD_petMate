package com.ssd.petMate.service;

import java.util.Date;
import java.util.List;

import com.ssd.petMate.domain.Info;

public interface BestFacade {
	List<Info> bestInfo(Date date); 
}
