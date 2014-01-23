package com.zhch.rmi.demo1;

import java.net.URL;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;



public class ServerA {
	public void test() {

		try {

			URL pathUrl = ServerA.class.getClassLoader().getResource("");
			String path = pathUrl.getFile();
			String classpath  = "file:" + path;
			System.out.println("classpath:" + classpath);
			
			System.setProperty("java.rmi.server.codebase", classpath);
			System.setProperty("java.rmi.server.hostname", "192.168.199.27");

			Registry registry = LocateRegistry.getRegistry("localhost", 1099);

			ServiceA commentServiceObj = new ServiceA();
			IServiceA commentService = (IServiceA) UnicastRemoteObject.exportObject(
					commentServiceObj, 0);
			registry.rebind("rmi/serviceA", commentService);
			System.out.println("started...");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		ServerA t = new ServerA();
		t.test();
	}
}
