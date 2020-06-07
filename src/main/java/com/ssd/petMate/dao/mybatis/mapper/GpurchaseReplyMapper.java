package com.ssd.petMate.dao.mybatis.mapper;

import java.util.HashMap;
import java.util.List;

import com.ssd.petMate.domain.GpurchaseReply;
import com.ssd.petMate.page.pageMaker;

public interface GpurchaseReplyMapper {

	List<GpurchaseReply> getReplyList(pageMaker page);
	
	void insertReply(GpurchaseReply reply);
	
	void updateReply(GpurchaseReply reply);
	
	void deleteReply(int replyNum);
	
	GpurchaseReply getReply(int replyNum);
	
	int replyCount(int boardNum);
	
	void setReplyOrder(HashMap<String, Object> map);
	
	int findLastReplyID(int replyNum);
	
	int countSameGID(int replyNum);
}
