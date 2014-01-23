package com.zhch.l06init;

public class InitUtil {
	public static void initMemcache(){
		System.setProperty("com.l99.cache.memcachedEnabled", "true");
		System.setProperty("com.l99.cache.memcacheNodes", "n1:192.168.1.53:10101 n2:192.168.1.53:10102");
	}
}
