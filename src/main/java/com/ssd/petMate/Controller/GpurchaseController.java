package com.ssd.petMate.Controller;

import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.ssd.petMate.domain.Gpurchase;
import com.ssd.petMate.domain.GpurchaseCart;
import com.ssd.petMate.domain.GpurchaseCartCommand;
import com.ssd.petMate.page.BoardSearch;
import com.ssd.petMate.service.GpurchaseFacade;


@Controller
@SessionAttributes("cartList")
public class GpurchaseController {	
	
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
	

	//공구 게시판 목록
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
		mv.addObject("boardSearch", boardSearch);
		mv.setViewName("Gpurchase/GpurchaseList");
		return mv;
	}
	
//	@RequestMapping(value = "/secondhandForm", method = { RequestMethod.GET, RequestMethod.POST })
//	public ModelAndView secondhandForm(ModelAndView mv) {
//		mv.setViewName("secondhand/secondhandForm");
//		return mv;
//	}
	
	//공구게시판 글 상세보기
	@RequestMapping(value = "/gpurchaseDetail", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView gpurchaseDetail(ModelAndView mv,
			@RequestParam("boardNum") int boardNum) {
		Gpurchase view = gpurchaseImpl.getGpurchaseDetail(boardNum);
		System.out.println(view);
		mv.addObject("gpurchase", gpurchaseImpl.getGpurchaseDetail(boardNum));
		mv.setViewName("Gpurchase/GpurchaseDetail");
		return mv;
	}

	//공구게시판 글 작성 폼
	@GetMapping("/gpurchaseForm")
	public String gpurchaseForm() {
		return "Gpurchase/GpurchaseForm";
	}
	//공구게시판 글 등록
	@PostMapping("/gpurchaseInsert")
	public String gpurchaseInsert(@ModelAttribute("gpurchase") Gpurchase gpurchase, SessionStatus sessionStatus, HttpServletRequest request) {
		String userID = (String) request.getSession().getAttribute("userID");
		sessionStatus.setComplete();
		gpurchase.setUserID(userID);
//		info.setBoardTitle(title);
//		info.setBoardContent(content);
		System.out.println("공동구매 시작날짜 : " + gpurchase.getEdate());
		System.out.println("공동구매 종료날짜 : " + gpurchase.getSdate());
		gpurchaseImpl.insertGpurchase(gpurchase);
		return "redirect:/gpurchase";
	}
	
	//공구게시판 글 수정 폼
	@GetMapping("/gpurchaseUpdateForm")
	public String gpurchaseUpdateForm() {
		return "Gpurchase/GpurchaseForm";
	}
	
	//공구게시판 글 수정
	@PostMapping("/gpurchaseUpdate")
	public String gpurchaseUpdate(@ModelAttribute("gpurchase") Gpurchase gpurchase) {
		System.out.println("update gpurchase : " + gpurchase.toString());
		gpurchaseImpl.updateGpurchase(gpurchase);
		return "redirect:/gpurchase";
	}
	
	//공구게시판 장바구니 목록
	@GetMapping("/gpurchaseCart")
	public ModelAndView gpurchaseCartList(ModelAndView mv, HttpServletRequest request) {
		String userID = (String) request.getSession().getAttribute("userID");
		System.out.println("userID : " + userID);
		List<GpurchaseCartCommand> gpurchaseCartList = gpurchaseImpl.getGpurchaseCartListByGpurchase(userID);	
		mv.addObject("gpurchaseCartList", gpurchaseCartList);
		mv.setViewName("order/cart");
		return mv;
	}
	
//	게시글 추천 기능
	@RequestMapping(value="/gpurchaseCartAdded", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public HashMap<String, Integer> gpurchaseCartAdded(ModelAndView mv, HttpServletRequest request,
			@RequestParam(required = false) int boardNum) {

		String userID = (String) request.getSession().getAttribute("userID");
		Gpurchase gpurchase = gpurchaseImpl.getGpurchaseDetail(boardNum);
		GpurchaseCart gpurchaseCart = new GpurchaseCart(userID, boardNum);

//		이미 사용자가 게시글에 좋아요를 눌렀는지 누르지 않았는지 판별하기 위해 호출
		int count = gpurchaseImpl.isCart(gpurchaseCart);
		
		System.out.println("before : cartAdded = " + gpurchase.getCartAdded() );
		
//		만약 이전에 좋아요를 누르지 않았을 때
//		게시글의 좋아요 개수가 증가하고, like 테이블에 좋아요를 누른 userID와 게시글의 ID가 삽입됨
		if (count == 0) {
			gpurchaseImpl.insertGpurchaseCart(gpurchaseCart);
		}
//		else {
//			gpurchaseImpl.deleteGpurchaseCart(gpurchaseCart);
//		}
		
//		좋아요 개수 가지고 오기
		int cartAdded = gpurchaseImpl.countCartByboardNum(boardNum);
//		좋아요 개수 update
		gpurchase.setCartAdded(cartAdded);
		gpurchaseImpl.updateGpurchase(gpurchase);
		
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("count", count);
		map.put("cartAdded", cartAdded);
		System.out.println("infolike : " + mv.getViewName());
		
		return map;
	}
	
	//공구게시판 장바구니 삭제
	@GetMapping("/gpurchaseCartDelete")
	public String gpurchaseCartDelete(@RequestParam(required = false) int boardNum, HttpServletRequest request) {
		String userID = (String) request.getSession().getAttribute("userID");
		Gpurchase gpurchase = gpurchaseImpl.getGpurchaseDetail(boardNum);
		GpurchaseCart gpurchaseCart = new GpurchaseCart(userID, boardNum);
		
		gpurchaseImpl.deleteGpurchaseCart(gpurchaseCart);
		
//		좋아요 개수 가지고 오기
		int cartAdded = gpurchaseImpl.countCartByboardNum(boardNum);
//		좋아요 개수 update
		gpurchase.setCartAdded(cartAdded);
		gpurchaseImpl.updateGpurchase(gpurchase);
		
		return "redirect:/gpurchaseCart";
	}	
	
	@RequestMapping(value = "/gpurchaseOrderForm", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView gpurchaseOrderForm(@RequestParam(value = "gpurchaseCartList[]") List<String> gpurchaseCartList,ModelAndView mv) {
		System.out.println("orderForm enter;");
		int i;
		Gpurchase gpurchase;
		List<Gpurchase> cartList = new ArrayList<Gpurchase>();
		for(i = 0; i < gpurchaseCartList.size(); i++) {
			gpurchase = gpurchaseImpl.getGpurchaseDetail(Integer.parseInt(gpurchaseCartList.get(i)));
			cartList.add(gpurchase);
		}
		mv.addObject("cartList",cartList);
		mv.setViewName("order/paymentForm");
		return mv;
	}


//	//중고물품 삭제
//	@RequestMapping(value = "/gurchaseDelete", method = { RequestMethod.GET, RequestMethod.POST })
//	public String secondhandDelete(@RequestParam("boardNum") int boardNum) {
//		info.deleteSecondhand(boardNum);
//		return "redirect:/secondhand";
//	}
}