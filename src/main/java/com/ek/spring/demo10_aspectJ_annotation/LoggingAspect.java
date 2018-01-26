package com.ek.spring.demo10_aspectJ_annotation;

import java.util.Arrays;
import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 把这个是一个切面(日志切面)
 * 1. 配置文件配置<aop:aspectj-autoproxy> 使切面的注解起作用,自动为匹配的类生产代理对象
 * 2. 声明类为: IoC容器管理 - 加@Component
 * 3. 声明类为: 一个Aspect切面 - 加@Aspect
 * 4. 声明方法为: 前置通知(在目标方法开始之前执行) - 加@Before()
 * 5. 声明方法为: 后置通知(在目标方法执行后执行,无论是否发生异常) - 加@After()
 * 6. 声明方法为: 返回通知(返回方法执行的结果) - 加@AfterReturning()
 * 7. 声明方法为: 异常通知(返回方法执行时出现的异常,可以指定异常的类型) - 加@AfterThrowing
 * 8. 声明方法为: 环绕通知(类似动态代理的全过程,需要携带ProceedingJoinPoint参数可以决定是否执行目标方法,且必须有返回值既目标方法的返回值) - 加@Around
 * 9. 切入点表达式引用的使用
 * @author EK
 * @date 2017年8月9日
 */
@Component
@Aspect
@Order(2)
public class LoggingAspect {
  
  /*切入点表达式引用的使用 定义一个方法,用于声明切入点表达式,一般这个方法方法体中都不用写代码 (用法看后置通知和验证切面类的前置通知)*/
  @Pointcut("execution(* com.ek.spring.demo10_aspectJ.impl.*.*(..))")
  public void declareJoinPointExpression(){}
	
  
  
  
  
	/*前置通知: 在哪个方法开始之前执行这里*/
	//@Before("execution(public int com.ek.spring.demo10_aspectJ.impl.IArithmeticCalculator.add(int, int))")
	@Before("execution(* com.ek.spring.demo10_aspectJ.impl.*.*(int, int))")
	public void beforeMethod(JoinPoint joinPoint){
		String methodName = joinPoint.getSignature().getName(); //通过方法签名获得方法名
		List<Object> args = Arrays.asList(joinPoint.getArgs()); //获取参数值
		System.out.println("the method "+methodName+" begins with "+args );
	}
	
	
	
	
	
	/*返回通知*/
	@AfterReturning(value="execution(* com.ek.spring.demo10_aspectJ.impl.*.*(..))", returning="result")
	public void afterMethodReturning(JoinPoint joinPoint , Object result){
	  String methodName = joinPoint.getSignature().getName();
	  System.out.println("the method "+methodName+" returning: "+result);
	}
	
	
	
	
	
	/*异常通知*/
	@AfterThrowing(value="execution(* com.ek.spring.demo10_aspectJ.impl.*.*(..))",throwing="exception")
	public void afterMethodThrowing(JoinPoint joinPoint,Exception exception){
	  String methodName = joinPoint.getSignature().getName();
	  System.out.println("the method "+methodName+" exception: "+exception);
	}
	
	
	
	
	
	/*后置通知: 在哪个方法执行之后执行这里(后置通知不能返回方法执行结果,返回通知才可以)*/
  @After("declareJoinPointExpression()")
  public void afterMethod(JoinPoint joinPoint){
    String methodName = joinPoint.getSignature().getName();
    System.out.println("the method "+methodName+" end");
  }
  
  
  
  
  
	/*环绕通知(这个功能强但是不常用)*/
//	@Around("execution(* com.ek.spring.demo10_aspectJ.impl.*.*(..))")
//	public Object aroundMethod(ProceedingJoinPoint pjd){
//	  Object result = null;
//	  String methodName = pjd.getSignature().getName();
//	  
//	  try {
//	    //前置通知
//	    System.out.println("@Around the method "+methodName+" begins with "+Arrays.asList(pjd.getArgs()) );
//	    //执行目标方法
//	    result = pjd.proceed();
//	    //返回通知
//	    System.out.println("@Around the method "+methodName+" returning: "+result);
//    } catch (Throwable e) {
//      //异常通知
//      System.out.println("@Around the method "+methodName+" exception: "+e);
//      throw new RuntimeException(e);
//    }
//	  //后置通知
//	  System.out.println("@Around the method "+methodName+" end");
//	  return result;
//	}
}