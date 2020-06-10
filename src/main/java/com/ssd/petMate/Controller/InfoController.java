package com.ssd.petMate.Controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.ssd.petMate.domain.Info;
import com.ssd.petMate.page.BoardSearch;
import com.ssd.petMate.service.InfoFacade;

@Controller
public class InfoController {
	
	@Autowired
	private InfoFacade infoFacade;
	
	@ModelAttribute("info")
	public Info formBacking(HttpServletRequest request) {
		if (request.getMethod().equalsIgnoreCase("GET")) {
			Info info = new Info();
			return info;
		}
		else return new Info();
	}
	
	@PostMapping("/infoInsert")
	public String infoInsert(@ModelAttribute("info") Info info, SessionStatus sessionStatus, HttpServletRequest request) {
		sessionStatus.setComplete();
		info.setUserID("test1");
		infoFacade.insertBoard(info);
		return "redirect:/info";
	}
	
	@RequestMapping(value = "/info", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView infoBoard(ModelAndView mv, 
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

		int totalCount = infoFacade.boardPageCount(map);

//		페이징과 검색 기능이 적용된 후의 리스트를 가지고 옴
		boardSearch.pageInfo(pageNum, contentNum, totalCount);
		List<Info> infoList = infoFacade.getAllBoard(boardSearch);

		mv.addObject("infoList", infoList);
		mv.setViewName("info/infoList");
		return mv;
	}
	
	@RequestMapping(value = "/infoDetail", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView infoDetail(ModelAndView mv, 
			@RequestParam("boardNum") int boardNum) {
		Info view = infoFacade.boardDetail(boardNum);
		System.out.println(view);
		mv.addObject("info", infoFacade.boardDetail(boardNum));
		mv.setViewName("info/infoDetail");
		return mv;
	}
	
	
	@RequestMapping(value = "/infoForm", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView InfoForm(ModelAndView mv) {
		mv.setViewName("info/infoForm");
		return mv;
	}
}
