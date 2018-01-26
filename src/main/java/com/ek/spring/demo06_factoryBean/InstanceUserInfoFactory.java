package com.ek.spring.demo06_factoryBean;

import java.util.HashMap;
import java.util.Map;

/**
 * 实例工厂方法:非静态工厂方法 工厂方法 先要实例化 
 * 
 * @author EK
 * @date 2017年7月16日
 */

public class InstanceUserInfoFactory {
	private Map<String, UserInfo> userMap = null;
	
	
	public InstanceUserInfoFactory() {
		userMap = new HashMap<String, UserInfo>();
		userMap.put("ek", new UserInfo("ek", 19));
		userMap.put("robin", new UserInfo("robin", 40));
		userMap.put("mike", new UserInfo("mike", 17));
	}

	public UserInfo getUserInfo(String username) {
		return userMap.get(username);
	}
}