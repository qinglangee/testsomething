package com.zhch.btrace;

import java.util.Random;

public class Case1 {

	public static void main(String[] args) throws Exception{
	      Random random=new Random();
	      int count = 0;
	      CaseObject object=new CaseObject();
	      boolean result=true;
	      while(result){
	    	  count++;
	         result=object.execute(random.nextInt(1000));
	         Thread.sleep(1000);
	      }
	   }
}
