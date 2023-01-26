package com.newlecture.web;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/hi")
public class HelloServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//보낼때 UTF-8로 설정
		response.setCharacterEncoding("UTF-8");
		//브라우저에서 html로 읽고 UTF-8로 읽어라 하고 헤더에 넣어줌.
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		//클라이언트에서 입력받은 값이 서버에 갈때도 UTF-8로 갈수 있도록.
		request.setCharacterEncoding("UTF-8");
		
		// url에 cnt 값이 없어도 돌아갈수있게
		String temp = request.getParameter("cnt");
		int cnt = 2;		
		if(temp != null && !temp.equals(""))
			cnt = Integer.parseInt(temp);
		
		//url을 통해 오는 인자값을 받을 수 있게 정하는 것.
//		int cnt = Integer.parseInt(request.getParameter("cnt"));
		
		for (int i = 0; i < cnt; i++) {
			out.println((i+1)+":안녕 Servlet!!<br >");
		}

	}
}
