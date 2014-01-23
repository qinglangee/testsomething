package com.zhch.testGeneric;

import java.lang.reflect.ParameterizedType;

public class Temp<T> {  
    
    private Class<T> eClass;  
      
    public Temp() {  
        super();  
        eClass = (Class<T>)((ParameterizedType)(this.getClass().getGenericSuperclass())).getActualTypeArguments()[0];  
    }  
  
    public Class<T> getEClass() {  
        return eClass;  
    }  
  
    public void setEClass(Class<T> eClass) {  
        this.eClass = eClass;  
    }  
}  