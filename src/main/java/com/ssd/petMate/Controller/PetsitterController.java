package com.ssd.petMate.Controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.ssd.petMate.domain.Code;
import com.ssd.petMate.domain.Info;
import com.ssd.petMate.domain.Petsitter;
import com.ssd.petMate.page.BoardSearch;
import com.ssd.petMate.service.PetsitterFacade;

@Controller
public class PetsitterController {
	@Autowired
	private PetsitterFacade petsitterFacade;
	
	@ModelAttribute("petsitter")
	public Petsitter formBacking(HttpServletRequest request) {
		if (request.getMethod().equalsIgnoreCase("GET")) {
			Petsitter petsitter = new Petsitter();
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
	public String petsitterInsert(@ModelAttribute("petsitter") Petsitter petsitter, SessionStatus sessionStatus, HttpServletRequest request) {
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
		  boardSearch.pageInfo(pageNum, contentNum,totalCount); List<Petsitter> infoList = petsitterFacade.getAllBoard(boardSearch);
		  
		  mv.addObject("petsitterList", infoList);
		  mv.setViewName("petsitter/petsitterList"); 
		  return mv; 
	}
	
		@RequestMapping(value = "/petsitterDetail", method = { RequestMethod.GET, RequestMethod.POST })
		public ModelAndView petsitterDetail(ModelAndView mv, @RequestParam("boardNum") int boardNum) {
			Petsitter view = petsitterFacade.boardDetail(boardNum);
			String size = "";
			String day = "";
			System.out.println(view);
			
			int sizeNum = Integer.parseInt(view.getPetSize());
			if ((sizeNum & 1) != 0)
				size += "소형 ";
			if ((sizeNum & 2) != 0)
				size += "중형 ";
			if ((sizeNum & 4) != 0)
				size += "대형 ";
			
			int dayNum = Integer.parseInt(view.getPetDay());
			if ((dayNum & 1) != 0)
				day += "월요일 ";
			if ((dayNum & 2) != 0)
				day += "화요일 ";
			if ((dayNum & 4) != 0)
				day += "수요일 ";
			if ((dayNum & 8) != 0)
				day += "목요일 ";
			if ((dayNum & 16) != 0)
				day += "금요일 ";
			if ((dayNum & 32) != 0)
				day += "토요일 ";
			if ((dayNum & 64) != 0)
				day += "일요일 ";

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
}
