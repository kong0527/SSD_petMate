package com.ssd.petMate.Controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ssd.petMate.domain.Inquiry;
import com.ssd.petMate.page.BoardSearch;
import com.ssd.petMate.service.InquiryFacade;

@Controller
public class inquiryController {
	
	@Autowired
	private InquiryFacade inquiry;
	
	@RequestMapping(value = "/inquiryDetail", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView InquiryDetail(ModelAndView mv) {
		mv.setViewName("inquiry/inquiryDetail");
		return mv;
	}
	
	@RequestMapping(value = "/inquiryForm", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView InquiryForm(ModelAndView mv) {
		mv.setViewName("inquiry/inquiryForm");
		return mv;
	}
	
	@RequestMapping(value = "/inquiry", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView inquiryBoard(ModelAndView mv, 
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

		int totalCount = inquiry.boardPageCount(map);

//		페이징과 검색 기능이 적용된 후의 리스트를 가지고 옴
		boardSearch.pageInfo(pageNum, contentNum, totalCount);
		List<Inquiry> inquiryList = inquiry.getAllBoard(boardSearch);

		mv.addObject("inquiryList", inquiryList);
		mv.setViewName("inquiry/inquiryList");
		return mv;
	}

}
