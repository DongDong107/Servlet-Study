package com.newlecture.web.controller.menu;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import com.newlecture.web.entity.Menu;
import com.newlecture.web.service.DefaultMenuService;
import com.newlecture.web.service.MenuService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// /menu/list
public class ListPOJOController4 {
	
	private int x = 1;
	private int y = 3;
	private MenuService service;
	
	public ListPOJOController4() {
		service = new DefaultMenuService();
	}
	
	public String requestHandler(String id, String query) {
		
		return "/WEB-INF/view/menu/list.jsp";
	}
	
	public int add(int x) {
		return 20+x;
	}
		
}
