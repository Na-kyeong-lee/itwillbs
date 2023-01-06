<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jsp3/updateForm.jsp</title>
</head>
<body>
<h1>나의 정보 수정</h1>
<%
//String id = "id" 세션값 가져오기
String id=(String)session.getAttribute("id");
//1단계 JDBC 프로그램 가져오기
Class.forName("com.mysql.cj.jdbc.Driver");
//2단계 JDBC 프로그램 이용해서 데이터베이스 연결
String dbUrl="jdbc:mysql://localhost:3306/jspdb2?serverTimezone=Asia/Seoul";
String dbUser="root";
String dbPass="1234";
Connection con=
    DriverManager.getConnection(dbUrl, dbUser, dbPass);
// 3단계 sql구문을 만들고 실행할 준비 select
//String sql="select * from 테이블이름 where id=?";
String sql="select * from members where id=?";
PreparedStatement pstmt=con.prepareStatement(sql);
pstmt.setString(1, id);
//4단계 : sql구문 실행 , 실행결과 저장(select)
//ResultSet : sql구문 실행 결과를 저장하는 자바 내장객체
ResultSet rs=pstmt.executeQuery();
//5단계 : 결과를 출력, 배열저장 (select)
//if 다음행이동=> 데이터 있으면 => true =>"아이디 일치"
//   id, pass, name, date 열 접근해서 출력
if(rs.next()){
	%>
<form action="updatePro.jsp" method="get">
아이디 : <input type="text" name="id" value="<%=rs.getString("id") %>" readonly><br>
비밀번호 : <input type="password" name="pass"><br>
이름 : <input type="text" name="name" value="<%=rs.getString("name")%>"><br>
<input type="submit" value="회원정보수정">
</form>	
	<%
}
%>
<a href="main.jsp">main.jsp 이동</a>
</body>
</html>