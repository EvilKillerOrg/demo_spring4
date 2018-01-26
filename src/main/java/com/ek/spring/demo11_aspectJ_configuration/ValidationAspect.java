package com.ek.spring.demo11_aspectJ_configuration;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;

 

/**
 */
 
public class ValidationAspect {

  public void validateArgs(JoinPoint joinPoint){
    System.out.println("--> validate: "+Arrays.asList(joinPoint.getArgs()));
  }
}
