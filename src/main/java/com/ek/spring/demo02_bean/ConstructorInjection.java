package com.ek.spring.demo02_bean;
/**
 * 构造注入
 * @author EK
 * @date 2017年8月7日
 */
public class ConstructorInjection {
	
	private String username;
	private Integer age;
	
	
	public ConstructorInjection( ) {
		 System.out.println("non-parameter constructor");
	}
	
	
	public ConstructorInjection(Integer age) {
		System.out.println("parameter constructor");
		this.age = age;
	}




	public ConstructorInjection(String username, Integer age) {
		System.out.println("full-parameter constructor");
		this.username = username;
		this.age = age;
	}


	@Override
	public String toString() {
		return "ConstructorInjection [username=" + username + ", age=" + age + "]";
	}
	
	

}