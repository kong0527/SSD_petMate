package com.ssd.petMate.Controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.ssd.petMate.domain.Info;
import com.ssd.petMate.domain.Secondhand;
import com.ssd.petMate.page.BoardSearch;
import com.ssd.petMate.service.InfoFacade;
import com.ssd.petMate.service.SecondhandImpl;

@Controller
public class secondhandController {	
	
	@Autowired
	private SecondhandImpl secondhandImpl;
	
	@ModelAttribute("secondhand")
	public Secondhand formBacking(HttpServletRequest request) {
		if (request.getMethod().equalsIgnoreCase("GET")) {
			Secondhand secondhand;
			if(request.getParameter("boardNum") != null) {
				secondhand = secondhandImpl.getSecondhandDetail(Integer.valueOf(request.getParameter("boardNum")));
			}
			else {
				secondhand = new Secondhand();
			}
			return secondhand;
		}
		else {
			return new Secondhand();
		}
	}
	
	@RequestMapping(value = "/secondhand", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView SecondhandList(ModelAndView mv,
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

		int totalCount = secondhandImpl.getSecondhandboardCount(map);

//		페이징과 검색 기능이 적용된 후의 리스트를 가지고 옴
		boardSearch.pageInfo(pageNum, contentNum, totalCount);
		List<Secondhand> secondhandList = secondhandImpl.getSecondhandList(boardSearch);

		mv.addObject("secondhandList", secondhandList);
		mv.setViewName("secondhand/secondhandList");
		return mv;
	}
	
//	@RequestMapping(value = "/secondhandForm", method = { RequestMethod.GET, RequestMethod.POST })
//	public ModelAndView secondhandForm(ModelAndView mv) {
//		mv.setViewName("secondhand/secondhandForm");
//		return mv;
//	}
	
	//중고게시판 글 상세보기
	@RequestMapping(value = "/secondhandDetail", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView secondhandDetail(ModelAndView mv,
			@RequestParam("boardNum") int boardNum) {
		Secondhand view = secondhandImpl.getSecondhandDetail(boardNum);
		System.out.println(view);
		mv.addObject("secondhand", secondhandImpl.getSecondhandDetail(boardNum));
		mv.setViewName("secondhand/secondhandDetail");
		return mv;
	}

	//중고게시판 글 작성 폼
	@GetMapping("/secondhandForm")
	public String secondhandForm() {
		return "secondhand/secondhandForm";
	}
	//중고게시판 글 등록
	@PostMapping("/secondhandInsert")
	public String secondhandInsert(@ModelAttribute("secondhand") Secondhand secondhand, SessionStatus sessionStatus, HttpServletRequest request) {
		sessionStatus.setComplete();
//		String title = request.getParameter("boardTitle");
//		String content = request.getParameter("boardContent");
		secondhand.setUserID("test1");
//		info.setBoardTitle(title);
//		info.setBoardContent(content);
		secondhandImpl.insertSecondhand(secondhand);
		return "redirect:/secondhand";
	}
	
	//중고게시판 글 수정 폼
	@GetMapping("/secondhandUpdateForm")
	public String secondhandUpdateForm() {
		return "secondhand/secondhandUpdateForm";
	}
	
	//중고게시판 글 수정
	@PostMapping("/secondhandUpdate")
	public String secondhandUpdate(@ModelAttribute("secondhand") Secondhand secondhand) {
		System.out.println("update secondhand : " + secondhand.toString());
		secondhandImpl.updateSecondhand(secondhand);
		return "redirect:/secondhand";
	}
	
	//중고물품 삭제
	@RequestMapping(value = "/secondhandDelete", method = { RequestMethod.GET, RequestMethod.POST })
	public String secondhandDelete(@RequestParam("boardNum") int boardNum) {
		secondhandImpl.deleteSecondhand(boardNum);
		return "redirect:/secondhand";
	}
	
}