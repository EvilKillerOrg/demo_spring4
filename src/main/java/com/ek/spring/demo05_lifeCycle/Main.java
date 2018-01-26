package com.ek.spring.demo05_lifeCycle;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	/**
	 * 看一下 MyBeanPostProcessor 类
	 * Bean的生命周期:
	 * 1.创建bean实例
	 * 2.为Bean的属性赋值
	 * 3.将Bean实例传递给Bean后置处理器的postProcessBeforeInitialization()方法
	 * 4.调用Bean的init-method方法
	 * 5.将Bean实例传递给Bean后置处理器的postProcessAfterInitialization()方法
	 * 6.使用Bean
	 * 7.当IoC容器关闭时,调用Bean的destroy-method方法
	 */
	
	//在这里用 ClassPathXmlApplicationContext 是没有关闭 context的close方法 方法不会走destroy方法
	//在spring-test 中 spring 管理 可以走destroy方法
	public static void main(String[] args) {
		//ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext_demo5.xml");
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext_demo05.xml");
		UserInfo userInfo = (UserInfo) context.getBean("userinfo");
		System.out.println(userInfo.getUsername());
		System.out.println();
		context.close();//实例ClassPathXmlApplicationContext 有close方法
	}
}