package com.meritameirca.banking.app.controllers;

import java.sql.Timestamp;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.meritameirca.banking.app.models.TransactionLog;
import com.meritameirca.banking.app.service.AccountService;
import com.meritameirca.banking.app.service.TransactionService;

@Controller
public class TransactionController {
	
	private final TransactionService transactionService;
	private final AccountService accountService;

	public TransactionController(TransactionService transactionService , AccountService accountService) {
		this.transactionService = transactionService;
		this.accountService = accountService;
	}
	
	@RequestMapping("/accounts/{id}")
	public String depositWithdrawAndTransactionHistory(@ModelAttribute("tranasction") TransactionLog transactionLog , Model model , @PathVariable("id") Long id , HttpSession session) {
		Long userId = (Long) session.getAttribute("userId");
		if(userId == null) {
			return "redirect:/login";
		}else {
			model.addAttribute("account" , accountService.findById(id));
			model.addAttribute("transactionTypes", transactionService.findAllTransactionTypes());
			return "/view/Transaction.jsp";
		}
	}
	
	@PostMapping("/accounts/{id}")
	public String processTransaction(@Valid @ModelAttribute("tranasction") TransactionLog transactionLog , BindingResult bindingResult ,  @PathVariable("id") Long id , HttpSession session) {
		Long userId = (Long) session.getAttribute("userId");
		if(userId == null) {
			return "redirect:/login";
		}else {
			if(bindingResult.hasErrors()) {
				System.out.println("error");
				return "redirect:/accounts/{id}";
			}else {
				System.out.println("notAerror");
				transactionLog.setAccountInternal(accountService.findById(id));
				//Timestamp postDate = new Timestamp(System.currentTimeMillis());
				//transactionLog.setPostDate(postDate);
				System.out.print(transactionService.saveTransaction(transactionLog));
				return "redirect:/accounts/{id}";
			}
		}
	}
	// problem deal with setting the id of transactiontype to long id
}
