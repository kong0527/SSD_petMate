package com.ssd.petMate.dao.mybatis.mapper;

import java.util.HashMap;
import java.util.List;

import com.ssd.petMate.domain.InfoReply;
import com.ssd.petMate.page.pageMaker;

public interface InfoReplyMapper {

	List<InfoReply> getReplyList(pageMaker page);
	
	void insertReply(InfoReply reply);
	
	void updateReply(InfoReply reply);
	
	void deleteReply(int replyNum);
	
	InfoReply getReply(int replyNum);
	
	int replyCount(int boardNum);
	
	void setReplyOrder(HashMap<String, Object> map);
	
	int findLastReplyID(int replyNum);
	
	int countSameGID(int replyNum);
}
