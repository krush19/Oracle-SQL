package com.mastek.demo;

import com.mastek.demo.model.Greeting;
//demo02: Greeting->greet()=>message "Hello World"
public class App {
	
	public static void main(String[] args) {
//		Greeting greeting =new Greeting();
//		System.out.println(greeting.greet());
		Greeting greeting1=new Greeting();
		Greeting greeting2=new Greeting();
		Greeting greeting3=new Greeting();
		System.out.println("greeting 1:"+greeting1.greet());
		System.out.println("greeting 2:"+greeting2.greet());
		System.out.println("greeting 3:"+greeting3.greet());
		
	}
	
}