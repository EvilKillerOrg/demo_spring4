package com.ek.spring.demo04_SpEL;

public class Department {
	private Employee employee; //得到employee的所有
	private String city; //从Address.city 得到
	private String info; // ? '':'' 运算得到
	
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	
	@Override
	public String toString() {
		return "Department [employee=" + employee + ", city=" + city + ", info=" + info + "]";
	}
}