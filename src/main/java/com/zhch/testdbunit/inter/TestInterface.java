package com.zhch.testdbunit.inter;

import org.dbunit.dataset.IDataSet;
import org.dbunit.util.fileloader.DataFileLoader;
import org.dbunit.util.fileloader.FullXmlDataFileLoader;

public class TestInterface {
	public void test() throws Exception {
		IDataSet ds = getDataSet();
		int a = 3;
		System.out.println(a);
	}
	
	protected IDataSet getDataSet() throws Exception {
//		FlatXmlDataSetBuilder b =  new FlatXmlDataSetBuilder();
//		FileInputStream fs = new FileInputStream(
//		"/home/lifeix/workspace/lifeix-eatables/src/test/java/com/l99/dao/eatables/impl/dataset.xml");
		
		DataFileLoader loader = new FullXmlDataFileLoader();
		IDataSet ds = loader.load("/com/zhch/testdbunit/inter/dataset.xml");
		return ds;
	}

	public static void main(String[] args) throws Exception {
		TestInterface t = new TestInterface();
		t.test();
	}
}
