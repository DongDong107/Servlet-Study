package com.newlecture.web.service;

import java.util.List;

import com.newlecture.web.entity.Menu;
import com.newlecture.web.repository.MenuDao;
import com.newlecture.web.repository.jdbc.JdbcMenuDao;

// 다양한 업무를 처리하기 위한 상관 관계를 잘 아는 사람이 데이터를 조작하도록 한다.
// 단 데이터를 조작하기 위한 방법은 몰라도 되도록 하는 것이 어떨지...
// 다음과 같은 것들을 모르고도 자바 지식만으로 업무를 처리할 수 있게 하는 것이 좋지 않을까?
// - 어떤 DB를 사용해야 하는지
// - 쿼리를 어떻게 작성해야 하는지.
// -데이터 소스가 다양한데 그것이 어떤 것들을 사용해야 하는지..

// 위와 같이 업무를 나누면 다양한 장점이 있다.
// - 데이터베이스가 달라지면? SQL과 연결 문자열과 드라이브 등이 달라지는데.. 그럼 모든 업무로직 코드를 수정해야 한다.



public class DefaultMenuService implements MenuService {
	
	private MenuDao menuDao;
	
	public DefaultMenuService() {
		menuDao = new JdbcMenuDao();
	}
	
	@Override
	public List<Menu> getList() {
		
		List<Menu> list = menuDao.findAll();
		
		return list;
		
		
	}

}
