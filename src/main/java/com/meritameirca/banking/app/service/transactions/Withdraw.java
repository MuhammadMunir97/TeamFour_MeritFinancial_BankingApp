package com.meritameirca.banking.app.service.transactions;

public class Withdraw implements Transaction {
	
	private boolean isTransactionSuccessfull;

	@Override
	public Double processingMoney(Double money, Double currentBalance) {
		if(money > currentBalance) {
			isTransactionSuccessfull = false;
			return currentBalance;
		}else {
			isTransactionSuccessfull = true;
			currentBalance -= money;
			return currentBalance;
		}
	}

	@Override
	public boolean getIsTransactionSuccessfull() {
		return isTransactionSuccessfull;
	}
	
}
