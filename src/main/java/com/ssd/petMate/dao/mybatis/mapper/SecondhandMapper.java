package com.ssd.petMate.dao.mybatis.mapper;

import java.util.HashMap;
import java.util.List;

import com.ssd.petMate.domain.Secondhand;
import com.ssd.petMate.page.BoardSearch;
import com.ssd.petMate.page.pageMaker;

public interface SecondhandMapper {
	
	public List<Secondhand> getSecondhandList(BoardSearch boardSearch); //게시글 목록
	
	public int getSecondhandboardCount(HashMap<String, Object> map); //게시글 수 가져오
	
//	public int boardCount(); //게시글 개수 가져오기
	
	public void insertSecondhand(Secondhand secondhand); //게시글 작성
	
	public Secondhand getSecondhandDetail(int boardNum); //게시글 상세보기
	
	public void updateSecondhand(Secondhand secondhand); //게시글 수정
	
	public void deleteSecondhand(int boardNum); //게시글 삭제
	
//	public void secondhandReplyCntPlus(int boardNum); //덧글수 증가
//	
//	public void secondhandReplyCntMinus(int boardNum); //덧글수 감소
//	
//	public void secondhandBoardHitPluss(int boardNum); //조회수 증가
//	
//	public void secondhandCartPlus(int boardNum); //장바구니 담은 수 증가
//	
//	public void secondhandCartMinus(int boardNum); //장바구니 담은 수 감소
	
}
