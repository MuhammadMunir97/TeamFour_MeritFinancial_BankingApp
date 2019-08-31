package com.meritameirca.banking.app.service.transactions;

public class Deposit implements Transaction {

	@Override
	public Double processingMoney(Double money, Double currentBalance) {
		currentBalance += money;
		return currentBalance;
	}

}
