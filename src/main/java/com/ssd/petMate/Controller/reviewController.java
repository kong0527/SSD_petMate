package com.ssd.petMate.Controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ssd.petMate.domain.Review;
import com.ssd.petMate.page.BoardSearch;
import com.ssd.petMate.service.ReviewFacade;

@Controller
public class reviewController {
	
	@Autowired
	private ReviewFacade review;
	
	@RequestMapping(value = "/reviewDetail", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView reviewDetail(ModelAndView mv) {
		mv.setViewName("review/reviewDetail");
		return mv;
	}
	
	@RequestMapping(value = "/reviewForm", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView ReviewForm(ModelAndView mv) {
		mv.setViewName("review/reviewForm");
		return mv;
	}
	
	@RequestMapping(value = "/review", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView reviewBoard(ModelAndView mv, 
			@RequestParam(required = false, defaultValue = "1") int pageNum,
			@RequestParam(required = false, defaultValue = "10") int contentNum,
			@RequestParam(required = false) String searchType,
			@RequestParam(required = false) String keyword) {
		
		BoardSearch boardSearch = new BoardSearch();
		boardSearch.setSearchType(searchType);
		boardSearch.setKeyword(keyword);
		
//		검색한 결과값을 가져오기 위해 map에 키워드와 검색 타입 저장 후 sql 쿼리에 삽입
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("keyword", keyword);
		map.put("searchType", searchType);

		int totalCount = review.boardPageCount(map);

//		페이징과 검색 기능이 적용된 후의 리스트를 가지고 옴
		boardSearch.pageInfo(pageNum, contentNum, totalCount);
		List<Review> reviewList = review.getAllBoard(boardSearch);

		mv.addObject("reviewList", reviewList);
		mv.setViewName("review/reviewList");
		return mv;
	}

}
