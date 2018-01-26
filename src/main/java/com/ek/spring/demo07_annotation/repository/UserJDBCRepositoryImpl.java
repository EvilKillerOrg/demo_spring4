package com.ek.spring.demo07_annotation.repository;

import org.springframework.stereotype.Repository;

/**
 *  IUserRepository接口有两个实现的时候
 *  在service装配的时候 装配的对象类型是接口IUserRepository 属性名是userRepository
 *  这时候会找bean的名字 @ Repository("userRepository") 没有显式的给名字的话 会报错没有唯一的bean
 *  
 *  还有一种方式在没有给定service中这个属性名一致的名字时 在service中装配的时候给出一个注解:
 *  //@Qualifier("userJDBCRepositoryImpl")  //指定装配哪一个指定的bean
 *  
 */
@Repository
public class UserJDBCRepositoryImpl implements IUserRepository{

	@Override
	public void save() {
			System.out.println("UserJDBCRepositoryImpl.save()方法");
	}

}