<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jsp2/updatePro.jsp</title>
</head>
<body>
<%
//request 한글처리
request.setCharacterEncoding("utf-8");
//폼에서 입력한 데이터를 서버에 request내장객체 저장
int num=Integer.parseInt(request.getParameter("num"));
String name=request.getParameter("name");
//1단계 JDBC 프로그램 가져오기
Class.forName("com.mysql.cj.jdbc.Driver");
// 2단계 JDBC 프로그램 이용해서 데이터베이스 연결
String dbUrl="jdbc:mysql://localhost:3306/jspdb2?serverTimezone=UTC";
String dbUser="root";
String dbPass="1234";
Connection con=
    DriverManager.getConnection(dbUrl, dbUser, dbPass);
// 3단계 sql구문을 만들고 실행할 준비 update
// String sql="update 테이블이름 set 수정할열=값 where 조건열=값";
String sql="update student set name=? where num=?";
PreparedStatement pstmt=con.prepareStatement(sql);
pstmt.setString(1, name);
pstmt.setInt(2, num);
// 4단계 : sql구문 실행 (update)
pstmt.executeUpdate();
%>
학생정보수정 성공 <%=pstmt %>
</body>
</html>


