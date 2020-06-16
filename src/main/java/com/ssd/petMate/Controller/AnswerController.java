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

import com.ssd.petMate.domain.Inquiry;
import com.ssd.petMate.domain.Answer;
import com.ssd.petMate.service.InquiryFacade;
import com.ssd.petMate.service.AnswerFacade;

@Controller
public class AnswerController {

	@Autowired
	private AnswerFacade answerFacade;
	
	@Autowired
	private InquiryFacade inquiryFacade;
	
//	게시글 상세보기를 클릭했을 때 댓글 리스트 가져오기
	@RequestMapping(value = "/answerList", method = { RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public List<Answer> answerList(ModelAndView mv,
			@RequestParam("boardNum") int boardNum) {
		List<Answer> replyList = answerFacade.getReplyList(boardNum);
		return replyList;
	}	
	
//	댓글 입력하기
	@RequestMapping(value = "/insertAnswer", method = RequestMethod.POST)
	@ResponseBody
	public void insertAnswer(ModelAndView mv, HttpServletRequest request,
			@ModelAttribute("infoReply") Answer answer) {
		String userID = (String) request.getSession().getAttribute("userID");
		answer.setUserID(userID);
//		댓글 삽입
		answerFacade.insertReply(answer);
//		게시글 목록에서 댓글 수 확인이 가능하도록 하기 위해 지정
		
		int replyCnt = answerFacade.replyCnt(answer.getBoardNum());
		Inquiry inquiry = inquiryFacade.boardDetail(answer.getBoardNum());
		inquiry.setAnswerCnt(replyCnt);
		
		inquiryFacade.updateReplyCnt(inquiry);
	}
	
//	댓글 수정
	@RequestMapping(value= "/updateAnswer", method = RequestMethod.POST) 
    @ResponseBody
    public void updateInfoReply(ModelAndView mv,
    		@RequestParam("answerNum") int answerNum,
			@RequestParam("replyContent") String replyContent) throws Exception{
        
		Answer answer = new Answer();
		answer.setAnswerNum(answerNum);
		answer.setAnswerContent(replyContent);

		answerFacade.updateReply(answer);
    }
	
//	댓글 삭제
	@RequestMapping(value = "/deleteAnswer", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public void deleteAnswer(ModelAndView mv, HttpServletRequest request,
			@RequestParam("answerNum") int answerNum,
			@RequestParam("boardNum") int boardNum) {
		
		answerFacade.deleteReply(answerNum); // 실제 댓글 없애기 -> 만약 답글이 달린 글이면 답글까지 전부 삭제
		
		int replyCnt = answerFacade.replyCnt(boardNum);
		Inquiry inquiry = inquiryFacade.boardDetail(boardNum);
		inquiry.setAnswerCnt(replyCnt);
		inquiryFacade.updateReplyCnt(inquiry);
	}
	
	@RequestMapping(value = "/answerReReply", method = RequestMethod.POST)
	@ResponseBody
	public void answerComment(ModelAndView mv, HttpServletRequest request,
			@RequestParam("answerNum") int replyNum,
			@RequestParam("replyContent") String replyContent) {
		
		String userID = (String) request.getSession().getAttribute("userID");

//		답글을 달 부모  댓글
		Answer originalReply = answerFacade.replyDetail(replyNum);
		
//		답글의 객체
		Answer reReply = new Answer();
		
//		답글의 GID는 부모 댓글의 ID
		reReply.setReplyParents(replyNum);

//		댓글과 답글의 정렬을 위해 지정
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("replyGID", reReply.getReplyGID());
		map.put("replyOrder", originalReply.getReplyOrder());
		answerFacade.setReplyOrder(map);
		
		reReply.setAnswerContent(replyContent);
		reReply.setReplyOrder(originalReply.getReplyOrder() + 1);
		reReply.setReplyParents(replyNum);
		reReply.setUserID(userID);
		reReply.setBoardNum(originalReply.getBoardNum());
		
		answerFacade.insertReply(reReply);
		
		int replyCnt = answerFacade.replyCnt(originalReply.getBoardNum());
		Inquiry inquiry = inquiryFacade.boardDetail(originalReply.getBoardNum());
		inquiry.setAnswerCnt(replyCnt);
		
		inquiryFacade.updateReplyCnt(inquiry);
	}
}
