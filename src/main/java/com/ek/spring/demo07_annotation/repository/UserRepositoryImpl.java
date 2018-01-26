package com.ek.spring.demo07_annotation.repository;

import org.springframework.stereotype.Repository;
/**
 * 标识持久层 
 */
@Repository("userRepository") //value是默认值 可以直接给
public class UserRepositoryImpl implements IUserRepository {

	@Override
	public void save() {
		System.out.println("UserRepositoryImpl.Save()方法.....");
	}

}