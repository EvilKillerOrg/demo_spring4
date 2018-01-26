package com.ek.spring.demo06_factoryBean;

public class UserInfo {

	private String username;
	private Integer age;
	
	
	
	public UserInfo(String username, Integer age) {
		this.username = username;
		this.age = age;
	}

	
	public void setUsername(String username) {
		this.username = username;
	}

	public String getUsername() {
		return username;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}


	@Override
	public String toString() {
		return "UserInfo [username=" + username + ", age=" + age + "]";
	}
}
