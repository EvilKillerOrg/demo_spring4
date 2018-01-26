package com.ek.spring.demo04_SpEL;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
/**
 * SpEL 语言 在配置文件中有例子
 * @author EK
 * @date 2017年8月7日
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext_demo04.xml")
public class MyTest extends AbstractJUnit4SpringContextTests{
	
	@Test
	public void testSpEL(){
		Address address = (Address)applicationContext.getBean("address");
		System.out.println(address);
		
		Employee employee = (Employee)applicationContext.getBean("employee");
		System.out.println(employee);
		
		Department department = (Department)applicationContext.getBean("department");
		System.out.println(department);
	}

}