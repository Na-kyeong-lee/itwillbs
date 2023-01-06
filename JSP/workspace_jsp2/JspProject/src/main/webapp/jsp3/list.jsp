<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jsp3/list.jsp</title>
</head>
<body>
<h1>회원목록</h1>
<%
//세션값 가져오기
String id=(String)session.getAttribute("id");
if(id==null){
	//세션값이 없으면 => loginForm.jsp
	response.sendRedirect("loginForm.jsp");
}else{
	//세션값이 있으면 => admin 아니면 => main.jsp
	if( ! (id.equals("admin")) ){
		response.sendRedirect("main.jsp");
	}
}
//1단계 JDBC 프로그램 가져오기
Class.forName("com.mysql.cj.jdbc.Driver");
//2단계 JDBC 프로그램 이용해서 데이터베이스 연결
String dbUrl="jdbc:mysql://localhost:3306/jspdb2?serverTimezone=Asia/Seoul";
String dbUser="root";
String dbPass="1234";
Connection con=
    DriverManager.getConnection(dbUrl, dbUser, dbPass);
// 3단계 sql구문을 만들고 실행할 준비 select
//String sql="select * from 테이블이름";
String sql="select * from members";
PreparedStatement pstmt=con.prepareStatement(sql);
//4단계 : sql구문 실행 , 실행결과 저장(select)
//ResultSet : sql구문 실행 결과를 저장하는 자바 내장객체
ResultSet rs=pstmt.executeQuery();
//5단계 : while 결과를 출력, 배열저장 (select)
%>
<table border="1">
<tr><td>아이디</td><td>비밀번호</td>
    <td>이름</td><td>가입날짜</td></tr>
    <%
    while(rs.next()){
    	%>
<tr><td><%=rs.getString("id") %></td>
    <td><%=rs.getString("pass") %></td>
    <td><%=rs.getString("name") %></td>
    <td><%=rs.getTimestamp("date") %></td></tr>    	
    	<%
    }
    %>
</table>
</body>
</html>