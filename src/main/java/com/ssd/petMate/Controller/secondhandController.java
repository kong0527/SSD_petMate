package com.ssd.petMate.Controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ssd.petMate.domain.Info;
import com.ssd.petMate.domain.Secondhand;
import com.ssd.petMate.page.BoardSearch;
import com.ssd.petMate.service.InfoFacade;

@Controller
public class secondhandController {	
	
	@Autowired
	private InfoFacade info;
	
	@RequestMapping(value = "/secondhand", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView detailSecondhand(ModelAndView mv,
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

		int totalCount = info.boardPageCount(map);

//		페이징과 검색 기능이 적용된 후의 리스트를 가지고 옴
		boardSearch.pageInfo(pageNum, contentNum, totalCount);
		List<Secondhand> secondhandList = info.getSecondhandList(boardSearch);

		mv.addObject("secondhandList", secondhandList);
		mv.setViewName("secondhand/categories");
		return mv;
	}
	
	@RequestMapping(value = "/secondhandForm", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView secondhandForm(ModelAndView mv) {
		mv.setViewName("secondhand/secondhandForm");
		return mv;
	}
	
	@RequestMapping(value = "/secondhandDetail", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView secondhandDetail(ModelAndView mv) {
		mv.setViewName("secondhand/secondhandDetail");
		return mv;
	}
	
//	@RequestMapping(value = "/info", method = { RequestMethod.GET, RequestMethod.POST })
//	public ModelAndView infoBoard(ModelAndView mv, 
//			@RequestParam(required = false, defaultValue = "1") int pageNum,
//			@RequestParam(required = false, defaultValue = "10") int contentNum,
//			@RequestParam(required = false) String searchType,
//			@RequestParam(required = false) String keyword) {
//		
//		BoardSearch boardSearch = new BoardSearch();
//		boardSearch.setSearchType(searchType);
//		boardSearch.setKeyword(keyword);
//		
////		검색한 결과값을 가져오기 위해 map에 키워드와 검색 타입 저장 후 sql 쿼리에 삽입
//		HashMap<String, Object> map = new HashMap<String, Object>();
//		map.put("keyword", keyword);
//		map.put("searchType", searchType);
//
//		int totalCount = info.boardPageCount(map);
//
////		페이징과 검색 기능이 적용된 후의 리스트를 가지고 옴
//		boardSearch.pageInfo(pageNum, contentNum, totalCount);
//		List<Info> infoList = info.getAllBoard(boardSearch);
//
//		mv.addObject("infoList", infoList);
//		mv.setViewName("info/infoBoard");
//		return mv;
//	}
//	
//	@RequestMapping(value = "/infoDetail", method = { RequestMethod.GET, RequestMethod.POST })
//	public ModelAndView infoDetail(ModelAndView mv, 
//			@RequestParam("boardNum") int boardNum) {
//		System.out.println("In!!!!!");
//		Info view = info.boardDetail(boardNum);
//		System.out.println(view);
//		mv.addObject("info", info.boardDetail(boardNum));
//		mv.setViewName("info/infoDetail");
//		return mv;
//	}
}