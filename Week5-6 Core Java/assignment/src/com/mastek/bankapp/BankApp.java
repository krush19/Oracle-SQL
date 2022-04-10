package com.mastek.bankapp;

import java.util.Scanner;

import com.mastek.bankapp.model.BankAccount;
import com.mastek.bankapp.model.SalaryAccount;

public class BankApp {
	private static BankAccount[] accounts = new BankAccount[10];
	private static Scanner sc;

	public static void main(String[] args) {
		loadAccounts();
		showAllAccounts();
		sc = new Scanner(System.in);
		boolean test = true;
		String choice = "";

		while (test) {
			System.out.println("Select Opearations from below details:");
			System.out.println("1.Open new account");
			System.out.println("2.Get Balance");
			System.out.println("3.Deposit Amount");
			System.out.println("4.Withdraw Amount");
			choice = sc.nextLine();

			switch (choice) {
			case "1":
				System.out.println("Select Opearations from below details:");
				System.out.println("1.Open Saving Account");
				System.out.println("2.Open Salary Account");
				choice = sc.nextLine();
				switch (choice) {
				case "1":
					System.out.println("Select Opearations from below details:");
					System.out.println("1.MIN_Bal 1000");
					System.out.println("2.MIN_Bal 10000");
					choice = sc.nextLine();
					switch (choice) {
					case "1":
						openSavingAcc1000();
						//System.out.println("Saving Account is opened with minimun balance 1000");
						break;

					case "2":
						openSavingAcc10000();
						//System.out.println("Saving Account is opened with minimun balance 10000");
						break;
					}
					break;

				case "2":
					openSalaryAcc();
					//System.out.println("Salaru Account is opened ");
					break;
				}
				break;

			case "2":
				getBalance();
				break;
			case "3":
				depositAmount();
				break;

			case "4":
				withdrawAmount();
				break;

			default:
				break;
			}
			System.out.println("Do you want to continue y/n?");
			choice = sc.nextLine();
		}
		sc.close();
	}

	private static void openSalaryAcc() {
		System.out.println("Enter full name");
		sc.next();
		String accName=sc.nextLine();
		System.out.println("Enter balance ");
		double balance=sc.nextDouble();
			SalaryAccount account=new SalaryAccount(accName, balance, 0);
			for(int i=0;i<accounts.length;i++){
				if(accounts[i]==null){
					accounts[i]=account;
					break;
				}
			}	
			System.out.println("New Salary Account details \n"
			+"Account Number: "+account.getAccNo()
			+"Account Holder Name: "+account.getAccName()
			+"Balance: "+account.getBalance()	
					);
		
	}

	private static void openSavingAcc10000() {
		System.out.println("Enter full name");
		sc.next();
		String accName=sc.nextLine();
		System.out.println("Enter balance ");
		double balance=sc.nextDouble();
		if(balance>=10000) {
			BankAccount account=new BankAccount(accName, balance);
			for(int i=0;i<accounts.length;i++){
				if(accounts[i]==null){
					accounts[i]=account;
					break;
				}
			}	
			System.out.println("New Saving Account details \n"
			+"Account Number:  "+account.getAccNo()
			+"Account Holder Name:  "+account.getAccName()
			+"Balance:  "+account.getBalance()	
					);
		}
		else {
			System.out.println("Please Open Account with minimun balance 10000");
		}
		
	}

	private static void openSavingAcc1000() {
		System.out.println("Enter full name");
		sc.next();
		String accName=sc.nextLine();
		System.out.println("Enter balance ");
		double balance=sc.nextDouble();
		if(balance>=1000) {
			BankAccount account=new BankAccount(accName, balance);
			for(int i=0;i<accounts.length;i++){
				if(accounts[i]==null){
					accounts[i]=account;
					break;
				}
			}	
			System.out.println("New Saving Account details \n"
			+"Account Number: "+account.getAccNo()
			+"Account Holder Name: "+account.getAccName()
			+"Balance: "+account.getBalance()	
					);
		}
		else {
			System.out.println("Please Open Account with minimun balance 1000");
		}
		
	}

	private static void getBalance() {
		System.out.println("Enter the accNo");
		int accountNo = Integer.parseInt(sc.nextLine());
		
		for (BankAccount account : accounts){
			if (account != null && accountNo == account.getAccNo()) {
				System.out.println(account.getBalance());
			}
		}
	}

	private static void withdrawAmount() {
		System.out.println("Enter the accNo");
		int accNo = Integer.parseInt(sc.nextLine());

		System.out.println("Enter the amount to be deposited");
		double amount = Double.parseDouble(sc.nextLine());
		for (int i = 0; i < accounts.length; i++) {

			if (accounts!=null && accNo == accounts[i].getAccNo()) {
				System.out.println(accounts[i].withdraw(amount));
				break;
			}
		}

	}

	private static void depositAmount() {
		System.out.println("Enter the accNo");
		int accNo = Integer.parseInt(sc.nextLine());

		System.out.println("Enter the amount to be deposited");
		double amount = sc.nextDouble();

		for (int i = 0; i < accounts.length; i++) {
			if (accNo == accounts[i].getAccNo()) {
				System.out.println(accounts[i].deposit(amount));
				break;
			}
		}

	}

	private static void showAllAccounts() {
		for (BankAccount account : accounts) {
			if (account != null)
				System.out.println(account.getAccNo() + " " + account.getAccName() + " " + account.getBalance());
		}
	}

	private static void loadAccounts() {
		accounts[0] = new BankAccount("Ajit", 10000.00);
		accounts[1] = new BankAccount("Amit", 20000.00);
		accounts[2] = new BankAccount("Ankit", 30000.00);

	}

}
