<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.Timestamp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jsp3/insertPro.jsp</title>
</head>
<body>
<%
// request 한글처리
request.setCharacterEncoding("utf-8");
// 폼에 입력한 데이터 -> 서버 request 저장
// id pass name 변수 파라미터값 가져와서 저장
String id=request.getParameter("id"); //getParameter로 값을 가져옴
String pass=request.getParameter("pass");
String name=request.getParameter("name");
// 웹서버의 날짜시간 가져오기
Timestamp date=new Timestamp(System.currentTimeMillis());

//1단계 JDBC 프로그램 가져오기
Class.forName("com.mysql.cj.jdbc.Driver");
//2단계 JDBC 프로그램 이용해서 데이터베이스 연결
String dbUrl="jdbc:mysql://localhost:3306/jspdb2?serverTimezone=Asia/Seoul";
String dbUser="root";
String dbPass="1234";
Connection con=
    DriverManager.getConnection(dbUrl, dbUser, dbPass);

// 3단계 sql구문을 만들고 실행할 준비 insert
String sql="insert into members(id,pass,name,date) values(?,?,?,?)";
PreparedStatement pstmt =con.prepareStatement(sql);
// ? 표 값을 넣어서 sql구문 완성
pstmt.setString(1, id);
pstmt.setString(2, pass);
pstmt.setString(3, name);
pstmt.setTimestamp(4, date);

// 4단계 : sql구문 실행 (insert)
pstmt.executeUpdate(); //Query는 값을 사용하려고 가져오는거/update는 수정만
//select만 executequery를 씀

//로그인 페이지로 이동
response.sendRedirect("loginForm.jsp");
%>
회원가입 성공 <%=pstmt %>
</body>
</html>







