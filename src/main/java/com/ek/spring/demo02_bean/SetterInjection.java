package com.ek.spring.demo02_bean;

import java.util.Date;

/**
 * setter注入
 * @author EK
 * @date 2017年8月7日
 */
@SuppressWarnings("unused")
public class SetterInjection {
	private String username;
	private Integer age;
	 
	
	
	public void setUsername(String username) {
		this.username = username;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	 
	
	
	@Override
	public String toString() {
		return "SetterInjection [username:"+username + " age:"+age+"]";
	}
}