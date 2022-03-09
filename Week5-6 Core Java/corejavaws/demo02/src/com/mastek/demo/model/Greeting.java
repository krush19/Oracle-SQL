package com.mastek.demo.model;

public class Greeting {
	private int id;
	private String message;
	private static int counter=1;
	//alt+s+c : Default constructor	
	public Greeting() {
		super();
		this.id=counter++;
		this.message="Hello World";
	}
	
	public String greet(){
		return this.id+" "+this.message;
	}
	
	
}
