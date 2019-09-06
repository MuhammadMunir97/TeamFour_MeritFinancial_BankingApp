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
	private static long accNumber = 000000000;

	public AccountService(AccountInternalRepository accountInternalRepository) {
		this.accountInternalRepository = accountInternalRepository;
	}
	
	public List<AccountInternal> findAllUserAccount(User user){
		return accountInternalRepository.findByUser(user);
	}
	
	public boolean createNewAccount(User user , AccountInternal account) {
		List<AccountInternal> accountsOfType = accountInternalRepository.findByUserAndAccountType(user, account.getAccountType());
		boolean allowedToCreateMoreAccountOfType = checkIfUserCanCreateMoreAccountOfType(accountsOfType , account.getAccountType());
		if(allowedToCreateMoreAccountOfType) {
			account.setUser(user);
			newAccountNumber(account);
			accountInternalRepository.save(account);
			return true;
		}else {
			return false;
		}
	}
	
	public boolean checkIfUserCanCreateMoreAccountOfType(List<AccountInternal> accountsOfType , AccountType accountType) {
		if(accountsOfType == null || accountsOfType.size() == 0 || accountType.getId() == 4) {
			return true;
		}
		if(accountType.getId() == 1 || accountType.getId() == 2 || accountType.getId() == 5 || accountType.getId() == 6 || accountType.getId() == 7) {
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
	public void newAccountNumber(AccountInternal account) {
		Long newNumber = accNumber++;
		account.setAccountNumber(newNumber);
		accNumber = newNumber;
	}
	
}
