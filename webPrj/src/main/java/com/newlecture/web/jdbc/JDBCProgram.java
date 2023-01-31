package com.newlecture.web.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCProgram {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		// 접속 루트 흐름 같은 개념
		String url = "jdbc:oracle:thin:@oracle.newlecture.com:1521/xepdb1";
		Connection con = DriverManager.getConnection(url, "NEWLEC", "rland");
		// 커넥션 관련해서 생성하면 무조건 닫는것도 만들기
		
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select * from MEMBER");
		
		rs.next();
		String nicName = rs.getString("nicname");
		System.out.println(nicName);
		
		System.out.println(con.isClosed());
		
		
		con.close();		
		
//		DriverManager
//		Connection
//		Statement
//		Resultset
	}

}
