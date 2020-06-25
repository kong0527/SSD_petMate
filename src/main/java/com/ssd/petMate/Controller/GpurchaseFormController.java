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
import com.ssd.petMate.service.GpurchaseFacade;
import com.ssd.petMate.service.InfoFacade;

@Controller
public class GpurchaseFormController {
	@Autowired
	private GpurchaseFacade gpurchaseFacade;
	
	@Value("Gpurchase/GpurchaseForm")
	private String formViewName;
	
	@Value("redirect:/gpurchase")
	private String successViewName;
	
	@ModelAttribute("gpurchase")
	public Gpurchase formBacking(HttpServletRequest request) {
		if (request.getMethod().equalsIgnoreCase("GET")) {
			Gpurchase gpurchase;
			if(request.getParameter("boardNum") != null) {
				gpurchase = gpurchaseFacade.getGpurchaseDetail(Integer.valueOf(request.getParameter("boardNum")));
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
	
	@PostMapping("/gpurchaseForm")
	public String gpurchaseInsert(@Valid @ModelAttribute("gpurchase") Gpurchase gpurchase, BindingResult result, HttpServletRequest request) {		
		//게시글 제목 길이
//		if (info.getBoardTitle().length() > 25) {
//			result.rejectValue("boardTitle", "long");
//		}
//		
//		ValidationUtils.rejectIfEmptyOrWhitespace(result, "boardTitle", "blank");
//		ValidationUtils.rejectIfEmptyOrWhitespace(result, "boardContent", "blank");
		
		if (result.hasErrors()) {
			return "Gpurchase/GpurchaseForm";
		}
		
		if (request.getParameter("boardNum") == null) {
			gpurchase.setUserID(request.getSession().getAttribute("userID").toString());
			gpurchaseFacade.insertGpurchase(gpurchase);
		}
		
		else {
			gpurchaseFacade.updateGpurchase(gpurchase);
		}
		return successViewName;
	}
	
	@GetMapping("/gpurchaseForm")
	public String gpurchaseForm() {
		return formViewName;
	}
		
}
