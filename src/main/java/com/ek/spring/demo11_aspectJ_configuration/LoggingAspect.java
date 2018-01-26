package com.ek.spring.demo11_aspectJ_configuration;

import java.util.Arrays;
import java.util.List;

import org.aspectj.lang.JoinPoint;

/**
 */
 

public class LoggingAspect {
  
	public void beforeMethod(JoinPoint joinPoint){
		String methodName = joinPoint.getSignature().getName(); //通过方法签名获得方法名
		List<Object> args = Arrays.asList(joinPoint.getArgs()); //获取参数值
		System.out.println("the method "+methodName+" begins with "+args );
	}

	
	
		
	
	public void afterMethodReturning(JoinPoint joinPoint , Object result){
	  String methodName = joinPoint.getSignature().getName();
	  System.out.println("the method "+methodName+" returning: "+result);
	}
	
	
	
	
	
	public void afterMethodThrowing(JoinPoint joinPoint,Exception exception){
	  String methodName = joinPoint.getSignature().getName();
	  System.out.println("the method "+methodName+" exception: "+exception);
	}
 
  
 
  
  
  public void afterMethod(JoinPoint joinPoint){
    String methodName = joinPoint.getSignature().getName();
    System.out.println("the method "+methodName+" end");
  }
	
	
	
	
  
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