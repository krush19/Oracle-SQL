package com.mastek.bankapp.model; //JavaBean

public class SavingAccount extends BankAccount {

//	private static final double MIN_BAL=10000.00;//single copy constant in Java static final 
	
	public SavingAccount() {
		super();
		System.out.println("public SavingAccount() called");
	}

	public SavingAccount(int accNo, String accName, double balance, int minBal) {
		super(accNo, accName, balance, minBal);
		System.out.println("public SavingAccount(accno,accname,balance) called");
	}

	public SavingAccount(String accName, double balance, int minBal) {
		super(accName, balance, minBal);
		System.out.println("public SavingAccount(accname,balance) called");
	}

	//balance=100000
	//amount=90000
	//diff=10000>=MIN_Bal?true:false
	@Override
	public String withdraw(double amount) {
		final double diff=this.getBalance()-amount;
		if(diff>=this.getMinBal()){
			this.setBalance(diff);
			return this.getAccNo()
					+" debited by "+amount
					+" current balance is "+this.getBalance();
		}
		return this.getAccNo()
				+" current balance is "+this.getBalance()
				+"Try another amount to maintain the Minumum balance of "
				+this.getMinBal();
	}

	
	
	
}
