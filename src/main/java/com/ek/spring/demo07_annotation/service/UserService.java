package com.ek.spring.demo07_annotation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.ek.spring.demo07_annotation.repository.IUserRepository;

/**
 * 标识服务层 
 */
@Service
public class UserService {
	
	// @Autowired 放在这 或者放在set方法上也ok
	// @Qualifier("userJDBCRepositoryImpl") 放在这 或者放在set方法上也ok
	private IUserRepository userRepository;
	
	@Autowired
	//@Qualifier("userJDBCRepositoryImpl")  //指定装配哪一个指定的bean
	//加这也可以 public void setUserRepository(@Qualifier("userJDBCRepositoryImpl")IUserRepository userRepository) {
	public void setUserRepository(IUserRepository userRepository) {
		this.userRepository = userRepository;
	}

	
	public void add(){
		System.out.println("userService.add()方法.....");
		userRepository.save();
	}
}