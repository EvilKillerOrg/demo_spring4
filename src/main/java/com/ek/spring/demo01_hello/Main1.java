package com.ek.spring.demo01_hello;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
/**
 * 1.获取配置文件
 * interface ApplicationContext 
 * 实现类 
 * FileSystemXmlApplicationCentext("classpath:")
 * ClassPathXmlApplicationContext();
 * 2.getBean()方法 获取配置文件注入的bean scope 模式是 singleton 需要多个实例用 prototype
 * 
 * @author EK
 * @date 2017年8月7日
 */
public class Main1 {

	@SuppressWarnings("resource")
	public static void main(String[] args){
		
		// ApplicationContext 的 两个实现
		ApplicationContext context1 = new FileSystemXmlApplicationContext("classpath:applicationContext_demo01.xml");
		ApplicationContext context2 = new ClassPathXmlApplicationContext("applicationContext_demo01.xml");
		 
		
		HelloWorld hello1 = (HelloWorld) context1.getBean("helloWorld");
		HelloWorld hello2 = (HelloWorld) context2.getBean("helloWorld");
		
		
		hello1.sayHello();
		hello2.sayHello();
		
		
		
		
		// 测试bean的作用域
		HelloWorld scopeTest1 = (HelloWorld) context2.getBean("scopetest"); 
		HelloWorld scopeTest2 = (HelloWorld) context2.getBean("scopetest"); 
		
		if(scopeTest1==scopeTest2){
			System.out.println("singleton");
		}else{
			System.out.println("prototype");
		}
	}
}