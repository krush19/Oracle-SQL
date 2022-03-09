package com.mastek.bankapp;

import com.mastek.bankapp.model.BankAccount;
import com.mastek.bankapp.model.SalaryAccount;
import com.mastek.bankapp.model.SavingAccount;

public class BankApp {



	public static void main(String[] args) {
		final double amount=100000.00;
		
		
//		BankAccount account=new BankAccount("Ajit", 100000.00);		
//		System.out.println("BankAccount:="+account.withdraw(amount));
		BankAccount account=null;
		
		account=new SavingAccount("Ankit",10000.00);//Re initializaing account variable
		System.out.println("SavingAccount:="+account.withdraw(amount));
		
		account=new SalaryAccount("Ankita",10000.00);//Re initializaing account variable
		System.out.println("SalaryAccount:="+account.withdraw(amount));
		
		
	}

}
///////// At runtime account object behaves as BankAccount/SavingAccount/SalaryAccount
//////// This is called as Polymorphism
//////// Because SalaryAccount extends SavingAccount extends BankAccount 
///////  SalaryAccount IS A SavingAccount IS A BankAccount
///////  SalaryAccount IS A BankAccount
///////  Java has hierarchical inheritance 
///////  Parent class ref variable can refer to child class object
///////  when parent class ref object behaves like child class we call it Dynamic Polymorphism
/////// To Achieve Dynamic Polymorphism
/////// 1. Inheritance i.e parent -child relation in classes
/////// 2. child must override parent class methods 
/////// 3. while overriding the signature of method remains same
/////// 4. signature of method consist of 
/////// <access_specifier> <return_type> <methodname>([<parameters_type> <parameters>])
/////// no. of paramteres, order of parameters, type of parameters of overriden method must be
/////// same as that of parent class method 
//////   Method overloading ---- not related to any kind of Polymorphism
//////   As in method overloading the signature of method changes as follows:
//////// 1. No. of paramters 2. Order of parameters 3. type of paramters 




