package com.mastek.bankapp;

import java.util.Scanner;

import com.mastek.bankapp.model.BankAccount;
import com.mastek.bankapp.model.SalaryAccount;
import com.mastek.bankapp.model.SavingAccount;

public class BankApp {
	private static Scanner sc = new Scanner(System.in);
	private static BankAccount[] accounts = new BankAccount[10];

	public static void main(String[] args) {
//		final double amount = 100000.00;s
//		BankAccount account = null;
		boolean test = true;
		while(test) {
		System.out.println("1. Open Account");
		System.out.println("2. Get Balance");
		System.out.println("3. Withdraw");
		System.out.println("4. Deposit");
		String choice = sc.nextLine();
		switch (choice) {
		case "1":
			System.out.println("1. Saving Account");
			System.out.println("2. Salary Account");
			int ch = sc.nextInt();
			switch (ch) {
			case 1:
				System.out.println("a. MIN_Bal 1000");
				System.out.println("b. MIN_Bal 10000");
				char c = sc.next().charAt(0);
				switch (c) {
				case 'a':
					openSaving1000Balance();
					break;
				case 'b':
					openSaving10000Balance();
					break;
				}
				break;
			case 2:
				openSalaryAcc();
				break;
			}
			break;
		case "2":
			getBalance();
			break;
		case "3":
			withdrawAmount();
			break;
		case "4":
			depositAmount();
			break;
//		default: 
//			break;
		}
		System.out.println("Do you want to continue y/n?");
        choice = sc.nextLine();
        if (choice.equalsIgnoreCase("n")) {
        	test=false;
        }
//        else {
//        	break;
//        }
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
		System.out.println("Enter account number:");
		int accountNo=sc.nextInt();
		System.out.println("Enter amount:");
		double amount=sc.nextDouble();
		for(int i=0;i<accounts.length;i++) {
			if(accounts[i].getAccNo()==accountNo) {
				String res=accounts[i].withdraw(amount);
				System.out.println(res);
				break;
			}
		}	
	}

	private static void depositAmount() {
		System.out.println("Enter account number:");
		int accountNo=sc.nextInt();
		System.out.println("Enter amount:");
		double amount=sc.nextDouble();
		for(int i=0;i<accounts.length;i++) {
			if(accounts[i].getAccNo()==accountNo) {
				String res=accounts[i].deposit(amount);
				System.out.println(res);
				break;
			}
		}	
		
	}

	private static void openSalaryAcc() {
		// TODO Auto-generated method stub
		System.out.println("Enter full name");
		sc.next();
		String accName=sc.nextLine();
		System.out.println("Enter balance ");
		double balance=Double.parseDouble(sc.nextLine());
		SalaryAccount account=new SalaryAccount(accName, balance, 0);
		for(int i=0;i<accounts.length;i++){
			if(accounts[i]==null){
				accounts[i]=account;
				break;
			}
	}
	}

	private static void openSaving10000Balance() {
		System.out.println("Enter full name");
		sc.next();
		String accName=sc.nextLine();
		System.out.println("Enter balance ");
		double balance=Double.parseDouble(sc.nextLine());
		if (balance<10000) {
			System.out.println("Enter more than 1000"); 
		}
		else {
			SavingAccount account=new SavingAccount(accName, balance, 10000);
			for(int i=0;i<accounts.length;i++){
				if(accounts[i]==null){
					accounts[i]=account;
					break;
				}
		}
		
	}
		
	}

	private static void openSaving1000Balance() {
		System.out.println("Enter full name");
		sc.next();
		String accName=sc.nextLine();
		System.out.println("Enter balance ");
		double balance=Double.parseDouble(sc.nextLine());
		if (balance<1000) {
			System.out.println("Enter more than 1000"); 
		}
		else {
			SavingAccount account=new SavingAccount(accName, balance, 1000);
			for(int i=0;i<accounts.length;i++){
				if(accounts[i]==null){
					accounts[i]=account;
					break;
				}
			}
		
		}
	}

//sc.close();
}
