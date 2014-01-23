package com.zhch.testGeneric;

public class TempTest {
        
        public TempTest() {  
        }  
      
      
        public static void main(String[] args) {  
        	Temp<String> tmap = new Temp<String>();  
            Class s = String.class;  
            System.out.println(s.equals(tmap.getEClass()));  
            System.out.println(s==tmap.getEClass());  
        }  
}  


