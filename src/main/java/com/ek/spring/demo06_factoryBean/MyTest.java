package com.ek.spring.demo06_factoryBean;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext_demo06.xml")
public class MyTest extends AbstractJUnit4SpringContextTests {

	@Test
	public void testStaticFactory() {
		UserInfo userinfo1 = (UserInfo) applicationContext.getBean("userinfo1");
		System.out.println(userinfo1);
	}
	
	
	@Test
	public void testInstanceFactory() {
		UserInfo userinfo2 = (UserInfo) applicationContext.getBean("userinfo2");
		System.out.println(userinfo2);
	}
}
