package com.ek.spring.demo07_annotation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.ek.spring.demo07_annotation.service.UserService;
/**
 * 标识表现层
 */
@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	public void execute() {
		System.out.println("UserController.execute()方法.....");
		userService.add();
	}
} 