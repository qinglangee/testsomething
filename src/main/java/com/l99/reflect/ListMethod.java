package com.l99.reflect;

import java.lang.reflect.Method;
import java.lang.reflect.TypeVariable;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.Modifier;
import javassist.NotFoundException;
import javassist.bytecode.CodeAttribute;
import javassist.bytecode.LocalVariableAttribute;
import javassist.bytecode.MethodInfo;

public class ListMethod {
	public void test() {
		Class face = ListMethod.class;
		Method[] methods = face.getDeclaredMethods();
		for (Method m : methods) {
			String mStr = "";
			System.out.println(m.getName() + "=====================");
			String modifier = Modifier.toString(m.getModifiers());
			System.out.println(modifier);
			System.out.println(m.getReturnType());
			System.out.println("[[params]]");
//			Class[] types = m.getParameterTypes();
//			for (Class type : types) {
//				System.out.println(type.getName());
//			}
			System.out.println(getParams(face, m, 1));
			System.out.println(getParams(face, m, 2));
		}
	}
	public void aa(String a1, String a2){}

	public static String getParams(Class clazz, Method method, int type) {
		String methodName = method.getName();
		Class[] types = method.getParameterTypes();
		StringBuilder sb = new StringBuilder();
		try {
			ClassPool pool = ClassPool.getDefault();
			CtClass cc = pool.get(clazz.getName());
			CtMethod cm = cc.getDeclaredMethod(methodName);
			// 使用javaassist的反射方法获取方法的参数名
			MethodInfo methodInfo = cm.getMethodInfo();
			CodeAttribute codeAttribute = methodInfo.getCodeAttribute();
			if(codeAttribute == null){
				return "";
			}
			LocalVariableAttribute attr = (LocalVariableAttribute) codeAttribute.getAttribute(LocalVariableAttribute.tag);
			if (attr == null) {
				// exception
			}
			String[] paramNames = new String[cm.getParameterTypes().length];
			int pos = Modifier.isStatic(cm.getModifiers()) ? 0 : 1;
			for (int i = 0; i < paramNames.length; i++)
				paramNames[i] = attr.variableName(i + pos);
			// paramNames即参数名
			for (int i = 0; i < paramNames.length; i++) {
//				System.out.println(paramNames[i]);
				if(i > 0){
					sb.append(", ");
				}
				if(type ==1){
					sb.append(types[i].getSimpleName() + " ");
				}
				sb.append(paramNames[i]);
			}
		} catch (NotFoundException e) {
			e.printStackTrace();
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		ListMethod t = new ListMethod();
		t.test();
		System.out.println("pak==");
//		t.test2();
	}
}
