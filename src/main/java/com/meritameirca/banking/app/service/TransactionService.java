package com.meritameirca.banking.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.meritameirca.banking.app.models.AccountInternal;
import com.meritameirca.banking.app.models.TransactionLog;
import com.meritameirca.banking.app.models.TransactionType;
import com.meritameirca.banking.app.repositories.AccountInternalRepository;
import com.meritameirca.banking.app.repositories.TransactionLogRepository;
import com.meritameirca.banking.app.repositories.TransactionTypeRepository;
import com.meritameirca.banking.app.service.transactions.Deposit;
import com.meritameirca.banking.app.service.transactions.Transaction;
import com.meritameirca.banking.app.service.transactions.Withdraw;

@Service
public class TransactionService {
	
	private final TransactionLogRepository transactionLogRepository;
	private final TransactionTypeRepository transactionTypeRepository;
	
	public TransactionService(TransactionLogRepository transactionLogRepository , TransactionTypeRepository transactionTypeRepository ) {
		this.transactionLogRepository = transactionLogRepository;
		this.transactionTypeRepository = transactionTypeRepository;
	}
	
	public List<TransactionType> findAllTransactionTypes(){
		return transactionTypeRepository.findAll();
	}
	
	public boolean saveTransaction(TransactionLog transactionLog) {
		Double money = transactionLog.getAmount();
		AccountInternal accountInternal = transactionLog.getAccountInternal();
		if(transactionLog.getTransactionType().getId() == 1) {
			Transaction deposit = new Deposit();
			accountInternal.transaction(money, deposit);
			boolean isTransactionSuccessfull = deposit.getIsTransactionSuccessfull();
			if(isTransactionSuccessfull) {
				transactionLog.setAccountInternal(accountInternal);
				transactionLogRepository.save(transactionLog);
				return true;
			}
			return false;
		}
		if(transactionLog.getTransactionType().getId() == 2) {
			Transaction withdraw = new Withdraw();
			accountInternal.transaction(money, withdraw);
			boolean isTransactionSuccessfull = withdraw.getIsTransactionSuccessfull();
			if(isTransactionSuccessfull) {
				transactionLog.setAccountInternal(accountInternal);
				transactionLogRepository.save(transactionLog);
				return true;
			}
			return false;
		}
		return false;
	}
	
	public List<TransactionLog> findByAccountId(Long id){
		return transactionLogRepository.findByAccountInternalId(id);
	}
	
	public TransactionLog findById(Long id) {
		Optional<TransactionLog> transactionLog = transactionLogRepository.findById(id);
		if(transactionLog.isPresent()) {
			return transactionLog.get();
		}else {
			return null;
		}
	}
}
