package com.ssd.petMate.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ValidationUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.support.SessionStatus;

import com.ssd.petMate.domain.Gpurchase;
import com.ssd.petMate.domain.Info;
import com.ssd.petMate.domain.Secondhand;
import com.ssd.petMate.service.GpurchaseFacade;
import com.ssd.petMate.service.InfoFacade;
import com.ssd.petMate.service.SecondhandImpl;

@Controller
public class SecondhandFormController {
	@Autowired
	private SecondhandImpl secondhandImpl;
	
	@Value("secondhand/secondhandForm")
	private String formViewName;
	
	@Value("redirect:/secondhand")
	private String successViewName;
	
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
	
	@PostMapping("/secondhandForm")
	public String secondhandInsert(@Valid @ModelAttribute("secondhand") Secondhand secondhand, BindingResult result, HttpServletRequest request) {		
		//게시글 제목 길이
//		if (info.getBoardTitle().length() > 25) {
//			result.rejectValue("boardTitle", "long");
//		}
//		
//		ValidationUtils.rejectIfEmptyOrWhitespace(result, "boardTitle", "blank");
//		ValidationUtils.rejectIfEmptyOrWhitespace(result, "boardContent", "blank");
		
		if (result.hasErrors()) {
			return "secondhand/secondhandForm";
		}
		
		if (request.getParameter("boardNum") == null) {
			secondhand.setUserID(request.getSession().getAttribute("userID").toString());
			secondhandImpl.insertSecondhand(secondhand);
		}
		
		else {
			secondhandImpl.updateSecondhand(secondhand);
		}
		return successViewName;
	}
	
	@GetMapping("/secondhandForm")
	public String gpurchaseForm() {
		return formViewName;
	}
		
}