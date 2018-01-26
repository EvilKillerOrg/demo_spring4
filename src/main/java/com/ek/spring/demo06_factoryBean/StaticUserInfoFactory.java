package com.ek.spring.demo06_factoryBean;

import java.util.HashMap;
import java.util.Map;

/**
 * 静态工厂方法: 直接调用某一个类的静态方法就可以返回Bean 的实例
 * 
 * @author EK
 * @date 2017年7月16日
 */
public class StaticUserInfoFactory {

	private static Map<String, UserInfo> userMap = new HashMap<String, UserInfo>();

	static {
		userMap.put("ek", new UserInfo("ek", 19));
		userMap.put("robin", new UserInfo("robin", 40));
		userMap.put("mike", new UserInfo("mike", 17));
	}

	// 静态工厂方法
	public static UserInfo getUserInfo(String username) {
		return userMap.get(username);
	}
}