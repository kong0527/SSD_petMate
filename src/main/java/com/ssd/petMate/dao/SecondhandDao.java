package com.ssd.petMate.dao;

import java.util.HashMap;
import java.util.List;
import org.springframework.dao.DataAccessException;

import com.ssd.petMate.domain.Info;
import com.ssd.petMate.domain.Secondhand;
import com.ssd.petMate.page.BoardSearch;

public interface SecondhandDao {
//	public List<Info> getAllBoard(BoardSearch boardSearch) throws DataAccessException;
//	public int boardPageCount(HashMap<String, Object> map) throws DataAccessException;
//	public Info boardDetail(int boardNum) throws DataAccessException;
	
	public List<Secondhand> getSecondhandList(BoardSearch boardSearch) throws DataAccessException; //게시글 목록
	
	public int getSecondhandboardCount(HashMap<String, Object> map) throws DataAccessException; //게시글 수 가져오기
	
//	public int boardCount(); //게시글 개수 가져오기
	
	public void insertSecondhand(Secondhand secondhand) throws DataAccessException; //게시글 작성
	
	public Secondhand getSecondhandDetail(int boardNum) throws DataAccessException; //게시글 상세보기
	
	public void updateSecondhand(Secondhand secondhand) throws DataAccessException; //게시글 수정
	
	public void deleteSecondhand(int boardNum) throws DataAccessException; //게시글 삭제
	
	
	
//	public void secondhandReplyCntPlus(int boardNum) throws DataAccessException; //덧글수 증가
//	
//	public void secondhandReplyCntMinus(int boardNum) throws DataAccessException; //덧글수 감소
//	
//	public void secondhandBoardHitPluss(int boardNum) throws DataAccessException; //조회수 증가
//	
//	public void secondhandCartPlus(int boardNum) throws DataAccessException; //장바구니 담은 수 증가
//	
//	public void secondhandCartMinus(int boardNum) throws DataAccessException; //장바구니 담은 수 감소
}
