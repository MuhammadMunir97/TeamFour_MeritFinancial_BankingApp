package com.meritameirca.banking.app.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.meritameirca.banking.app.models.AccountInternal;
import com.meritameirca.banking.app.models.AccountType;
import com.meritameirca.banking.app.models.User;
import com.meritameirca.banking.app.service.AccountService;
import com.meritameirca.banking.app.service.AccountTypeService;
import com.meritameirca.banking.app.service.UserService;

@Controller
public class AccountController {
	
	private final AccountService accountService;
	private final UserService userService;
	private final AccountTypeService accountTypeService;
	
	
	
	public AccountController(AccountService accountService, UserService userService,
			AccountTypeService accountTypeService) {
		this.accountService = accountService;
		this.userService = userService;
		this.accountTypeService = accountTypeService;
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
	
	@RequestMapping("/newBankAccount")
	public String newBankAccount(Model model, HttpSession session) {
		Long userId = (Long) session.getAttribute("userId");
		if(userId == null) {
			return "redirect:/login";
		}else {
			model.addAttribute("account_types", accountTypeService.findAllAccountTypes());
			return "view/CreateBankAccountsForUser.jsp";
		}
	}
	
	@RequestMapping("/newBankAccount/{accountTypeId}")
	public String addBankAccount(HttpSession session , Model model, @PathVariable("accountTypeId") Long accountTypeId) {
		Long userId = (Long) session.getAttribute("userId");
		if(userId == null) {
			return "redirect:/login";
		}else {		
				User user = userService.findUserById(userId);
				AccountType accountType = accountTypeService.findById(accountTypeId);
				AccountInternal accountInternal = new AccountInternal();
				accountInternal.setAccountType(accountType);
				boolean accountCreated = accountService.createNewAccount(user, accountInternal);
				if(accountCreated){
					return "redirect:/login";
				}else {
					model.addAttribute("error", "Request rejected! account could not be created");
					model.addAttribute("allAccounts", accountService.findAllUserAccount(user));
					return "/view/UserAccounts.jsp";
			}
		}
	}
}
