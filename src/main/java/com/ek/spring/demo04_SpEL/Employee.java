package com.ek.spring.demo04_SpEL;

public class Employee {
	
	private String username;
	private Double salary;
	private Double perimeter; //圆的周长 为了测试SpEl引用static方法 使用了Math.PI
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	public Double getPerimeter() {
		return perimeter;
	}
	public void setPerimeter(Double perimeter) {
		this.perimeter = perimeter;
	}
	@Override
	public String toString() {
		return "Employee [username=" + username + ", salary=" + salary + ", perimeter=" + perimeter + "]";
	}
}