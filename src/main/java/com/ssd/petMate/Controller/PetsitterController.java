package com.ssd.petMate.Controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ssd.petMate.domain.PetsitterLike;
import com.ssd.petMate.domain.Petsitter;
import com.ssd.petMate.page.BoardSearch;
import com.ssd.petMate.service.PetsitterFacade;
import com.ssd.petMate.service.PetsitterLikeFacade;
import com.ssd.petMate.service.UserImpl;

@Controller
public class PetsitterController {
   @Autowired
   private PetsitterFacade petsitterFacade;
   
   @Autowired
   private UserImpl userService;
   
   @Autowired
   private PetsitterLikeFacade petsitterLikeFacade;
   
   @ModelAttribute("petsitterChk")
   public int petsitterChk(HttpServletRequest request) {
      if (request.getSession().getAttribute("userID") != null) {
         return userService.isPetsitter(request.getSession().getAttribute("userID").toString());
      }
      return -1;
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
      
//      게시글 추천 기능
      @RequestMapping(value="/petsitterLike", method = { RequestMethod.GET, RequestMethod.POST })
      @ResponseBody
      public HashMap<String, Integer> petsitterLike(ModelAndView mv, HttpServletRequest request,
            @RequestParam(required = false) int boardNum) {

         String userID = (String) request.getSession().getAttribute("userID");
         Petsitter petsitter = petsitterFacade.boardDetail(boardNum);
         PetsitterLike petsitterLike = new PetsitterLike(userID, boardNum);

//         이미 사용자가 게시글에 좋아요를 눌렀는지 누르지 않았는지 판별하기 위해 호출
         int count = petsitterLikeFacade.isLike(petsitterLike);
         
//         만약 이전에 좋아요를 누르지 않았을 때
//         게시글의 좋아요 개수가 증가하고, like 테이블에 좋아요를 누른 userID와 게시글의 ID가 삽입됨
         if (count == 0) {
            petsitterLikeFacade.insertLike(petsitterLike);
         }
         else {
            petsitterLikeFacade.deleteLike(petsitterLike);
         }
         
//         좋아요 개수 가지고 오기
         int boardLike = petsitterLikeFacade.countLike(boardNum);
         
//         좋아요 개수 update
         petsitter.setBoardLike(boardLike);
         petsitterFacade.updateLike(petsitter);
         
         HashMap<String, Integer> map = new HashMap<String, Integer>();
         map.put("count", count);
         map.put("boardLike", boardLike);
         
         return map;
      }
}