package com.ek.spring.demo05_lifeCycle;

public class UserInfo {

	public UserInfo() {
		System.out.println("---------------UserInfo's Constructor... ");
	}

	private String username;

	public void setUsername(String username) {
		System.out.println("---------------setUsername method... ");
		this.username = username;
	}
	
	public String getUsername() {
		return username;
	}

	//配置文件中配置bean的init-method
	public void myInit() {
		System.out.println("myInit... ");
	}

//配置文件中配置bean的destroy-method
	public void myDestroy() {
		System.out.println("MyDestroy...");
	}

}