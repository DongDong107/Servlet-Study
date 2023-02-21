package com.newlecture.web;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

import com.newlecture.web.controller.menu.ListPOJOController4;

public class ReflectProgram {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException {
		// TODO Auto-generated method stub
		Object controller = Class
								.forName("com.newlecture.web.controller.menu.ListPOJOController4")
								.getDeclaredConstructor()
								.newInstance();
		
		// 개체명(문자열)에서 클래스 정보 얻기
		Class clsInfo = Class.forName("com.newlecture.web.controller.menu.ListPOJOController4");
		
		// 개체(class)에서 클래스 정보 얻기
		Class clsInfo1 = ListPOJOController4.class;
		
		// 객체에서 클래스 정보 얻기
		Class clsInfo2 = controller.getClass();
		
		Method[] methods = clsInfo.getDeclaredMethods();
		
		Method method = null;
		for(Method m : methods) {
			if(m.getName().equals("add"))
				method = m;
		}
		
//		method.getParameterCount();
		Parameter[] params = method.getParameters();
		for(Parameter p : params) {
			System.out.printf("param : %s\n", p.getType().toString());
		}
		
		Object[] objs = null;
		if(params.length == 1)
			objs = {2};
		
		int result = (int) method.invoke(controller, 3, 4); 
		System.out.printf("result : %d\n", result);
				
		
	}

}
