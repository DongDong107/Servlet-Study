package com.newlecture.web.controller.menu;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.newlecture.web.entity.GList;
import com.newlecture.web.entity.Menu;
import com.newlecture.web.service.DefaultMenuService;
import com.newlecture.web.service.MenuService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/menu/list3") // 404 ( 존재하지 않는 url)
public class ListController3 extends HttpServlet{
	
	private MenuService service;
	
	public ListController3() {
		service = new DefaultMenuService();
	}
	
	// 404까지 포함해서 오류들 외우기.
	// 인증이 안되었거나 권한이 없어서 이 용청에 대한응답을 처리할 수 없는 경우
	// 우리는 어떤 상태 코드를 전달해야 할까? 사용자에게 : 403
	// 400 에러는 뭘 뜻하는 걸 까요? 인자가 일치하지 않는 에러.
	// post 요청에 응답할 수 있는 메소드 처리 함수가 없을 경우의 오류 상태 코드는? 405
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		
		req.getParameter("c");
		
		PrintWriter out = resp.getWriter();
		
		List<Menu> menus = service.getList(); 		
		

		req.setAttribute("menus", menus);
		
		req
		.getRequestDispatcher("/WEB-INF/view/menu/list.jsp")
		.forward(req, resp);

		
	}
}
