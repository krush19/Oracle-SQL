package com.mastek.bankapp;

import com.mastek.bankapp.model.BankAccount;
import com.mastek.bankapp.model.SalaryAccount;
import com.mastek.bankapp.model.SavingAccount;

public class BankApp {

	public static void main(String[] args) {
//		lhs ref variable =rhs actual object
		BankAccount account=new BankAccount("Ajit", 100000.00);
		
		System.out.println("After calling \nBankAccount account=new BankAccount('Ajit', 100000.00);");
		System.out.println("\nAccNo "+account.getAccNo()+"\tAccName "+account.getAccName());
		
//		account=new SavingAccount();//Re initializaing account variable
//		System.out.println("After calling \naccount=new SavingAccount();");
//		System.out.println("\nAccNo "+account.getAccNo()+"\tAccName "+account.getAccName());
//		
//		account=new SalaryAccount();//Re initializaing account variable
//		System.out.println("After calling \naccount=new SalaryAccount();");
//		System.out.println("\nAccNo "+account.getAccNo()+"\tAccName "+account.getAccName());
		
		account=new SavingAccount("Ankit",10000.00);//Re initializaing account variable
		System.out.println("After calling \naccount=new SavingAccount();");
		System.out.println("\nAccNo "+account.getAccNo()+"\tAccName "+account.getAccName());
		
		account=new SalaryAccount("Ankita",10000.00);//Re initializaing account variable
		System.out.println("After calling \naccount=new SalaryAccount();");
		System.out.println("\nAccNo "+account.getAccNo()+"\tAccName "+account.getAccName());
		
		
	}

}
