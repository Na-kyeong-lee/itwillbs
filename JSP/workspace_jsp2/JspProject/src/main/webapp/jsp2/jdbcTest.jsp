<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jsp2/jdbcTest.jsp</title>
</head>
<body>
<%
// JDBC 프로그램 설치
// 1단계 : JDBC 프로그램 가져오기
Class.forName("com.mysql.cj.jdbc.Driver");
// 2단계 : JDBC 프로그램 이용해서 데이터베이스 연결
// DriverManager 자바내장객체 : JDBC프로그램 이용해서 디비연결
String dbUrl="jdbc:mysql://localhost:3306/jspdb2?serverTimezone=UTC";
String dbUser="root";
String dbPass="1234";
// Connection 자바내장객 : 연결정보를 저장하는 내장객체
Connection con=
    DriverManager.getConnection(dbUrl, dbUser, dbPass);
%>
연결 성공 <%=con %>
</body>
</html>





