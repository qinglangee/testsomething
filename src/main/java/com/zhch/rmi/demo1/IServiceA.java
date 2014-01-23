package com.zhch.rmi.demo1;

import java.rmi.Remote;
import java.rmi.RemoteException;
public interface IServiceA extends Remote{
	String get() throws RemoteException;
}
