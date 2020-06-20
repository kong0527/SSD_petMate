package com.ssd.petMate.Controller;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ssd.petMate.domain.Info;
import com.ssd.petMate.service.BestFacade;

@Controller
public class mainController {	

	@Autowired
	private BestFacade bestFacade;
	
	@RequestMapping(value = "/index", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView main(ModelAndView mv, HttpServletRequest request) {
		
		Date mon = new Date();
        try {
           Calendar cal = Calendar.getInstance();
           cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
           mon = cal.getTime();
           System.out.println(mon.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
		List<Info> bestInfo = bestFacade.bestInfo(mon);		
		mv.addObject("bestInfo", bestInfo);
		
		mv.setViewName("index");
		return mv;
	}
	
//	@RequestMapping(value = "/index", method = { RequestMethod.GET, RequestMethod.POST })
//	public ModelAndView index(ModelAndView mv) {
//		mv.setViewName("index");
//		return mv;
//	}
	
	@RequestMapping(value = "/paymentForm", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView paymentForm(ModelAndView mv) {
		mv.setViewName("paymentForm");
		return mv;
	}

	@RequestMapping(value = "/cart", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView cart(ModelAndView mv) {
		mv.setViewName("order/cart");
		return mv;
	}
}