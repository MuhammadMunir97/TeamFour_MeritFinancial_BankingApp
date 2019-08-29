package com.meritameirca.banking.app.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.meritameirca.banking.app.models.User;
import com.meritameirca.banking.app.service.UserService;

@Controller
public class UserController {
	
	private final UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}
	@RequestMapping("/user")
	public String loginUser(){
		return "/view/Login.jsp";
	}
	
	@RequestMapping("/create_account")
	public String createAccount(@ModelAttribute("user") User user) {
		return "/view/CreateAccount.jsp";
	}
	
	@PostMapping("/create_account")
	public String addAccount(@Valid @ModelAttribute("user") User user , BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return "redirect:/create_account";
		}else {
			userService.saveUser(user);
			return "redirect:/user";
		}
	}
}
