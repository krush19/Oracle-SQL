package com.mastek.bankapp.model;

public class BankAccount {
	
	private int accNo;
	private String accName;
	private double balance;
	private static int counter=1000;
	public BankAccount() {
		this.accNo=++counter;
	}
	public BankAccount(String accName, double balance) {
		this();
		this.accName = accName;
		this.balance = balance;
	}
	public BankAccount(int accNo, String accName, double balance) {
		super();
		this.accNo = accNo;
		this.accName = accName;
		this.balance = balance;
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
	
	
	
}
