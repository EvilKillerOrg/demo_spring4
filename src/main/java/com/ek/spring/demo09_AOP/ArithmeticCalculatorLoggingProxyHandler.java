package com.ek.spring.demo09_AOP;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * 使用动态代理实现日志
 * @author EK
 * @date 2017年8月9日
 */
public class ArithmeticCalculatorLoggingProxyHandler implements InvocationHandler{

	/*要代理的对象(即真是角色)*/
	private IArithmeticCalculator target;
	
	
	
	
	/*代理对象构造器 (需要传入真实角色)	*/
	public ArithmeticCalculatorLoggingProxyHandler(IArithmeticCalculator target) {
		this.target = target;
	}

	
	
	
	/*当调用代理对象的引用时,该执行的代码*/
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		//执行前
		System.out.println("method "+method.getName()+" begins with " + Arrays.asList(args));
		//执行
		Object result = method.invoke(target, args);  
		//执行后
		System.out.println("method "+method.getName()+" end with " + result);
		return  result;
	}
	
	
	
	
	/*返回代理对象*/
	public IArithmeticCalculator getLogginProxy(){
		IArithmeticCalculator proxy = null;
		
		//代理对象由哪个类加载器负责
		ClassLoader loader = target.getClass().getClassLoader();
		//代理对象的类型,即其中有哪些方法
		Class<?>[] interfaces = new Class[]{IArithmeticCalculator.class};
		//代理对象
		ArithmeticCalculatorLoggingProxyHandler h = new  ArithmeticCalculatorLoggingProxyHandler(target);
		
		//获得代理对象
		proxy =  (IArithmeticCalculator) Proxy.newProxyInstance(loader, interfaces, h);
		
		return proxy;
		  
	}
	
	
	

}