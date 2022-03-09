package com.mastek.demo.model;

public class Greeting extends Object{
	private int id;
	private String message;
	private static int counter=1;
	public Greeting() {	
		System.out.println("Default constructor called");
		this.id=counter++;
	}
	public Greeting(int id, String message) {	
		this.id = id;
		this.message = message;
	}
	public Greeting(String message) {
		this();// calling default constructor of a class		
		this.message = message;
	}
	
	public String greet(){
		return this.id+" "+this.message;
	}

	
}
//Default Constructor: alt+s+c
//Overloaded Constructor: alt+s+a