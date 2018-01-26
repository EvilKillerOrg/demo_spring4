package com.ek.spring.demo07_annotation;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ek.spring.demo07_annotation.controller.UserController;
import com.ek.spring.demo07_annotation.repository.IUserRepository;
import com.ek.spring.demo07_annotation.service.UserService;

/**
 * Spring注解:
 * Spring会自动扫描带有注解的组件:
 * 
 * @ Component 基本注解,标识了一个受Spring管理的组件
 * @ Repository 标识持久层组件
 * @ Service 标识服务层(业务层)组件
 * @ Controller 标识表现层组件
 * Spring有默认的命名策略:使用非限定名,第一个字母小写,也可以在注解中通过value属性值标识组件的名称
 * 
 * 还会自动注册AutowiredAnnotationBeanPostProcessor实例(bean后置处理器)
 * 以自动装配具有	@ Autowired 	@ Resource 	@ Inject 注解的属性
 * @ Autowired 构造器 普通字段 有参数的方法上(比如放在set方法上)
 * @ Resource 
 * @ Inject
 * 
 * 
 * 配置:
 * 指定Spring IoC 容器扫描的包
 * <context:component-scan> 看配置文件吧
 * 
 * @author EK
 * @date 2017年8月7日
 */
 
public class Test {

	/*测试annotation 配置的bean*/
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext_demo07.xml");
	  
//		// "myObject" 是默认的命名规则第一个字母小写
//		MyObject myObj = (MyObject) context.getBean("myObject"); 
//		System.out.println(myObj);
		
		 // "userController" 是默认的命名规则第一个字母小写
		 UserController userController = (UserController) context.getBean("userController");
		 System.out.println(userController);
		 userController.execute();
//		
//		// "userService" 是默认的命名规则第一个字母小写
//		UserService userService = (UserService) context.getBean("userService");
//		System.out.println(userService);
//		
//		// "UserRepositoryImpl" 是默认的  可以指定value的值为userRepository 去实现类里看吧
//		IUserRepository userRepository = (IUserRepository) context.getBean("userRepository");
//		System.out.println(userRepository);
//		
		
	}
}