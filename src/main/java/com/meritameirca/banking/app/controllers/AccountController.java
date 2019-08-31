package com.meritameirca.banking.app.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.meritameirca.banking.app.models.User;
import com.meritameirca.banking.app.service.AccountService;
import com.meritameirca.banking.app.service.UserService;

@Controller
public class AccountController {
	
	private final AccountService accountService;
	private final UserService userService;

	public AccountController(AccountService accountService , UserService userService) {
		this.accountService = accountService;
		this.userService = userService;
	}
	
	@RequestMapping("/accounts")
	public String showAccounts(HttpSession session , Model model) {
		Long userId = (Long) session.getAttribute("userId");
		if(userId == null) {
			return "redirect:/login";
		}else {
			User user = userService.findUserById(userId);
			model.addAttribute("allAccounts", accountService.findAllUserAccount(user));
			return "/view/UserAccounts.jsp";
		}
	}
}
