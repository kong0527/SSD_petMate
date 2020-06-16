package com.ssd.petMate.dao.mybatis;

import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.ssd.petMate.dao.ReviewDao;
import com.ssd.petMate.dao.mybatis.mapper.ReviewMapper;
import com.ssd.petMate.domain.Review;
import com.ssd.petMate.page.BoardSearch;

@Repository
public class MybatisReviewDao implements ReviewDao {

	@Autowired
	private ReviewMapper reviewMapper;
	
	public List<Review> getAllBoard(BoardSearch boardSearch) throws DataAccessException {
		return reviewMapper.getAllBoard(boardSearch);
	}
	
	public int boardPageCount(HashMap<String, Object> map) throws DataAccessException {
		return reviewMapper.boardPageCount(map);
	}
	
	public Review boardDetail(int boardNum) throws DataAccessException {
		return reviewMapper.boardDetail(boardNum);
	}

	public void insertBoard(Review review) {
		reviewMapper.insertBoard(review);
	}
	
	public void updateLike(Review review) throws DataAccessException {
		reviewMapper.updateLike(review);
	}

	public void updateReplyCnt(Review review) throws DataAccessException {
		reviewMapper.updateReplyCnt(review);
	}
}