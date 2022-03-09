package com.mastek.bankapp;

import java.util.Scanner;

import com.mastek.bankapp.model.BankAccount;

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
			System.out.println("2.Deposit Amount");
			System.out.println("3.Withdraw Amount");
			System.out.println("4.Close account");
			choice = sc.nextLine();
			switch (choice) {
			case "1":
				// openNewAccount();
				break;
			case "2":
				depositAmount();
				break;

			case "3":
				withdrawAmount();
				break;

			case "4":
				break;
			// closeAccount();
			default:
				break;
			}
			System.out.println("Do you want to continue y/n?");
			choice = sc.nextLine();
		}
		sc.close();
	}

	private static void withdrawAmount() {
		System.out.println("Enter the accNo");
		int accNo = Integer.parseInt(sc.nextLine());

		System.out.println("Enter the amount to be deposited");
		double amount = Double.parseDouble(sc.nextLine());
		for (int i = 0; i < accounts.length; i++) {
			if (accNo == accounts[i].getAccNo()) {
				System.out.println(accounts[i].withdraw(amount));
				break;
			}
		}

	}

	private static void depositAmount() {
		System.out.println("Enter the accNo");
		int accNo = Integer.parseInt(sc.nextLine());

		System.out.println("Enter the amount to be deposited");
		double amount = Double.parseDouble(sc.nextLine());

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
		accounts[1] = new BankAccount("Amit", 10000.00);
		accounts[2] = new BankAccount("Ankit", 10000.00);
	}

}
