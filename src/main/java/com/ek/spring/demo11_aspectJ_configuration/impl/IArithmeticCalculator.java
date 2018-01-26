package com.ek.spring.demo11_aspectJ_configuration.impl;
/**
 * 需求1-日志:在程序执行期间追踪正在发生的活动
 * 需求2-验证:希望计算机只能处理正数的运算
 * (这里使用aspectJ实现-1.注解实现(还有2配置实现))
 * @author EK
 * @date 2017年8月9日
 */
public interface IArithmeticCalculator {
	int add(int i, int j); //加
	int sub(int i, int j); //减
	int mul(int i, int j); //乘
	int div(int i, int j); //除
}