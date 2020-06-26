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

import com.ssd.petMate.domain.Gpurchase;
import com.ssd.petMate.domain.Info;
import com.ssd.petMate.domain.Inquiry;
import com.ssd.petMate.domain.Petsitter;
import com.ssd.petMate.domain.Review;
import com.ssd.petMate.domain.Secondhand;
import com.ssd.petMate.page.BoardSearch;
import com.ssd.petMate.service.MyPageFacade;

@Controller
public class MyPageController {

	@Autowired
	private MyPageFacade myPageFacade;
	
	@RequestMapping(value = "/mypage", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView mypage(ModelAndView mv, HttpServletRequest request,
			@RequestParam(required = false, defaultValue = "1") int pageNum,
			@RequestParam(required = false, defaultValue = "10") int contentNum,
			@RequestParam(required = false) String searchType,
			@RequestParam(required = false) String keyword) {
		
		String userID = request.getSession().getAttribute("userID").toString();
		System.out.println(userID);
		
//		검색한 결과값을 가져오기 위해 map에 키워드와 검색 타입 저장 후 sql 쿼리에 삽입
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("keyword", keyword);
		map.put("searchType", searchType);
		map.put("userID", userID);

		int totalCount = myPageFacade.getPrivateInfoCount(map);
		System.out.println(totalCount);
		
		BoardSearch boardSearch = new BoardSearch();
		boardSearch.setSearchType(searchType);
		boardSearch.setKeyword(keyword);
		boardSearch.setUserID(userID);
	
//		페이징과 검색 기능이 적용된 후의 리스트를 가지고 옴
		boardSearch.pageInfo(pageNum, contentNum, totalCount);
		List<Info> myInfoList = myPageFacade.getPrivateInfoList(boardSearch);

		mv.addObject("myInfoList", myInfoList);
		mv.addObject("boardSearch", boardSearch);
		mv.setViewName("mypage/myInfoPage");
		return mv;
	}
	
	@RequestMapping(value = "/myCommentInquiry", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView mypageInquiryReply(ModelAndView mv, HttpServletRequest request,
			@RequestParam(required = false, defaultValue = "1") int pageNum,
			@RequestParam(required = false, defaultValue = "10") int contentNum,
			@RequestParam(required = false) String searchType,
			@RequestParam(required = false) String keyword) {
		
		String userID = request.getSession().getAttribute("userID").toString();
		System.out.println(userID);
		
//		검색한 결과값을 가져오기 위해 map에 키워드와 검색 타입 저장 후 sql 쿼리에 삽입
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("keyword", keyword);
		map.put("searchType", searchType);
		map.put("userID", userID);

		int totalCount = myPageFacade.getPrivateInquiryReplyCount(map);
		System.out.println(totalCount);
		
		BoardSearch boardSearch = new BoardSearch();
		boardSearch.setSearchType(searchType);
		boardSearch.setKeyword(keyword);
		boardSearch.setUserID(userID);
	
//		페이징과 검색 기능이 적용된 후의 리스트를 가지고 옴
		boardSearch.pageInfo(pageNum, contentNum, totalCount);
		List<Inquiry> myReviewList = myPageFacade.getPrivateInquiryReplyList(boardSearch);

		mv.addObject("myInquiryList", myReviewList);
		mv.addObject("boardSearch", boardSearch);
		mv.setViewName("mypage/myInquiryReplyPage");
		return mv;
	}
	
	@RequestMapping(value = "/myCommentInfo", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView mypageInfoReply(ModelAndView mv, HttpServletRequest request,
			@RequestParam(required = false, defaultValue = "1") int pageNum,
			@RequestParam(required = false, defaultValue = "10") int contentNum,
			@RequestParam(required = false) String searchType,
			@RequestParam(required = false) String keyword) {
		
		String userID = request.getSession().getAttribute("userID").toString();
		System.out.println(userID);
		
//		검색한 결과값을 가져오기 위해 map에 키워드와 검색 타입 저장 후 sql 쿼리에 삽입
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("keyword", keyword);
		map.put("searchType", searchType);
		map.put("userID", userID);

		int totalCount = myPageFacade.getPrivateInfoReplyCount(map);
		System.out.println(totalCount);
		
		BoardSearch boardSearch = new BoardSearch();
		boardSearch.setSearchType(searchType);
		boardSearch.setKeyword(keyword);
		boardSearch.setUserID(userID);
	
//		페이징과 검색 기능이 적용된 후의 리스트를 가지고 옴
		boardSearch.pageInfo(pageNum, contentNum, totalCount);
		List<Info> myInfoList = myPageFacade.getPrivateInfoReplyList(boardSearch);

		mv.addObject("myInfoList", myInfoList);
		mv.addObject("boardSearch", boardSearch);
		mv.setViewName("mypage/myInfoReplyPage");
		return mv;
	}
	
	@RequestMapping(value = "/myCommentGpurchase", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView mypageGpurchaseReply(ModelAndView mv, HttpServletRequest request,
			@RequestParam(required = false, defaultValue = "1") int pageNum,
			@RequestParam(required = false, defaultValue = "10") int contentNum,
			@RequestParam(required = false) String searchType,
			@RequestParam(required = false) String keyword) {
		
		String userID = request.getSession().getAttribute("userID").toString();
		System.out.println(userID);
		
//		검색한 결과값을 가져오기 위해 map에 키워드와 검색 타입 저장 후 sql 쿼리에 삽입
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("keyword", keyword);
		map.put("searchType", searchType);
		map.put("userID", userID);

		int totalCount = myPageFacade.getPrivateGpurchaseReplyCount(map);
		System.out.println(totalCount);
		
		BoardSearch boardSearch = new BoardSearch();
		boardSearch.setSearchType(searchType);
		boardSearch.setKeyword(keyword);
		boardSearch.setUserID(userID);
	
//		페이징과 검색 기능이 적용된 후의 리스트를 가지고 옴
		boardSearch.pageInfo(pageNum, contentNum, totalCount);
		List<Gpurchase> myGpurchaseList = myPageFacade.getPrivateGpurchaseReplyList(boardSearch);

		mv.addObject("myGpurchaseList", myGpurchaseList);
		mv.addObject("boardSearch", boardSearch);
		mv.setViewName("mypage/myGpurchaseReplyPage");
		return mv;
	}
	
	@RequestMapping(value = "/myCommentSecondhand", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView mypageSecondhandReply(ModelAndView mv, HttpServletRequest request,
			@RequestParam(required = false, defaultValue = "1") int pageNum,
			@RequestParam(required = false, defaultValue = "10") int contentNum,
			@RequestParam(required = false) String searchType,
			@RequestParam(required = false) String keyword) {
		
		String userID = request.getSession().getAttribute("userID").toString();
		System.out.println(userID);
		
//		검색한 결과값을 가져오기 위해 map에 키워드와 검색 타입 저장 후 sql 쿼리에 삽입
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("keyword", keyword);
		map.put("searchType", searchType);
		map.put("userID", userID);

		int totalCount = myPageFacade.getPrivateSecondhandReplyCount(map);
		System.out.println(totalCount);
		
		BoardSearch boardSearch = new BoardSearch();
		boardSearch.setSearchType(searchType);
		boardSearch.setKeyword(keyword);
		boardSearch.setUserID(userID);
	
//		페이징과 검색 기능이 적용된 후의 리스트를 가지고 옴
		boardSearch.pageInfo(pageNum, contentNum, totalCount);
		List<Secondhand> mySecondhandList = myPageFacade.getPrivateSecondhandReplyList(boardSearch);

		mv.addObject("mySecondhandList", mySecondhandList);
		mv.addObject("boardSearch", boardSearch);
		mv.setViewName("mypage/mySecondhandReplyPage");
		return mv;
	}
	
	@RequestMapping(value = "/myCommentPetsitter", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView mypagePetsitterReply(ModelAndView mv, HttpServletRequest request,
			@RequestParam(required = false, defaultValue = "1") int pageNum,
			@RequestParam(required = false, defaultValue = "10") int contentNum,
			@RequestParam(required = false) String searchType,
			@RequestParam(required = false) String keyword) {
		
		String userID = request.getSession().getAttribute("userID").toString();
		System.out.println(userID);
		
//		검색한 결과값을 가져오기 위해 map에 키워드와 검색 타입 저장 후 sql 쿼리에 삽입
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("keyword", keyword);
		map.put("searchType", searchType);
		map.put("userID", userID);

		int totalCount = myPageFacade.getPrivatePetsitterReplyCount(map);
		System.out.println(totalCount);
		
		BoardSearch boardSearch = new BoardSearch();
		boardSearch.setSearchType(searchType);
		boardSearch.setKeyword(keyword);
		boardSearch.setUserID(userID);
	
//		페이징과 검색 기능이 적용된 후의 리스트를 가지고 옴
		boardSearch.pageInfo(pageNum, contentNum, totalCount);
		List<Petsitter> myPetsitterList = myPageFacade.getPrivatePetsitterReplyList(boardSearch);

		mv.addObject("myPetsitterList", myPetsitterList);
		mv.addObject("boardSearch", boardSearch);
		mv.setViewName("mypage/myPetsitterReplyPage");
		return mv;
	}
	
	@RequestMapping(value = "/myCommentReview", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView mypageReviewReply(ModelAndView mv, HttpServletRequest request,
			@RequestParam(required = false, defaultValue = "1") int pageNum,
			@RequestParam(required = false, defaultValue = "10") int contentNum,
			@RequestParam(required = false) String searchType,
			@RequestParam(required = false) String keyword) {
		
		String userID = request.getSession().getAttribute("userID").toString();
		System.out.println(userID);
		
//		검색한 결과값을 가져오기 위해 map에 키워드와 검색 타입 저장 후 sql 쿼리에 삽입
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("keyword", keyword);
		map.put("searchType", searchType);
		map.put("userID", userID);

		int totalCount = myPageFacade.getPrivateReviewReplyCount(map);
		System.out.println(totalCount);
		
		BoardSearch boardSearch = new BoardSearch();
		boardSearch.setSearchType(searchType);
		boardSearch.setKeyword(keyword);
		boardSearch.setUserID(userID);
	
//		페이징과 검색 기능이 적용된 후의 리스트를 가지고 옴
		boardSearch.pageInfo(pageNum, contentNum, totalCount);
		List<Review> myReviewList = myPageFacade.getPrivateReviewReplyList(boardSearch);

		mv.addObject("myReviewList", myReviewList);
		mv.addObject("boardSearch", boardSearch);
		mv.setViewName("mypage/myReviewReplyPage");
		return mv;
	}
}
