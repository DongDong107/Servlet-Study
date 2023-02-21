package com.newlecture.web.controller.menu;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.newlecture.web.service.MenuService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//@WebServlet("/menu/list")
public class ListController extends HttpServlet{
	
	private MenuService service;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setCharacterEncoding("UTF-8");
		//브라우저에서 html로 읽고 UTF-8로 읽어라 하고 헤더에 넣어줌.
		resp.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = resp.getWriter();
		out.print("hello");
		
//		Menu[] list = service.getList();
//		int count = service.count();

		String query = "";
		String sql = String.format("select * from member where nicname like '%s'", "%"+query+"%") ;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@oracle.newlecture.com:1521/xepdb1";
			Connection con = DriverManager.getConnection(url, "NEWLEC", "rland");
			
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			out.write("<!DOCTYPE html>");
			out.write("<html>");
			out.write("<head>");
			out.write("<meta charset=\"UTF-8\">");
			out.write("<title>Insert title here</title>");
			out.write("</head>");
			out.write("<body>");
			out.write("<h1>메뉴 목록</h1>");
			out.write("<table>");
			out.write("<tr>");
			out.write("<td>번호</td>");
			out.write("<td>이름</td>");
			out.write("<td>가격</td>");		
			out.write("</tr>");
				
			// 필터링, 집계, 정렬
			while(rs.next())	// 서버의 커서를 한칸 내리고 그 위치의 레코드를 옮겨 오는 것. -> 레코드 하나가 저장되는 공간은?
			{
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String nicName = rs.getString("nicname");
				
//				out.println("<table>");
//				out.println("<tr>");				
				String format = String.format("id:%d, name:%s, nicname:%s\n" , id, name, nicName);
				out.println(format + "<br >");
				System.out.println(format);
//				out.println("</tr>");
//				out.println("</table>");
				
				out.write("<tr>");	
				out.write("	<td>"+id+"</td>");	
				out.write("	<td>"+name+"</td>");	
				out.write("	<td>5000</td>");				
				out.write("</tr>");	
						
					
			}
			
			con.close();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		out.write("</table>");	
		out.write("</body>");	
		out.write("</html>");	
		
	}
}
