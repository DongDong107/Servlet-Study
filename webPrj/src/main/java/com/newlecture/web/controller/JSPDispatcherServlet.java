package com.newlecture.web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;


import com.newlecture.web.controller.menu.DetailListPOJOController;
import com.newlecture.web.controller.menu.ListPOJOController4;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// 모든 내용이 다 여기로 온다?
@WebServlet("/")
public class JSPDispatcherServlet extends HttpServlet {

	String[] urls = { 
			"/menu/list", 
			"/menu/detail" };
	String[] controllers = { 
			"com.newlecture.web.controller.menu.ListPOJOController4",
			"com.newlecture.web.controller.menu.DetailListPOJOController" };

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		String uri = request.getRequestURI();
//		String url = request.getRequestURL().toString();
//		
//		out.printf("uri:%s\n",uri);
//		out.printf("url:%s\n",url);
		
		String viewSrc = "/WEB-INF/view/notfound.jsp";		
		
//		방법 1 : 내가 반복하는 코드
//		if(uri.equals("/menu/list"))
//			viewSrc = new ListPOJOController4().requestHandler();
//		
//		if(uri.equals("/menu/detail"))			
//			viewSrc = new DetailListPOJOController().requestHandler();
		
		
		Object controller;
		try {
			controller = Class
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
				if(m.getName().equals("requestHandler"))
					method = m;
			}
			
			Object[] args = new Object[2];
			
			Parameter[] params = method.getParameters();
			for(Parameter p : params) {
				System.out.printf("param : %s\n", p.getType().toString());
				System.out.printf("value : %s\n", p.getName());
			}
			
//			request.getParameterMap();
			
			viewSrc = (String) method.invoke(controller, args);
			
			int paramSize = method.getParameterCount();
			
			System.out.println(paramSize);
			
			//method.getParameterCount();
//			Parameter[] params = method.getParameters();
//			for(Parameter p : params) {
//			System.out.printf("param : %s\n", p.getType().toString());
//			}

			
//			Object[] objs = null;
//			if(파라미터가 1개가 있다면)
//			objs = {2,3};
			
//			System.out.printf("result : %d\n", result);
			
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		

//		방법 2 : 컴퓨터가 ㅏ녹하는 코드
//		for(int i=0; i<urls.length; i++) {
//			? controller = null;
//			if(uri.equals(urls[i]))
//				controller = Class.forName(controllers[i]).newInstance();
//				controller.requestHandler();
//		}

		
			
		
		out.write("hello front");
		
		request
		.getRequestDispatcher(viewSrc)
		.forward(request, response);
		
		// /menu/list 요청이 오면 ListController의 requestHandler() 호출
		
		// /menu/detail 요청이 오면 DetailController의 requestHandler() 호출ㄴ
	}
}
