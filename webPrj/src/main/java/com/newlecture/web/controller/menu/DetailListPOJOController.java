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

// /menu/detail
public class DetailListPOJOController {
	
	private MenuService service;
	
	public DetailListPOJOController() {
		service = new DefaultMenuService();
	}
	

	
	public String requestHandler() {
		
		return "/WEB-INF/view/menu/detail.jsp";
	}
		
		
}
