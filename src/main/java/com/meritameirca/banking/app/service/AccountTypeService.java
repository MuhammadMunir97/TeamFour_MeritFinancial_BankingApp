package com.meritameirca.banking.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.meritameirca.banking.app.models.AccountType;
import com.meritameirca.banking.app.repositories.AccountTypeRepository;

@Service
public class AccountTypeService {
	
	private final AccountTypeRepository accountTypeRepository;

	public AccountTypeService(AccountTypeRepository accountTypeRepository) {
		this.accountTypeRepository = accountTypeRepository;
	}
	
	public List<AccountType> findAllAccountTypes(){
		return accountTypeRepository.findAll();
	}
	
	public AccountType findById(Long id) {
		Optional<AccountType> accountType = accountTypeRepository.findById(id);
		if (accountType.isPresent()) {
			return accountType.get();
		}else {
			return null;
		}
	}
}
