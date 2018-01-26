package com.ek.spring.demo02_bean;

import java.util.List;



public class Dept {
	private String deptName;
	
	private UserInfo userinfo;
	
	private List<UserInfo> userList;
	
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public void setUserinfo(UserInfo userinfo) {
		this.userinfo = userinfo;
	}
	public void setUserList(List<UserInfo> userList) {
		this.userList = userList;
	}
	
	@Override
	public String toString() {
		
		return "Dept [deptName=" + deptName + ", userinfo=" + userinfo + ", userList=" + userList + "]";
	}
	
	
	 
}
