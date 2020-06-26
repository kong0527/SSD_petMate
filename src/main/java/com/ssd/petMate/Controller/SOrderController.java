package com.ssd.petMate.Controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
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
import com.ssd.petMate.domain.GpurchaseLineItem;
import com.ssd.petMate.domain.Order;
import com.ssd.petMate.domain.Secondhand;
import com.ssd.petMate.domain.SecondhandCart;
import com.ssd.petMate.domain.SecondhandLineItem;
import com.ssd.petMate.page.BoardSearch;
import com.ssd.petMate.service.GLineItemFacade;
import com.ssd.petMate.service.GpurchaseFacade;
import com.ssd.petMate.service.OrderFacade;
import com.ssd.petMate.service.SLineItemFacade;
import com.ssd.petMate.service.SecondhandFacade;


@Controller
@SessionAttributes({"sCartList","sprice"})
public class SOrderController {	
	
	@Autowired
	private OrderFacade orderImpl;
	
	@Autowired
	private SLineItemFacade sLineItemImpl;
	
	@Autowired
	private SecondhandFacade secondhandImpl;
	
	@ModelAttribute("secondhandOrder")
	public Order formBacking2(HttpServletRequest request) {
		if (request.getMethod().equalsIgnoreCase("GET")) {
			Order order = new Order();
			order.setPrice((int)request.getSession().getAttribute("sprice"));
			return order;
		}
		else
			return new Order();
	}
	
	//장바구니 -> 오더
	@RequestMapping(value = "/secondhandCartToOrder", method = RequestMethod.POST)
	@ResponseBody
	public String secondhandCartToOrder(@RequestParam(value = "secondhandCartList[]") List<String> secondhandCartList, @RequestParam(value = "sprice") Integer sprice, Model model) {
		System.out.println("orderForm enter;");
		int i;
		Secondhand secondhand;
		System.out.println(secondhandCartList.toString());
		List<Secondhand> sCartList = new ArrayList<Secondhand>();
		for(i = 0; i < secondhandCartList.size(); i++) {
			secondhand = secondhandImpl.getSecondhandDetail(Integer.parseInt(secondhandCartList.get(i)));
			System.out.println(secondhand.toString());
			sCartList.add(secondhand);
		}
		System.out.println(sCartList.toString());
		System.out.println("sprice : " + sprice);
		model.addAttribute("sCartList", sCartList);
		model.addAttribute("sprice", sprice);
		String result = "May I take your order?";
		return result;
	}
	
	@GetMapping("/secondhandOrderForm")
	public String secondhandOrderForm(@ModelAttribute("sCartList") List<Secondhand> sCartList) {
		System.out.println(sCartList.toString());
		return "order/SpaymentForm";
	}
	
	
	//공구게시판 주문
	@Transactional
	@PostMapping("/secondhandOrder")
	public String secondhandOrder(@ModelAttribute("secondhandOrder") Order order, @ModelAttribute("sCartList") List<Secondhand> sCartList, HttpServletRequest request, SessionStatus status) {
			Secondhand secondhand;
			SecondhandCart secondhandCart;
			String userID = (String) request.getSession().getAttribute("userID");
			order.setUserID(userID);
			orderImpl.insertOrder(order);
			System.out.println(order.toString());
			System.out.println("orderNum : " + order.getOrderNum());
			int orderNum = order.getOrderNum();
			SecondhandLineItem sLineItem = new SecondhandLineItem();
			for(int i = 0; i < sCartList.size(); i++) {
				sLineItem.CartToLineItem(sCartList.get(i), orderNum);
				System.out.println(sLineItem.toString());
				sLineItemImpl.insertSecondhandLineItem(sLineItem);
				secondhand = sCartList.get(i);
				secondhand.setBoardTitle("[판매완료] " + sCartList.get(i).getBoardTitle());
				secondhandImpl.secondhandIsSold(sCartList.get(i));
			}
			for(int i = 0; i < sCartList.size(); i++) {
				secondhandCart = new SecondhandCart(userID, sCartList.get(i).getBoardNum());
				secondhandImpl.deleteSecondhandCart(secondhandCart);
			}
			status.setComplete();
		return "order/commit";
	}	

//	//중고물품 삭제
//	@RequestMapping(value = "/gurchaseDelete", method = { RequestMethod.GET, RequestMethod.POST })
//	public String secondhandDelete(@RequestParam("boardNum") int boardNum) {
//		info.deleteSecondhand(boardNum);
//		return "redirect:/secondhand";
//	}
}