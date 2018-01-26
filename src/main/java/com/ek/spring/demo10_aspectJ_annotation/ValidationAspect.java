package com.ek.spring.demo10_aspectJ_annotation;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

 

/**
 * 验证切面
 * 这样就有两个切面一个日志切面一个验证切面 哪个在前哪个在后需要设置切面优先级
 */
@Component
@Aspect
@Order(1)//切面优先级 值越小优先级越高
public class ValidationAspect {

  @Before("com.ek.spring.demo10_aspectJ_annotation.LoggingAspect.declareJoinPointExpression()")
  public void validateArgs(JoinPoint joinPoint){
    System.out.println("--> validate: "+Arrays.asList(joinPoint.getArgs()));
  }
}