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

import com.ssd.petMate.domain.Gpurchase;
import com.ssd.petMate.domain.GpurchaseCart;
import com.ssd.petMate.domain.Info;
import com.ssd.petMate.domain.Secondhand;
import com.ssd.petMate.page.BoardSearch;
import com.ssd.petMate.service.GpurchaseFacade;
import com.ssd.petMate.service.InfoFacade;

@Controller
public class gpurchaseController {	
	
	@Autowired
	private GpurchaseFacade gpurchaseImpl;
	
	@ModelAttribute("gpurchase")
	public Gpurchase formBacking(HttpServletRequest request) {
		if (request.getMethod().equalsIgnoreCase("GET")) {
			Gpurchase gpurchase;
			if(request.getParameter("boardNum") != null) {
				gpurchase = gpurchaseImpl.getGpurchaseDetail(Integer.valueOf(request.getParameter("boardNum")));
			}
			else {
				gpurchase = new Gpurchase();
			}
			return gpurchase;
		}
		else {
			return new Gpurchase();
		}
	}
	
	@RequestMapping(value = "/gpurchase", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView gpurchaseList(ModelAndView mv,
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

		int totalCount = gpurchaseImpl.getGpurchaseBoardCount(map);

//		페이징과 검색 기능이 적용된 후의 리스트를 가지고 옴
		boardSearch.pageInfo(pageNum, contentNum, totalCount);
		List<Gpurchase> gpurchaseList = gpurchaseImpl.getGpurchaseList(boardSearch);

		mv.addObject("gpurchaseList", gpurchaseList);
		mv.setViewName("Gpurchase/GpurchaseList");
		return mv;
	}
	
//	@RequestMapping(value = "/secondhandForm", method = { RequestMethod.GET, RequestMethod.POST })
//	public ModelAndView secondhandForm(ModelAndView mv) {
//		mv.setViewName("secondhand/secondhandForm");
//		return mv;
//	}
	
	//중고게시판 글 상세보기
	@RequestMapping(value = "/gpurchaseDetail", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView gpurchaseDetail(ModelAndView mv,
			@RequestParam("boardNum") int boardNum) {
		Gpurchase view = gpurchaseImpl.getGpurchaseDetail(boardNum);
		System.out.println(view);
		mv.addObject("gpurchase", gpurchaseImpl.getGpurchaseDetail(boardNum));
		mv.setViewName("Gpurchase/GpurchaseDetail");
		return mv;
	}

	//중고게시판 글 작성 폼
	@GetMapping("/gpurchaseForm")
	public String gpurchaseForm() {
		return "Gpurchase/GpurchaseForm";
	}
	//중고게시판 글 등록
	@PostMapping("/gpurchaseInsert")
	public String gpurchaseInsert(@ModelAttribute("gpurchase") Gpurchase gpurchase, SessionStatus sessionStatus, HttpServletRequest request) {
		sessionStatus.setComplete();
//		String title = request.getParameter("boardTitle");
//		String content = request.getParameter("boardContent");
		gpurchase.setUserID("test1");
//		info.setBoardTitle(title);
//		info.setBoardContent(content);
		System.out.println("공동구매 시작날짜 : " + gpurchase.getEdate());
		System.out.println("공동구매 종료날짜 : " + gpurchase.getSdate());
		gpurchaseImpl.insertGpurchase(gpurchase);
		return "redirect:/gpurchase";
	}
	
	//중고게시판 글 수정 폼
	@GetMapping("/gpurchaseUpdateForm")
	public String gpurchaseUpdateForm() {
		return "Gpurchase/GpurchaseForm";
	}
	
	//중고게시판 글 수정
	@PostMapping("/gpurchaseUpdate")
	public String gpurchaseUpdate(@ModelAttribute("gpurchase") Gpurchase gpurchase) {
		System.out.println("update gpurchase : " + gpurchase.toString());
		gpurchaseImpl.updateGpurchase(gpurchase);
		return "redirect:/gpurchase";
	}
	
	@GetMapping("/gpurchaseCart")
	public ModelAndView gpurchaseCartList(ModelAndView mv) {
		
		List<GpurchaseCart> gpurchaseCartList = gpurchaseImpl.getGpurchaseCartListByGpurchase("test1");	
		mv.addObject("gpurchaseCartList", gpurchaseCartList);
		mv.setViewName("order/cart");
		return mv;
	}
	
	
//	//중고물품 삭제
//	@RequestMapping(value = "/gurchaseDelete", method = { RequestMethod.GET, RequestMethod.POST })
//	public String secondhandDelete(@RequestParam("boardNum") int boardNum) {
//		info.deleteSecondhand(boardNum);
//		return "redirect:/secondhand";
//	}
}