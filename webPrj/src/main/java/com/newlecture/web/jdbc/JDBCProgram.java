package com.newlecture.web.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class JDBCProgram {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
		System.out.println("             [회원 검색 프로그램]");
		Scanner sc = new Scanner(System.in);
		System.out.print("회원 이름 입력:");
		String name = sc.nextLine(); 
		System.out.println("ID         "+"이름                  "+"별명          ");
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		// 접속 루트 흐름 같은 개념
		String url = "jdbc:oracle:thin:@oracle.newlecture.com:1521/xepdb1";
		Connection con = DriverManager.getConnection(url, "NEWLEC", "rland");
		// 커넥션 관련해서 생성하면 무조건 닫는것도 만들기
		
		Statement st = con.createStatement();
//		ResultSet rs = st.executeQuery("select * from MEMBER where id >= 100");
//		ResultSet rs = st.executeQuery("SELECT ID,NAME,NICNAME FROM MEMBER WHERE NAME = '"+ name +"'");
		ResultSet rs = st.executeQuery("SELECT ID,NAME,NICNAME FROM MEMBER WHERE NAME LIKE '%"+ name +"%'");
		
		//"SELECT ID,NAME,NICNAME FROM MEMBER WHERE NAME = '"+ name +"'";
		while(rs.next()) {
			int id = rs.getInt("id");
			String dbname = rs.getString("name");
			String nicName = rs.getString("nicname");
			String printrs =  String.format("%d         "+"%s                  "+"%s          ",id,dbname,nicName);
			System.out.println(printrs);
		}
		
		
		
		//rs.next() 불린 값이였다!!
				
//		// 필터링, 집계, 정렬
//		while(rs.next()) {			
//			int id = rs.getInt("id");
//			if(id<100) {
//				continue;
//			}
//			String nicName = rs.getString("nicname");
//			
//			System.out.println(id);
//			System.out.println(nicName);
//		}
		
		
		
		
//		rs.next();
//		String nicName = rs.getString("nicname");
//		System.out.println(nicName);
		
//		System.out.println(con.isClosed());
		
		sc.close();
		con.close();		
		
//		DriverManager
//		Connection
//		Statement
//		Resultset
	}

}
