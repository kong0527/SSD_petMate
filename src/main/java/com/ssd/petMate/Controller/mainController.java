package com.ssd.petMate.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class mainController {	
	
	@RequestMapping(value = "/index", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView index(ModelAndView mv) {
		mv.setViewName("index");
		return mv;
	}
	
	@RequestMapping(value = "/login", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView login(ModelAndView mv) {
		mv.setViewName("login");
		return mv;
	}
	
	@RequestMapping(value = "/secondhand", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView detailSecondhand(ModelAndView mv) {
		mv.setViewName("secondhand/categories");
		return mv;
	}
	
	@RequestMapping(value = "/secondhandForm", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView secondhandForm(ModelAndView mv) {
		mv.setViewName("secondhand/secondhandForm");
		return mv;
	}
	
	@RequestMapping(value = "/secondhandDetail", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView secondhandDetail(ModelAndView mv) {
		mv.setViewName("secondhand/secondhandDetail");
		return mv;
	}
	
	@RequestMapping(value = "/GpurchaseForm", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView GpurchaseForm(ModelAndView mv) {
		mv.setViewName("Gpurchase/GpurchaseForm");
		return mv;
	}
	
	@RequestMapping(value = "/inquiryForm", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView InquiryForm(ModelAndView mv) {
		mv.setViewName("inquiryForm");
		return mv;
	}
	
	@RequestMapping(value = "/paymentForm", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView paymentForm(ModelAndView mv) {
		mv.setViewName("paymentForm");
		return mv;
	}
	
	@RequestMapping(value = "/petsitterForm", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView petsitterForm(ModelAndView mv) {
		mv.setViewName("petsitter/petsitterForm");
		return mv;
	}
}
