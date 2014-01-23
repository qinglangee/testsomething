package a;

import java.rmi.RemoteException;
import java.util.Date;

public class ServiceA implements IServiceA {

	@Override
	public String get() throws RemoteException {
		return "get service" + new Date();
	}

}
