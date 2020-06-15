package com.ssd.petMate.dao.mybatis.mapper;

import java.util.HashMap;
import java.util.List;

import com.ssd.petMate.domain.Petsitter;
import com.ssd.petMate.page.BoardSearch;

public interface PetsitterMapper {
	public int boardPageCount(HashMap<String, Object> map); //게시판 페이징
	
	public List<Petsitter> getAllBoard(BoardSearch boardSearch); //게시글 목록
	
	public int boardCount(); //게시글 개수 가져오기
	
	public void insertBoard(Petsitter petsitter); //게시글 작성
	
	public Petsitter boardDetail(int boardNum); //게시글 상세보기
	
	public void updateBoard(Petsitter petsitter); //게시글 수정
	
	public void deleteBoard(int boardNum); //게시글 삭제
	
	public void plusReplyCnt(int boardNum); //덧글수 증가
	
	public void minusReplynt(int boardNum); //덧글수 감소
	
	public void boardViews(int boardNum); //조회수 증가
	
	public List<Petsitter> filtering(); //필터링 기능
	
	public void plusLike(int boardNum); //좋아요 수 증가
	
	public void minusLike(int boardNum); //좋아요 수 감소
	
	public void updateLike(Petsitter petsitter);
}
