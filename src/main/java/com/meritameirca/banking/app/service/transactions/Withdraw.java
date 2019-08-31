package com.meritameirca.banking.app.service.transactions;

public class Withdraw implements Transaction {

	@Override
	public Double processingMoney(Double money, Double currentBalance) {
		if(money > currentBalance) {
			return null;
		}else {
			currentBalance -= money;
			return currentBalance;
		}
	}

}
