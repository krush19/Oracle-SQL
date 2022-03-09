package com.mastek.bankapp.model;

public class BankAccount {

	private int accNo;
	private String accName;
	private double balance;
	private static int counter=1001;
	
	public BankAccount(){
		this.accNo=counter++;
	}
	public BankAccount(String accName,double balance){
		this();
		this.accName=accName;
		this.balance=balance;
	}
	public BankAccount(int accNo,String accName,double balance){
		this.accNo=accNo;
		this.accName=accName;
		this.balance=balance;
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
	public String withdraw(double amount) {
		this.balance=this.balance-amount;
		return this.accNo
				+" withdraw with "+amount
				+". Current Balance is  "+this.balance;
	}
	
	
	
}
