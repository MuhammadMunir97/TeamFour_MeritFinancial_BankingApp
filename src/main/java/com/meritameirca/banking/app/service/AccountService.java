package com.meritameirca.banking.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.meritameirca.banking.app.models.AccountInternal;
import com.meritameirca.banking.app.models.AccountType;
import com.meritameirca.banking.app.models.User;
import com.meritameirca.banking.app.repositories.AccountInternalRepository;

@Service
public class AccountService {
	
	private final AccountInternalRepository accountInternalRepository;

	public AccountService(AccountInternalRepository accountInternalRepository) {
		this.accountInternalRepository = accountInternalRepository;
	}
	
	public List<AccountInternal> findAllUserAccount(User user){
		return accountInternalRepository.findByUser(user);
	}
	
	public String createNewAccount(User user , AccountInternal account) {
		List<AccountInternal> accountsOfType = accountInternalRepository.findByUserAndAccountType(user, account.getAccountType());
		boolean allowedToCreateMoreAccountOfType = checkIfUserCanCreateMoreAccountOfType(accountsOfType , account.getAccountType());
		if(allowedToCreateMoreAccountOfType) {
			accountInternalRepository.save(account);
			return "A new " + account.getAccountType().getAccTypeName() + " account has been created for you";
		}else {
			return "Request rejected, you have reached the limit for " + account.getAccountType().getAccTypeName() + " account type";
		}
	}
	
	public boolean checkIfUserCanCreateMoreAccountOfType(List<AccountInternal> accountsOfType , AccountType accountType) {
		if(accountsOfType == null) {
			return true;
		}
		if(accountType.getId() == 1 || accountType.getId() == 2) {
				return false;
		}
		if(accountType.getId() == 3) {
			if(accountsOfType.size() < 3) {
				return true;
			}else {
				return false;
			}
		}
		return false;
	}
	
}
