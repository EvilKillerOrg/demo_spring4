package com.ek.spring.demo02_bean;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext_demo02.xml")
public class MyTest extends AbstractJUnit4SpringContextTests {

	
	// set注入
	@Test
	public void testSetterInjection() {
		SetterInjection setin = (SetterInjection) applicationContext.getBean("setin");
		System.out.println(setin);
	}
	
	
	// 构造注入
	@Test
	public void testConstructorInjection(){
		ConstructorInjection constin1 = (ConstructorInjection) applicationContext.getBean("constin1");
		System.out.println(constin1);
		
		ConstructorInjection constin2 = (ConstructorInjection) applicationContext.getBean("constin2");
		System.out.println(constin2);
		
		ConstructorInjection constin3 = (ConstructorInjection) applicationContext.getBean("constin3");
		System.out.println(constin3);
	}
	
	
	//P标签,注入对象和集合
	@Test
	public void testOthers(){
		Dept dept = (Dept) applicationContext.getBean("dept");
		System.out.println(dept);
		
	}

}