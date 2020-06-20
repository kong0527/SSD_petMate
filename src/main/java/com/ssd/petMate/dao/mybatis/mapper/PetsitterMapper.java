package com.ssd.petMate.dao.mybatis.mapper;

import java.util.HashMap;
import java.util.List;

import com.ssd.petMate.Controller.FilteringCommand;
import com.ssd.petMate.domain.Petsitter;
import com.ssd.petMate.page.BoardSearch;

public interface PetsitterMapper {
	int boardPageCount(HashMap<String, Object> map); //게시판 페이징
	
	List<Petsitter> getAllBoard(BoardSearch boardSearch); //게시글 목록
	
	int boardCount(); //게시글 개수 가져오기
	
	void insertBoard(Petsitter petsitter); //게시글 작성
	
	Petsitter boardDetail(int boardNum); //게시글 상세보기
	
	void updateBoard(Petsitter petsitter); //게시글 수정
	
	void deleteBoard(int boardNum); //게시글 삭제
	
	void plusReplyCnt(int boardNum); //덧글수 증가
	
	void minusReplynt(int boardNum); //덧글수 감소
	
	void boardViews(int boardNum); //조회수 증가
	
	void plusLike(int boardNum); //좋아요 수 증가
	
	void minusLike(int boardNum); //좋아요 수 감소
	
	void updateLike(Petsitter petsitter);
	
	void updateReplyCnt(Petsitter petistter);
	
	void updateViews(int boardNum); //조회수 증가

	List<Petsitter> filtering(FilteringCommand filter);
}
