package com.zhch.testjmx;


import java.lang.management.ManagementFactory;

import javax.management.MBeanServer;
import javax.management.ObjectName;


public class JmxMain {
	private static ObjectName objectName;
	private static MBeanServer mBeanServer;

	public static void main(String[] args) throws Exception {
		init();
		manage();
		Thread.sleep(1000*600);
	}

	private static void init() throws Exception {
		ServerImpl serverImpl = new ServerImpl();
//		NotificationMonitor serverMonitor = new NotificationMonitor(serverImpl);
		ServerMonitorMBean serverMonitor = new ServerMonitor(serverImpl);
//		mBeanServer = MBeanServerFactory.createMBeanServer();
		mBeanServer = ManagementFactory.getPlatformMBeanServer();
		objectName = new ObjectName("objectName:id=ServerMonitor1");
		mBeanServer.registerMBean(serverMonitor, objectName);
	}

	private static void manage() throws Exception {
		Long upTime = (Long) mBeanServer.getAttribute(objectName, "UpTime");
		System.out.println(upTime);
	}
}
