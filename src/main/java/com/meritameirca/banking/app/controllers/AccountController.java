package com.meritameirca.banking.app.controllers;



import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.meritameirca.banking.app.models.AccountInternal;
import com.meritameirca.banking.app.models.User;
import com.meritameirca.banking.app.models.pseudo.CalculateEarnings;
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
	public String showAccounts(HttpSession session , Model model ,  @ModelAttribute("accountInternal") AccountInternal accountInternal) {
		Long userId = (Long) session.getAttribute("userId");
		if(userId == null) {
			return "redirect:/login";
		}else {
			User user = userService.findUserById(userId);
			model.addAttribute("allAccounts", accountService.findAllUserAccount(user));
			model.addAttribute("account_types", accountTypeService.findAllAccountTypes());
			return "/view/UserAccounts.jsp";
		}
	}
	
	@RequestMapping("/accountsInv")
	public String showAccountsInv(HttpSession session , Model model ,  @ModelAttribute("accountInternal") AccountInternal accountInternal) {
		Long userId = (Long) session.getAttribute("userId");
		if(userId == null) {
			return "redirect:/login";
		}else {
			User user = userService.findUserById(userId);
			model.addAttribute("allAccounts", accountService.findAllUserAccount(user));
			model.addAttribute("account_types", accountTypeService.findAllAccountTypes());
			return "/view/UserAccountsInv.jsp";
		}
	}
	@RequestMapping("/newBankAccount")
	public String newBankAccount(Model model, HttpSession session , @ModelAttribute("accountInternal") AccountInternal accountInternal) {
		Long userId = (Long) session.getAttribute("userId");
		if(userId == null) {
			return "redirect:/login";
		}else {
			model.addAttribute("account_types", accountTypeService.findAllAccountTypes());
			return "view/CreateBankAccountsForUser.jsp";
		}
	}
	
	@PostMapping("/newBankAccount")
	public String addBankAccount(HttpSession session , Model model, @Valid @ModelAttribute("accountInternal") AccountInternal accountInternal , BindingResult bindingResult) {
		Long userId = (Long) session.getAttribute("userId");
		if(userId == null) {
			return "redirect:/login";
		}else {	
			if(bindingResult.hasErrors()) {
				return "/view/UserAccounts.jsp";
			}else {
				User user = userService.findUserById(userId);
				accountInternal.setUser(user);
				boolean accountCreated = accountService.createNewAccount(user, accountInternal);
				if(accountCreated){
					if(accountInternal.getAccountType().getId() == 1 || accountInternal.getAccountType().getId() == 2 || accountInternal.getAccountType().getId() == 3) {
						return "redirect:/accounts";
					}else {
						return "redirect:/accountsInv";
					}
				}else {
					model.addAttribute("error", "Request rejected! account could not be created");
					model.addAttribute("allAccounts", accountService.findAllUserAccount(user));
					return "redirect:/accounts";
				}
			}
		}
	}
	
	
	@RequestMapping("/cdRate")
	public String cdRate(HttpSession session , @ModelAttribute("CalculateEarnings") CalculateEarnings earnings) {
		Long userId = (Long) session.getAttribute("userId");
		if(userId == null) {
			return "redirect:/login";
		}else {
			return "/view/OptimalCD.jsp";
		}
	}
	@PostMapping("/calculate_earnings")
	public String calculateEarnings(HttpSession session , @Valid @ModelAttribute("CalculateEarnings") CalculateEarnings earnings , BindingResult bindingResult , Model model) {
		Long userId = (Long) session.getAttribute("userId");
		if(userId == null) {
			return "redirect:/login";
		}else {
			if(bindingResult.hasErrors()) {
				return "redirect:/cdRate";
			}else {
				double interestRate = accountService.calculateInterestRate(earnings.getAmount(), earnings.getMonth());
				double calculatedEarnings = accountService.optimalCd(earnings.getAmount(), earnings.getMonth(),  interestRate);
				double trim = Math.pow(10, 2);
				interestRate = Math.round(Math.abs(interestRate) * trim) / trim;
				calculatedEarnings = Math.round(Math.abs(calculatedEarnings) * trim) / trim;
				model.addAttribute("interestRate", interestRate);
				model.addAttribute("earnings", calculatedEarnings);
				return "/view/OptimalCD.jsp";	
			}
		}
	}
}
