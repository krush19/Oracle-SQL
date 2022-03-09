package com.mastek.demo;

import com.mastek.demo.model.Greeting;

public class App {

	public static void main(String[] args) {
		Greeting greeting1=new Greeting("Hello World!");
		Greeting greeting2=new Greeting("Good Morning!");
		Greeting greeting3=new Greeting("Happy New Year!");
		System.out.println(greeting1.greet());
		System.out.println(greeting2.greet());
		System.out.println(greeting3.greet());
	}

}
