package com.ek.spring.demo03_dataSource;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
/**
 * 测试获取数据源
 * 配置文件中有几种数据源获取的配置
 * 
 * @author EK
 * @date 2017年8月7日
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext_demo03.xml")
public class TestC3P0 extends AbstractJUnit4SpringContextTests{
	
	@Test
	public void testC3P0DataSource() throws SQLException{
		DataSource dataSource = (DataSource) applicationContext.getBean("dataSource");
		System.out.println(dataSource.getConnection());
	}

}