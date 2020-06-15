package com.ssd.petMate.dao.mybatis.mapper;

import java.util.HashMap;
import java.util.List;

import com.ssd.petMate.domain.Info;
import com.ssd.petMate.page.BoardSearch;

public interface InfoMapper {
	public int boardPageCount(HashMap<String, Object> map); //게시판 페이징

	public List<Info> getAllBoard(BoardSearch boardSearch); //게시글 목록
		
	public void insertBoard(Info info); //게시글 작성
	
	public Info boardDetail(int boardNum); //게시글 상세보기
	
	public void updateBoard(Info info); //게시글 수정
	
	public void deleteBoard(int boardNum); //게시글 삭제
	
	public void boardViews(int boardNum); //조회수 증가
	
	public void updateLike(Info like);
	
	public void updateReplyCnt(Info info);
}
