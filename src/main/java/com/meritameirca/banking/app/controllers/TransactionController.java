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

import com.meritameirca.banking.app.models.AccountInternal;
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
			if(session.getAttribute("isTransActionSuccessfull") != null) {
				boolean isTransActionSuccessfull = (boolean) session.getAttribute("isTransActionSuccessfull");
				if(isTransActionSuccessfull) {
					model.addAttribute("message", "transaction successfull");
				}else {
					model.addAttribute("message", "transaction Rejected");
				}
			}
			return "/view/Transaction.jsp";
		}
	}
	
	@PostMapping("/accounts/{accountId}")
	public String processTransaction(@Valid @ModelAttribute("tranasction") TransactionLog transactionLog , BindingResult bindingResult ,  @PathVariable("accountId") Long accountId , HttpSession session , Model model) {
		Long userId = (Long) session.getAttribute("userId");
		if(userId == null) {
			return "redirect:/login";
		}else {
			if(bindingResult.hasErrors()) {
				System.out.println("error");
				return "redirect:/accounts/{accountId}";
			}else {
				transactionLog.setAccountInternal(accountService.findById(accountId));
				Timestamp postDate = new Timestamp(System.currentTimeMillis());
				transactionLog.setPostDate(postDate);
				boolean isTransActionSuccessfull = false;
				if(transactionLog.getTransactionType().getId() == 3) {
					AccountInternal accountTransferedTo = accountService.findByAccountNumber(transactionLog.getAccountInternalTransferTo());
					if(accountTransferedTo == null) {
						session.setAttribute("isTransActionSuccessfull", false);
						System.out.println("im here");
						return "redirect:/accounts/{accountId}";
					}else {
						isTransActionSuccessfull = transactionService.saveTransaction(transactionLog , accountTransferedTo);
					}
				}else {
					isTransActionSuccessfull = transactionService.saveTransaction(transactionLog);
				}
				session.setAttribute("isTransActionSuccessfull", isTransActionSuccessfull);
				return "redirect:/accounts/{accountId}";
			}
		}
	}
	// problem deal with setting the id of transactiontype to long id
}
