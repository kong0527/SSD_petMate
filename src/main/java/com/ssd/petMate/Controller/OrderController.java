package com.ssd.petMate.Controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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

import com.ssd.petMate.domain.Code;
import com.ssd.petMate.domain.Gpurchase;
import com.ssd.petMate.domain.GpurchaseCart;
import com.ssd.petMate.domain.GpurchaseCartCommand;
import com.ssd.petMate.domain.GpurchaseLineItem;
import com.ssd.petMate.domain.Order;
import com.ssd.petMate.domain.SecondhandCart;
import com.ssd.petMate.page.BoardSearch;
import com.ssd.petMate.service.GLineItemFacade;
import com.ssd.petMate.service.GpurchaseFacade;
import com.ssd.petMate.service.OrderFacade;


@Controller
@SessionAttributes({"cartList", "price"})
public class OrderController {	
	
	@Autowired
	private OrderFacade orderImpl;
	
	@Autowired
	private GLineItemFacade gLineItemImpl;
	
	@Autowired
	private GpurchaseFacade gpurchaseImpl;
	
	@ModelAttribute("gpurchaseOrder")
	public Order formBacking(HttpServletRequest request) {
		if (request.getMethod().equalsIgnoreCase("GET")) {
			Order order = new Order();
			order.setPrice((int)request.getSession().getAttribute("price"));
			return order;
		}
		else
			return new Order();
	}
	
	@ModelAttribute("bankList")
	public List<String> bankList() {
		List<String> bankList = new ArrayList<String>();
		bankList.add("BC");
		bankList.add("하나");
		bankList.add("우리");
		bankList.add("신한");
		bankList.add("삼성");
		bankList.add("현대");
		bankList.add("롯데");
		bankList.add("KB");
		bankList.add("NH");
		bankList.add("외환");
		return bankList;
	}
	
	//장바구니 -> 오더
	@RequestMapping(value = "/gpurchaseCartToOrder", method = RequestMethod.POST)
	@ResponseBody
	public String gpurchaseCartToOrder(@RequestParam(value = "gpurchaseCartList[]") List<String> gpurchaseCartList, @RequestParam(value = "price") Integer price, Model model) {
		System.out.println("orderForm enter;");
		int i;
		Gpurchase gpurchase;
		System.out.println(gpurchaseCartList.toString());
		List<Gpurchase> cartList = new ArrayList<Gpurchase>();
		for(i = 0; i < gpurchaseCartList.size(); i++) {
			gpurchase = gpurchaseImpl.getGpurchaseDetail(Integer.parseInt(gpurchaseCartList.get(i)));
			System.out.println(gpurchase.toString());
			cartList.add(gpurchase);
		}
		System.out.println(cartList.toString());
		System.out.println("price : " + price);
		model.addAttribute("cartList", cartList);
		model.addAttribute("price", price);
		String result = "May I take your order?";
		return result;
	}
	
	@GetMapping("/gpurchaseOrderForm")
	public String gpurchaseOrderForm() {
		return "order/paymentForm";
	}
	
	//공구게시판 주문
	@Transactional
	@PostMapping("/gpurchaseOrder")
	public String gpurchaseOrder(@Valid @ModelAttribute("gpurchaseOrder") Order order, BindingResult result,@ModelAttribute("cartList") List<Gpurchase> cartList, HttpServletRequest request, SessionStatus status) {
			
			if (result.hasErrors()) {
				return "order/paymentForm";
			}
			
			String userID = (String) request.getSession().getAttribute("userID");
			order.setUserID(userID);
			GpurchaseCart gpurchaseCart;
			//order 생
			orderImpl.insertOrder(order);
			System.out.println(order.toString());
			System.out.println("orderNum : " + order.getOrderNum());
			int orderNum = order.getOrderNum();
			//orderNum에 대한 lineItem 매칭
			GpurchaseLineItem gLineItem = new GpurchaseLineItem();
			for(int i = 0; i < cartList.size(); i++) {
				gLineItem.CartToLineItem(cartList.get(i), orderNum);
				System.out.println(gLineItem.toString());
				gLineItemImpl.insertGpurchaseLineItem(gLineItem);
				gpurchaseImpl.updateParticipant(cartList.get(i).getBoardNum());
			}
			//cart제거(주문한 상품 장바구니에서 제거)
			for(int i = 0; i < cartList.size(); i++) {
				gpurchaseCart = new GpurchaseCart(userID, cartList.get(i).getBoardNum());
				gpurchaseImpl.deleteGpurchaseCart(gpurchaseCart);
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