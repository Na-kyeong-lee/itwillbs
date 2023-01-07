package com.itwillbs.cart.action;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwillbs.member.db.MemberDAO;

public class CartInsertPro implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// request 한글처리
		request.setCharacterEncoding("utf-8");
		
		String cus_id = request.getParameter("cus_id");
		
		//1단계 JDBC 프로그램 가져오기
		Class.forName("com.mysql.cj.jdbc.Driver");

		//2단계 JDBC 프로그램 이용해서 DB연결
		String dbUrl = "jdbc:mysql://localhost:3306/jspdb2?serverTimezone=Asia/Seoul";
		String dbUser = "root";
		String dbPass = "1234";
		Connection con = DriverManager.getConnection(dbUrl,dbUser,dbPass);

		//3단계 SQL구문 만들고 실행할 준비 select
		// String sql = "select * from 테이블이름 where id=? and pass=?";
		String sql = "select * from members where cus_id=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, cus_id);
		
		ResultSet rs=pstmt.executeQuery();
		
		MemberDAO dao = new MemberDAO();
		
		
		
		return null;
	}

	
}
