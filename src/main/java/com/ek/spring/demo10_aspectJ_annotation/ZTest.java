package com.ek.spring.demo10_aspectJ_annotation;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ek.spring.demo10_aspectJ_annotation.impl.IArithmeticCalculator;
/**
 * com.ek.spring.demo10_aspectJ_annotation.LoggingAspect 注解实现切面
 * com.ek.spring.demo10_aspectJ_annotation.ValidationAspect 注解实现切面
 * @author EK
 * @date 2017年8月9日
 */
public class ZTest {
	public static void main(String[] args) {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("applicationContext_demo10.xml");
		//IArithmeticCalculator ac =  (IArithmeticCalculator) context.getBean("arithmeticCalculator");
		IArithmeticCalculator ac = context.getBean(IArithmeticCalculator.class);
		
		ac.add(2, 3);
		
		ac.div(10, 1);
		
		context.close();
	}
}