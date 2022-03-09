package com.mastek.bankapp.model;

public class SalaryAccount extends SavingAccount {

	public SalaryAccount() {
		super();
		System.out.println("public SalaryAccount() called");
	}

	public SalaryAccount(int accNo, String accName, double balance) {
		super(accNo, accName, balance);
		System.out.println("public SalaryAccount(accNo,accName,balance) called");
	}

	public SalaryAccount(String accName, double balance) {
		super(accName, balance);
		System.out.println("public SalaryAccount(accName,balance) called");
	}
//ALT+S+V

	@Override
	public String withdraw(double amount) {
		if(this.getBalance()>=amount){
//			this.balance=this.balance-amount;
			this.setBalance(this.getBalance()-amount);
			return this.getAccNo()
					+" debited with "+amount
					+". Current Balance is  "+this.getBalance();
		}
		
		return this.getAccNo()+ " current balance is "+this.getBalance()+" try with another amount";
	}
	
	

}
