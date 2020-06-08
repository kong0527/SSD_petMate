package com.ssd.petMate.dao.mybatis.mapper;

import com.ssd.petMate.domain.ReviewLike;

public interface ReviewLikeMapper {
	public void insertLike(ReviewLike inquiryLike); //좋아요 추가
	
	public void deleteLike(ReviewLike inquiryLike); //좋아요 삭제
}
