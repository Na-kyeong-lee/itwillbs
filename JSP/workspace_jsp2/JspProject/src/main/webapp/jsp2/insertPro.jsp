<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jsp2/insertPro.jsp</title>
</head>
<body>
<%
//request 한글처리
request.setCharacterEncoding("utf-8");

//폼에서 가져온 데이터 서버 request 내장객체 저장
// 학생번호 문자열 -> 정수형 변경
int num=Integer.parseInt(request.getParameter("num"));
String name=request.getParameter("name");

// 1단계 JDBC 프로그램 가져오기
Class.forName("com.mysql.cj.jdbc.Driver");
// 2단계 JDBC 프로그램 이용해서 데이터베이스 연결
String dbUrl="jdbc:mysql://localhost:3306/jspdb2?serverTimezone=UTC";
String dbUser="root";
String dbPass="1234";
Connection con=
    DriverManager.getConnection(dbUrl, dbUser, dbPass);
// 3단계 sql구문을 만들고 실행할 준비
// 디비연결 정보를 이용해서 sql구문을 만들고 실행할 준비
//=> 자바내장객체 PreparedStatement  저장
// String sql="insert into 테이블이름(열이름) values(값)";
// String sql="insert into student(num,name) values("+num+",'"+name+"')";
String sql="insert into student(num,name) values(?,?)";
PreparedStatement pstmt =con.prepareStatement(sql);
// ? 표 값을 넣어서 sql구문 완성
pstmt.setInt(1, num);
pstmt.setString(2, name);

// 4단계 : sql구문 실행 (insert)
pstmt.executeUpdate();
%>
학생등록 성공 <%=pstmt %>
</body>
</html>



