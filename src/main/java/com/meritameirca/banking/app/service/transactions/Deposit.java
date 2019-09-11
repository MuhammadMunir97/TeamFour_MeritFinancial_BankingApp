package com.meritameirca.banking.app.service.transactions;

public class Deposit implements Transaction {
	
	private boolean isTransactionSuccessfull;
	
	@Override
	public Double processingMoney(Double money, Double currentBalance) {
		isTransactionSuccessfull = true;
		currentBalance += money;
		return currentBalance;
	}

	@Override
	public boolean getIsTransactionSuccessfull() {
		return isTransactionSuccessfull;
	}

}
