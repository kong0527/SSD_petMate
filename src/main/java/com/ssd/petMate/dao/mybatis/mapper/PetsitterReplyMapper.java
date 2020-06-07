package com.ssd.petMate.dao.mybatis.mapper;

import java.util.HashMap;
import java.util.List;

import com.ssd.petMate.domain.PetsitterReply;
import com.ssd.petMate.page.pageMaker;

public interface PetsitterReplyMapper {

	List<PetsitterReply> getReplyList(pageMaker page);
	
	void insertReply(PetsitterReply reply);
	
	void updateReply(PetsitterReply reply);
	
	void deleteReply(int replyNum);
	
	PetsitterReply getReply(int replyNum);
	
	int replyCount(int boardNum);
	
	void setReplyOrder(HashMap<String, Object> map);
	
	int findLastReplyID(int replyNum);
	
	int countSameGID(int replyNum);
}
