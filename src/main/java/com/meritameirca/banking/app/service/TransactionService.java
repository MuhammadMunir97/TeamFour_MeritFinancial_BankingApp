package com.meritameirca.banking.app.service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.meritameirca.banking.app.models.AccountInternal;
import com.meritameirca.banking.app.models.AccountType;
import com.meritameirca.banking.app.models.TransactionLog;
import com.meritameirca.banking.app.models.TransactionType;
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
				transactionLog.setAmount(-transactionLog.getAmount());
				transactionLog.setAccountInternal(accountInternal);
				transactionLogRepository.save(transactionLog);
				return true;
			}
			return false;
		}
		return false;
	}
	
	public boolean saveTransaction(TransactionLog transactionLog , AccountInternal accountInternalTo) {
		if(transactionLog.getTransactionType().getId() == 3) {
			AccountInternal accountInternalFrom = transactionLog.getAccountInternal();
			Double money = transactionLog.getAmount();
			Transaction withdraw = new Withdraw();
			Transaction deposit = new Deposit();
			accountInternalFrom.transaction(money, withdraw);
			boolean isTransactionOneSuccessfull = withdraw.getIsTransactionSuccessfull();
			accountInternalTo.transaction(money, deposit);
			boolean isTransactionTwoSuccessfull = deposit.getIsTransactionSuccessfull();
			if(isTransactionOneSuccessfull && isTransactionTwoSuccessfull) {
				transactionLog.setAmount(-transactionLog.getAmount());
				transactionLog.setAccountInternal(accountInternalFrom);
				TransactionLog transactionLogTo = new TransactionLog(null , -transactionLog.getAmount() , transactionLog.getPostDate());
				transactionLogTo.setAccountInternal(accountInternalTo);
				transactionLogTo.setTransactionType(transactionLog.getTransactionType());
				transactionLogRepository.save(transactionLogTo);
				transactionLogRepository.save(transactionLog);
				return true;
			}
			return false;
		}else {
			return false;
		}
	}
	
	public boolean performClosingTransaction(AccountInternal accountFrom , AccountInternal accountTo) {
		AccountType accountType = accountFrom.getAccountType();
		if(accountType.getId() == 1) {
			return false;
		}
		if(accountType.getId() == 2 || accountType.getId() == 3) {
			if(accountFrom.getPresentBalance() < 1) {
				return true;
			}
			TransactionLog transactionLog = new TransactionLog(null , accountFrom.getPresentBalance() , null);
			Timestamp postDate = new Timestamp(System.currentTimeMillis());
			Long typeId = (long) 3;
			Optional<TransactionType> type = transactionTypeRepository.findById(typeId);
			transactionLog.setTransactionType(type.get());
			transactionLog.setPostDate(postDate);
			transactionLog.setAccountInternal(accountFrom);
			return saveTransaction(transactionLog ,accountTo);
		}
		if(accountType.getId() == 5 || accountType.getId() == 6 || accountType.getId() == 7 || accountType.getId() == 4) {
			if(accountFrom.getPresentBalance() < 1) {
				return true;
			}
			Transaction withdraw = new Withdraw();
			Double money = accountFrom.getPresentBalance() * 0.2;
			accountFrom.transaction(money, withdraw);
			TransactionLog transactionLog = new TransactionLog(null , accountFrom.getPresentBalance() , null);
			Timestamp postDate = new Timestamp(System.currentTimeMillis());
			Long typeId = (long) 3;
			Optional<TransactionType> type = transactionTypeRepository.findById(typeId);
			transactionLog.setTransactionType(type.get());
			transactionLog.setPostDate(postDate);
			transactionLog.setAccountInternal(accountFrom);
			return saveTransaction(transactionLog ,accountTo);
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