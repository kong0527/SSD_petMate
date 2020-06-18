package com.ssd.petMate.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ssd.petMate.domain.UserList;
import com.ssd.petMate.service.UserImpl;

@Controller
public class SignUpController {

	@Value("user/signUpForm")
	private String formViewName;
	@Value("index")
	private String successViewName;
	
	@Autowired
	private UserImpl userService;
	
	@ModelAttribute("registerForm")
	public RegisterCommand formBackingObject(HttpServletRequest request) throws Exception {
		if (request.getSession().getAttribute("userID") != null) {	// edit an existing account
			String userID = (String)request.getSession().getAttribute("userID");
			return new RegisterCommand(userService.getUserByUserID(userID));
		}
		else {	// create a new account
			return new RegisterCommand();
		}
	}
	
	@GetMapping("/signUp")
	public String showForm() {
		return formViewName;
	}
	
	@RequestMapping(value = "/checkID", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public int checkID(ModelAndView mv, @RequestParam("userID") String userID) {
		return userService.countUserByUserID(userID);
	}
	
	@PostMapping("/signUp")
	public String onSubmit(
			HttpServletRequest request, @Valid @ModelAttribute("registerForm") RegisterCommand regCommand,
			BindingResult result, Model model) throws Exception {

		if (result.hasErrors()) return formViewName;
		
		if (!regCommand.isSamePwdConfirmPwd()) {
			result.rejectValue("confirmPwd", "notSame", "암호가 일치하지 않습니다.");
			return formViewName;
		}
		
		try {
//			회원가입
			UserList user = userService.regComToUser(regCommand);

			if (request.getSession().getAttribute("userID") == null) {
				userService.joinUser(user);
			}
//			회원정보 수정
			else {
				userService.updateUser(user);
			}
		}
		catch (DataIntegrityViolationException ex) {
			result.rejectValue("userID", "USER_ID_ALREADY_EXISTS",
					"User ID already exists: choose a different ID.");
			return formViewName; 
		}
		return successViewName;  
	}
}