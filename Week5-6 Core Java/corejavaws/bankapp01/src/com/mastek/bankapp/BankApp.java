package com.mastek.bankapp;

import com.mastek.bankapp.model.BankAccount;

public class BankApp {

	public static void main(String[] args) {
		BankAccount account=new BankAccount();
		account.setAccName("Riyaz");
		account.setBalance(20000.00);
		System.out.println("AccNo " +account.getAccNo());
		System.out.println("AccName " +account.getAccName());
		System.out.println("Balance " +account.getBalance());
		account=new BankAccount("Ajit Sharma",20000.00);
		System.out.println("AccNo " +account.getAccNo());
		System.out.println("AccName " +account.getAccName());
		System.out.println("Balance " +account.getBalance());
	}

}
