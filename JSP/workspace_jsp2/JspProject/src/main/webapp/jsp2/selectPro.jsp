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
<title>jsp2/selectPro.jsp</title>
</head>
<body>
<%
// 폼에서 입력한 학생번호를 가져와서 서버 request에 저장
// request 학생번호 num을 값을 와서 변수 int num 저장
int num=Integer.parseInt(request.getParameter("num"));
//1단계 JDBC 프로그램 가져오기
Class.forName("com.mysql.cj.jdbc.Driver");
//2단계 JDBC 프로그램 이용해서 데이터베이스 연결
String dbUrl="jdbc:mysql://localhost:3306/jspdb2?serverTimezone=UTC";
String dbUser="root";
String dbPass="1234";
Connection con=
    DriverManager.getConnection(dbUrl, dbUser, dbPass);
// 3단계 sql구문을 만들고 실행할 준비 select
// String sql="select * from 테이블이름 where num=?";
String sql="select * from student where num=?";
PreparedStatement pstmt=con.prepareStatement(sql);
pstmt.setInt(1, num);
//4단계 : sql구문 실행 , 실행결과 저장(select)
//ResultSet : sql구문 실행 결과를 저장하는 자바 내장객체
ResultSet rs=pstmt.executeQuery();
//5단계 : 결과를 출력, 배열저장 (select)
%>
<table border="1">
<tr><td>학생번호</td><td>학생이름</td></tr>
<%
if(rs.next()){
	%>
<tr><td><%=rs.getInt("num") %></td>
    <td><%=rs.getString("name") %></td></tr>	
	<%
}
%>
</table>
</body>
</html>




