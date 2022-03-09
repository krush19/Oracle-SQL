package com.mastek.bankapp.model; //JavaBean

public class SavingAccount extends BankAccount {

	public SavingAccount() {
		super();
		System.out.println("public SavingAccount() called");
	}

	public SavingAccount(int accNo, String accName, double balance) {
		super(accNo, accName, balance);
		System.out.println("public SavingAccount(accno,accname,balance) called");
	}

	public SavingAccount(String accName, double balance) {
		super(accName, balance);
		System.out.println("public SavingAccount(accname,balance) called");
	}

	
	
}
