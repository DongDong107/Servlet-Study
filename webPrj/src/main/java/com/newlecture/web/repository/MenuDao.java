package com.newlecture.web.repository;

import java.util.List;

import com.newlecture.web.entity.Menu;

public interface MenuDao {
	
	List<Menu> findAll();
	
}
