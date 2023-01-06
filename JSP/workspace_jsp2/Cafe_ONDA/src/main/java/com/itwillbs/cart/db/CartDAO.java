package com.itwillbs.cart.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class CartDAO {

	public Connection getConnection() throws Exception {
		// 예외처리를 함수 호출하는 곳으로 전달
		
		//1단계 JDBC 프로그램 가져오기
		Class.forName("com.mysql.cj.jdbc.Driver ");
		//2단계 JDBC 프로그램 이용해서 데이터베이스 연결
		String dbUrl="jdbc:mysql://localhost:3306/jspdb2?serverTimezone=Asia/Seoul";
		String dbUser="root";
		String dbPass="1234";
		Connection con=
		    DriverManager.getConnection(dbUrl, dbUser, dbPass);
		return con;
	}
}
