package com.ek.spring.demo09_AOP;

public class Test {
	
	public static void main(String[] args) {
		IArithmeticCalculator ac = new ArithmeticCalculatorImpl();
		
		IArithmeticCalculator proxy =  new ArithmeticCalculatorLoggingProxyHandler(ac).getLogginProxy();
		
		int result = proxy.add(1, 2);
		System.out.println("==>"+result);
		result = proxy.div(2, 2);
		System.out.println("==>"+result);
		
		
		
	}

}
