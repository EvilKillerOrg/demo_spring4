package com.ek.spring.demo05_lifeCycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * BeanPostProcessor  Bean后置处理器 (这个权限大了)
 * 允许在调用初始化方法前后对Bean进行额外的处理
 * Bean后置处理器对IoC容器里的所有Bean实例逐一处理,而非单一实例
 */

public class MyBeanPostProcessor implements BeanPostProcessor {

	
	//在init方法前调用这个方法
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println();
		System.out.println("postProcessBeforeInitialization... Bean:" + bean +" , BeanName:"+ beanName );
		
		//自然也可以返回修改后..我可以在这偷梁换柱我new一个给他返回 嘿嘿 比如:
		if("userinfo".equals(beanName)){ //先找到要换的bean
			 UserInfo user = (UserInfo)bean;
			 user.setUsername("hahhaha,我把值换了");
			 bean = user;
		}
		
		return bean;//通常就是检测后返回原生的bean
	}
	
	//在init方法后调用这个方法
	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("postProcessAfterInitialization... Bean: " + bean +" , BeanName: "+ beanName );
		System.out.println();
		return bean;
	}

}