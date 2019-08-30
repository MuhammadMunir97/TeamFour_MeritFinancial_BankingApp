package com.meritameirca.banking.app.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.meritameirca.banking.app.models.User;
import com.meritameirca.banking.app.service.UserService;

@Controller
public class UserController {
	
	private final UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}
	@RequestMapping("/user")
	public String user(){
		return "/view/Login.jsp";
	}
	
	@PostMapping("/login")
	public String login(@RequestParam("username") String userName , @RequestParam("password") String password , Model model) {
		model.addAttribute("user", userService.loginUserThroughUserNameAndPass(userName, password));
		return "/view/User.jsp";
	}
	
	@RequestMapping("/create_account")
	public String createAccount(@ModelAttribute("user") User user) {
		return "/view/CreateAccount.jsp";
	}
	
	@PostMapping("/create_account")
	public String addAccount(@Valid @ModelAttribute("user") User user , BindingResult bindingResult, RedirectAttributes errorRedirect) {
		if(bindingResult.hasErrors()) {
			errorRedirect.addFlashAttribute("errors", bindingResult.getAllErrors());
			return "/view/CreateAccount.jsp";
		}else {
			userService.saveUser(user);
			return "redirect:/user";
		}
	}
}
