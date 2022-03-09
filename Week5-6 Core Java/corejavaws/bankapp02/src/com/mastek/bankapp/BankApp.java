package com.mastek.bankapp;

import java.util.Scanner;

import com.mastek.bankapp.model.BankAccount;

public class BankApp {
	private static BankAccount[] accounts = new BankAccount[10];
	private static Scanner sc;

	public static void main(String[] args) {
		loadAccounts();
		
		sc = new Scanner(System.in);
		boolean test = true;
		String choice = "";
		while (test) {
			System.out.println("Select Opearations from below details:");
			System.out.println("1.Open new account");
			System.out.println("2.Deposit Amount");
			System.out.println("3.Withdraw Amount");
			System.out.println("4.Show All accounts");
			choice = sc.nextLine();
			switch (choice) {
			case "1":
			 openNewAccount();
				break;
			case "2":
				depositAmount();
				break;

			case "3":
				withdrawAmount();
				break;
			 
			case "4":
				showAllAccounts();
				break;

			default:
				break;
			}
			System.out.println("Do you want to continue y/n?");
			choice = sc.nextLine();
			if(choice.equalsIgnoreCase("n")){test=false;}
		}
		sc.close();
	}

	private static void openNewAccount() {
		System.out.println("Enter full name");
		String accName=sc.nextLine();
		System.out.println("Enter balance ");
		double balance=Double.parseDouble(sc.nextLine());
		BankAccount account=new BankAccount(accName, balance);
		for(int i=0;i<accounts.length;i++){
			if(accounts[i]==null){
				accounts[i]=account;
				break;
			}
		}	
		System.out.println("New Account details \n"
		+"Account Number: "+account.getAccNo()
		+"Account Holder Name: "+account.getAccName()
		+"Balance: "+account.getBalance()	
				);
	}

	private static void withdrawAmount() {
		System.out.println("Enter the accNo");
		int accNo = Integer.parseInt(sc.nextLine());

		System.out.println("Enter the amount to be deposited");
		double amount = Double.parseDouble(sc.nextLine());
		for(BankAccount a : accounts){
			if(a==null){
				System.out.println("Account number "+accNo+" Not found");
				break;
			}else if (accNo == a.getAccNo()) {
				System.out.println(a.withdraw(amount));
				break;
			}
		}
		
	}

	private static void depositAmount() {
		System.out.println("Enter the accNo");
		int accNo = Integer.parseInt(sc.nextLine());

		System.out.println("Enter the amount to be deposited");
		double amount = Double.parseDouble(sc.nextLine());

		for(BankAccount a :accounts){
			if(a==null){
				System.out.println("Account number "+accNo+" Not found");
				break;
			}else if (accNo == a.getAccNo()) {
				System.out.println(a.deposit(amount));
				break;
			}
		}	

	}

	private static void showAllAccounts() {
		for (BankAccount account : accounts) {
			if(account!=null)
				System.out.println(account.getAccNo() + " " + account.getAccName() + " " + account.getBalance());
		}
	}

	private static void loadAccounts() {
		accounts[0] = new BankAccount("Ajit", 10000.00);
		accounts[1] = new BankAccount("Amit", 10000.00);
		accounts[2] = new BankAccount("Ankit", 10000.00);
	}

}
