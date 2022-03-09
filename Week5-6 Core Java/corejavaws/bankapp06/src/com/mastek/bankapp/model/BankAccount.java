package com.mastek.bankapp.model;

public abstract class BankAccount extends Object{

	private int accNo;
	private String accName;
	private double balance;
	private int minBal;
	private static int counter=1001;
	
	public BankAccount(){
		this.accNo=counter++;
		System.out.println("public BankAccount() called");
	}
	public BankAccount(String accName,double balance, int minBal){
		this();
		this.accName=accName;
		this.balance=balance;
		this.minBal=minBal;
	}
	public BankAccount(int accNo,String accName,double balance, int minBal){
		this.accNo=accNo;
		this.accName=accName;
		this.balance=balance;
		this.minBal=minBal;
	}
	public int getAccNo() {
		return accNo;
	}
	public void setAccNo(int accNo) {
		this.accNo = accNo;
	}
	public String getAccName() {
		return accName;
	}
	public void setAccName(String accName) {
		this.accName = accName;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public String deposit(double amount) {
		this.balance=this.balance+amount;
		return this.accNo
				+" credited with "+amount
				+". Current Balance is  "+this.balance;
		
	}
	
//	public String withdraw(double amount) {
//		if(this.balance>=amount){
//			this.balance=this.balance-amount;
//			return this.accNo
//					+" debited with "+amount
//					+". Current Balance is  "+this.balance;
//		}
//		
//		return this.accNo+ " current balance is "+this.balance+" try with another amount";
//	}
	public int getMinBal() {
		return minBal;
	}
	
	public abstract String withdraw(double amount);
	
}
