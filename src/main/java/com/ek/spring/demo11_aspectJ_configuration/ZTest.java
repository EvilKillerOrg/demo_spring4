package com.ek.spring.demo11_aspectJ_configuration;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ek.spring.demo11_aspectJ_configuration.impl.IArithmeticCalculator;

/**
 * 实现配置文件配置AOP切面
 * @author EK
 * @date 2017年8月9日
 */
public class ZTest {
	public static void main(String[] args) {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("applicationContext_demo11.xml");
		//IArithmeticCalculator ac =  (IArithmeticCalculator) context.getBean("arithmeticCalculator");
		IArithmeticCalculator ac = (IArithmeticCalculator) context.getBean("arithmeticCalculator");
		
		ac.add(2, 3);
		
		ac.div(10, 1);
		
		context.close();
	}
}