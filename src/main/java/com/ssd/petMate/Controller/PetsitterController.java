package com.ssd.petMate.Controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.ssd.petMate.domain.Code;
import com.ssd.petMate.domain.Info;
import com.ssd.petMate.domain.PetsitterLike;
import com.ssd.petMate.domain.Petsitter;
import com.ssd.petMate.page.BoardSearch;
import com.ssd.petMate.service.PetsitterFacade;
import com.ssd.petMate.service.PetsitterLikeFacade;

@Controller
public class PetsitterController {
	@Autowired
	private PetsitterFacade petsitterFacade;
	
	
	@Autowired
	private PetsitterLikeFacade petsitterLikeFacade;
	
	@ModelAttribute("petsitter")
	public Petsitter formBacking(HttpServletRequest request) {
		if (request.getMethod().equalsIgnoreCase("GET")) {
			Petsitter petsitter;
			if (request.getParameter("boardNum") != null) {
				System.out.println(request.getParameter("boardNum"));
				petsitter = petsitterFacade.boardDetail(Integer.valueOf(request.getParameter("boardNum")));
			}
			else {
				petsitter = new Petsitter();
			}
			return petsitter;
		}
		else return new Petsitter();
	}
	
	@ModelAttribute("sizeCodes")
	public List<Code> referenceData1() {
		List<Code> sizeCodes = new ArrayList<Code>();
		sizeCodes.add(new Code("1", "소형　　　"));
		sizeCodes.add(new Code("2", "중형　　　"));
		sizeCodes.add(new Code("4", "대형"));
		
		 return sizeCodes;
	}
	
	@ModelAttribute("dayCodes")
	public List<Code> referencData2() {
		List<Code> dayCodes = new ArrayList<Code>();
		dayCodes.add(new Code("1", "월요일　　"));
		dayCodes.add(new Code("2", "화요일　　"));
		dayCodes.add(new Code("4", "수요일　　"));
		dayCodes.add(new Code("8", "목요일　　"));
		dayCodes.add(new Code("16", "금요일　　"));
		dayCodes.add(new Code("32", "토요일　　"));
		dayCodes.add(new Code("64", "일요일"));
		
		return dayCodes;
	}
	
	@PostMapping("/petsitterInsert")
	public String petsitterInsert(@Valid @ModelAttribute("petsitter") Petsitter petsitter, BindingResult result, SessionStatus sessionStatus, 
			HttpServletRequest request) {
		sessionStatus.setComplete();
		int sizeSum = 0;
		int daySum = 0;
		petsitter.setUserID("test4");
		
		for (String s : petsitter.getSizeCodes()) {
			sizeSum += Integer.parseInt(s);
		}
		petsitter.setPetSize(Integer.toString(sizeSum));
		
		for (String s : petsitter.getDayCodes()) {
			daySum += Integer.parseInt(s);
		}
		petsitter.setPetDay(Integer.toString(daySum));
		
		if (petsitter.getBoardTitle().length() > 25) {
			result.rejectValue("boardTitle", "long");
		}
		
		if (petsitter.getBoardContent().length() >  1500) {
			result.rejectValue("boardContent", "long2");
		}
		
		if (Integer.parseInt(petsitter.getPetSize()) == 0) {
			result.rejectValue("sizeCodes", "check");
		}
		
		if (Integer.parseInt(petsitter.getPetDay()) == 0) {
			result.rejectValue("dayCodes", "check");
		}
		
		if (petsitter.getPetPrice() < 5000 | petsitter.getPetPrice() > 15000) {
			result.rejectValue("petPrice", "price");
		}
		
		if (result.hasErrors()) {
			return "petsitter/petsitterForm";
		}
		
		petsitterFacade.insertBoard(petsitter);
		return "redirect:/petsitterList";
	}
	
	@RequestMapping(value = "/petsitterList", method = { RequestMethod.GET,
	RequestMethod.POST }) public ModelAndView petsitterList(ModelAndView mv,
	@RequestParam(required = false, defaultValue = "1") int pageNum,
	@RequestParam(required = false, defaultValue = "10") int contentNum,  
	@RequestParam(required = false) String searchType,
	@RequestParam(required = false) String keyword) {
		  BoardSearch boardSearch = new BoardSearch();
		  boardSearch.setSearchType(searchType); boardSearch.setKeyword(keyword);
		  
		  // 검색한 결과값을 가져오기 위해 map에 키워드와 검색 타입 저장 후 sql 쿼리에 삽입 
		  HashMap<String, Object> map = new HashMap<String, Object>(); map.put("keyword", keyword);
		  map.put("searchType", searchType);
		  
		  int totalCount = petsitterFacade.boardPageCount(map);
		  
		  // 페이징과 검색 기능이 적용된 후의 리스트를 가지고 옴 
		  boardSearch.pageInfo(pageNum, contentNum,totalCount); List<Petsitter> petsitterList = petsitterFacade.getAllBoard(boardSearch);
		  
		  mv.addObject("petsitterList", petsitterList);
		  mv.addObject("boardSearch", boardSearch);
		  mv.setViewName("petsitter/petsitterList"); 
		  return mv; 
	}
	
		@RequestMapping(value = "/petsitterDetail", method = { RequestMethod.GET, RequestMethod.POST })
		public ModelAndView petsitterDetail(ModelAndView mv, @RequestParam("boardNum") int boardNum) {
			Petsitter view = petsitterFacade.boardDetail(boardNum);
			String size;
			String day;
			System.out.println(view);
			
			int sizeNum = Integer.parseInt(view.getPetSize());
			size = view.sizeCheck(sizeNum);
			
			int dayNum = Integer.parseInt(view.getPetDay());
			day = view.dayCheck(dayNum);

			mv.addObject("petsitter", petsitterFacade.boardDetail(boardNum));
			mv.setViewName("petsitter/petsitterDetail");
			mv.addObject("size", size);
			mv.addObject("day", day);
			return mv;
		}
		
		@RequestMapping(value = "/petsitterDetail/delete", method = { RequestMethod.GET, RequestMethod.POST })
		public String petsitterDelete(@RequestParam("boardNum") int boardNum) {
			petsitterFacade.deleteBoard(boardNum);
			return "redirect:/petsitterList";
		}
	
		@RequestMapping(value = "/petsitterForm", method = { RequestMethod.GET, RequestMethod.POST }) 
		public ModelAndView petsitterForm(ModelAndView mv) {
			  mv.setViewName("petsitter/petsitterForm"); 
			  return mv; 
		}
		
//		게시글 추천 기능
		@RequestMapping(value="/petsitterLike", method = { RequestMethod.GET, RequestMethod.POST })
		@ResponseBody
		public HashMap<String, Integer> petsitterLike(ModelAndView mv, HttpServletRequest request,
				@RequestParam(required = false) int boardNum) {

			String userID = (String) request.getSession().getAttribute("userID");
			Petsitter petsitter = petsitterFacade.boardDetail(boardNum);
			PetsitterLike petsitterLike = new PetsitterLike(userID, boardNum);

//			이미 사용자가 게시글에 좋아요를 눌렀는지 누르지 않았는지 판별하기 위해 호출
			int count = petsitterLikeFacade.isLike(petsitterLike);
			
//			만약 이전에 좋아요를 누르지 않았을 때
//			게시글의 좋아요 개수가 증가하고, like 테이블에 좋아요를 누른 userID와 게시글의 ID가 삽입됨
			if (count == 0) {
				petsitterLikeFacade.insertLike(petsitterLike);
			}
			else {
				petsitterLikeFacade.deleteLike(petsitterLike);
			}
			
//			좋아요 개수 가지고 오기
			int boardLike = petsitterLikeFacade.countLike(boardNum);
			
//			좋아요 개수 update
			petsitter.setBoardLike(boardLike);
			petsitterFacade.updateLike(petsitter);
			
			HashMap<String, Integer> map = new HashMap<String, Integer>();
			map.put("count", count);
			map.put("boardLike", boardLike);
			
			return map;
		}
		
		@GetMapping("/petsitterUpdate")
		public String petsitterUpdateForm() {
			return "petsitter/petsitterForm";
		}
		
		@PostMapping("/petsitterUpdate")
		public String petsitterUpdate(@ModelAttribute("petsitter") Petsitter petsitter) {
			int sizeSum = 0;
			int daySum = 0;
			petsitter.setUserID("test4");
			
			for (String s : petsitter.getSizeCodes()) {
				sizeSum += Integer.parseInt(s);
			}
			petsitter.setPetSize(Integer.toString(sizeSum));
			
			for (String s : petsitter.getDayCodes()) {
				daySum += Integer.parseInt(s);
			}
			petsitter.setPetDay(Integer.toString(daySum));
			petsitterFacade.updateBoard(petsitter);
			return "redirect:/petsitterList";
		}
}
