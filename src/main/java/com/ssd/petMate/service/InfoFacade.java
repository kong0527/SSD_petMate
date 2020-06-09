package com.ssd.petMate.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.dao.DataAccessException;

import com.ssd.petMate.domain.Info;
import com.ssd.petMate.domain.Secondhand;
import com.ssd.petMate.page.BoardSearch;

public interface InfoFacade {

	List<Info> getAllBoard(BoardSearch boardSearch);
	int boardPageCount(HashMap<String, Object> map);
	Info boardDetail(int boardNum);
	public void insertBoard(Info info); //게시글 작성

	public List<Secondhand> getSecondhandList(BoardSearch boardSearch) throws DataAccessException; //게시글 목록
	
	public int getSecondhandboardCount(HashMap<String, Object> map) throws DataAccessException; //게시글 수 가져오기
	
//	public int boardCount(); //게시글 개수 가져오기
	
	public void insertSecondhand(Secondhand secondhand) throws DataAccessException; //게시글 작성
	
	public Secondhand getSecondhandDetail(int boardNum) throws DataAccessException; //게시글 상세보기
	
	public void updateSecondhand(Secondhand secondhand) throws DataAccessException; //게시글 수정
	
	public void deleteSecondhand(int boardNum) throws DataAccessException; //게시글 삭제
	
}