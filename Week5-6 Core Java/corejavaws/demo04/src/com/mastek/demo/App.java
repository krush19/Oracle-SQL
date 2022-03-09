package com.mastek.demo;

import com.mastek.demo.model.Greeting;

public class App {

	public static void main(String[] args) {
		Greeting greeting=new Greeting("Hello world");
		greeting.setMessage("Welcome to the world of java");
		System.out.println(greeting.greet());

	}

}
