package com.ssd.petMate.Controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ssd.petMate.domain.Info;
import com.ssd.petMate.domain.UserList;
import com.ssd.petMate.page.BoardSearch;
import com.ssd.petMate.service.MyPageFacade;
import com.ssd.petMate.service.UserFacade;

@Controller
public class AdminController {
	
	@Autowired
	private UserFacade userFacade;
	
	@Autowired
	private MyPageFacade myPageFacade;
	
	@RequestMapping(value = "/admin", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView admin(ModelAndView mv,
			@RequestParam(required = false, defaultValue = "1") int pageNum,
			@RequestParam(required = false, defaultValue = "10") int contentNum,
			@RequestParam(required = false) String keyword) {
		
		BoardSearch boardSearch = new BoardSearch();
		boardSearch.setKeyword(keyword);

		int totalCount = userFacade.userCount(keyword);

//		페이징과 검색 기능이 적용된 후의 리스트를 가지고 옴
		boardSearch.pageInfo(pageNum, contentNum, totalCount);
		List<UserList> userList = userFacade.getAllUser(boardSearch);
		
		mv.addObject("userList", userList);
		mv.addObject("boardSearch", boardSearch);
		mv.setViewName("admin/adminPage");
		return mv;
	}
	
	@RequestMapping(value = "/userpage", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView userpage(ModelAndView mv, HttpServletRequest request,
			@RequestParam(required = false, defaultValue = "1") int pageNum,
			@RequestParam(required = false, defaultValue = "10") int contentNum,
			@RequestParam(required = false) String searchType,
			@RequestParam(required = false) String keyword,
			@RequestParam String userID) {
		
//		검색한 결과값을 가져오기 위해 map에 키워드와 검색 타입 저장 후 sql 쿼리에 삽입
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("keyword", keyword);
		map.put("searchType", searchType);
		map.put("userID", userID);

		int totalCount = myPageFacade.getPrivateInfoCount(map);
		
		BoardSearch boardSearch = new BoardSearch();
		boardSearch.setSearchType(searchType);
		boardSearch.setKeyword(keyword);
		boardSearch.setUserID(userID);
	
//		페이징과 검색 기능이 적용된 후의 리스트를 가지고 옴
		boardSearch.pageInfo(pageNum, contentNum, totalCount);
		List<Info> userInfoList = myPageFacade.getPrivateInfoList(boardSearch);

		mv.addObject("userInfoList", userInfoList);
		mv.addObject("boardSearch", boardSearch);
		mv.addObject("writerID", userID);
		mv.setViewName("admin/userInfoPage");
		return mv;
	}
}
