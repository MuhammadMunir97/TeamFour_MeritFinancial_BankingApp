package com.meritameirca.banking.app.service;

import java.util.List;
import java.util.Optional;

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
	
	public AccountInternal findById(Long id){
		Optional<AccountInternal> accountInternal = accountInternalRepository.findById(id);
		if(accountInternal.isPresent()) {
			return accountInternal.get();
		}else {
			return null;
		}
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
		Long newNumber =  (long) 100000000 ;
		newNumber += (long) (accountInternalRepository.findTopByOrderByIdDesc().getId() + 1);
		account.setAccountNumber(newNumber);
	}
	
	public AccountInternal findByAccountNumber(Long acccountNumber) {
		Optional<AccountInternal> accountInternal = accountInternalRepository.findByAccountNumber(acccountNumber);
		if(accountInternal.isPresent()) {
			return accountInternal.get();
		}else {
			return null;
		}
	}
	
	public AccountInternal findByUserAndAccountTypeId(User user , Long id) {
		return accountInternalRepository.findByUserAndAccountTypeId(user, id).get(0);
	}
	
	public boolean isAccountClosable(AccountInternal account) {
		int accountType = account.getAccountType().getId().intValue();
		if(accountType == 1) {
			return isSavingsClosable(account);
		}
		return false;
	}
	
	public boolean isSavingsClosable(AccountInternal account) {
		if(account.getUser().getAccountInternals().size() > 1) {
			return false;
		}else {
			return true;	
		}
	}
<<<<<<< HEAD
	public double optimalCd(double deposit, int months, double rate) {
        double percentage = (double) (rate / 100);
        double result = deposit;
        for(int i = 0; i < months/12; i++) {
            if(result == deposit) {
                result += deposit * percentage;
            }
            else if(result != deposit) {
                result += result * percentage;
            }
        }
        double trim = Math.pow(10, 2);
        return Math.round(Math.abs(result - deposit) * trim) / trim;
    }
=======
	
	public void deleteAccount(AccountInternal account) {
		accountInternalRepository.delete(account);
	}
>>>>>>> 9bb1f4807d126d58c1b1bc025a06590c97d7439c
}
