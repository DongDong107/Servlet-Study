package com.newlecture.web.api.menu;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.newlecture.web.entity.Menu;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/admin/menus")
public class ListServlet extends HttpServlet{
	
	static List<Menu> list;
	
	static {
		list = new ArrayList<Menu>();
		//list = new ArratList<Menu>();
		
		list.add(new Menu(1, "아메리카노",4000,""));
		list.add(new Menu(2, "아이스 아메리카노",4500,""));
		list.add(new Menu(3, "카페라떼",5000,""));
		list.add(new Menu(4, "아이스 카페라떼",5500,""));
		list.add(new Menu(5, "카페모카",5000,""));
		list.add(new Menu(5, "아이스 카페모카",5500,""));
	}
	
	public ListServlet() {
		
	}
	
	
	// get / post / put / delete
	// 메뉴 목록 줘 : get요청 /admin/menus?q=new&p=1&s=15     //1번 에서 15까지?  ㅗㅅ세://localhost:80
	// 1번 메뉴 줘 : get요청 /admin/menus/1             경로명
	// 나 3번 메뉴 지워줘 : delete 요청     /admin/menus/3     단 요청이 del요청
						// 과거 서버사이드랜더링 때는 get과 post만 가능했어서 (API가 아니라 페이지 달라고 했을 때)
						// '/admin/menus/3/del' 이렇게 했다.
	// 나 메뉴 하나 생성해줘 : post 요청      /admin/menus
	// 나 3번 메뉴 내용 수정해줘 : put 요청:    /admin/menus/3  
	                     // 과거put: /admin/menus/3/edit
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 리플렉션
		// 어노테이션
		String json = "{";
		//son += "(\"id\":";"
		for(Menu m : list)
			json += ?;
		
		
		return json;
	}
	
}
