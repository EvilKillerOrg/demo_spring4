package com.ek.spring.demo01_hello;
public class HelloWorld {
	
	private String saySth;
	public void setSaySth(String saySth) {
		this.saySth = saySth;
	}
	

	public void sayHello(){
		System.out.println("Hello "+this.saySth);
	}
	
	
}
