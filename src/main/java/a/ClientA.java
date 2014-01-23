package a;

import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ClientA {
	public void test() throws RemoteException, NotBoundException {
		Registry registry = LocateRegistry.getRegistry("192.168.199.27", 1099);
//		IServiceA service =  (IServiceA)registry.lookup("rmi/serviceA");
		Remote service =  (Remote)registry.lookup("rmi/commentService");
//		System.out.println("Get :" + service.get());
		System.out.println("Get :" + service);
		
		
		Registry registry2 = LocateRegistry.getRegistry("192.168.199.27", 1099);
		IServiceA service2 =  (IServiceA)registry2.lookup("rmi/serviceA");
//		Remote service2 =  (Remote)registry2.lookup("rmi/serviceA");
		System.out.println("Get :" + service2);
		System.out.println("Get :" + service2.get());
	}

	public static void main(String[] args) throws RemoteException, NotBoundException {
		ClientA t = new ClientA();
		t.test();
	}
}
