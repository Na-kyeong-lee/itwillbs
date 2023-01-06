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
<title>jsp2/select.jsp</title>
</head>
<body>
<h1>학생 전체 목록</h1>
<%
//1단계 JDBC 프로그램 가져오기
Class.forName("com.mysql.cj.jdbc.Driver");
//2단계 JDBC 프로그램 이용해서 데이터베이스 연결
String dbUrl="jdbc:mysql://localhost:3306/jspdb2?serverTimezone=UTC";
String dbUser="root";
String dbPass="1234";
Connection con=
    DriverManager.getConnection(dbUrl, dbUser, dbPass);
// 3단계 sql구문을 만들고 실행할 준비 select
// String sql="select * from 테이블이름";
String sql="select * from student";
PreparedStatement pstmt=con.prepareStatement(sql);

//4단계 : sql구문 실행 , 실행결과 저장(select)
// ResultSet : sql구문 실행 결과를 저장하는 자바 내장객체
ResultSet rs=pstmt.executeQuery();
//5단계 : 결과를 출력, 배열저장 (select)
//저장 위치 이동 
//next() 다음행으로 이동 => 결과 데이터 있으면 true/없으면false
//previous() 이전행으로 이동, first() 첫행이동,
//last()마지막 이동
// out.println(rs.next()); //true
// out.println(rs.next()); //true
// out.println(rs.next()); //true
// out.println(rs.next()); //false

// while(rs.next()){
// 	//다음행으로 오면 데이터 있으면 true
// 	out.println(rs.getInt("num"));// 1열(num열이름) 접근
// 	out.println(rs.getString("name"));// 2열(name열이름) 접근
// 	out.println("<br>");
// }

//다음행으로 오면  데이터 없으면 false 반복문 빠져나옴
// out.println("반복문 빠져나옴");

%>
<table border="1">
<tr><td>학생번호</td><td>학생이름</td></tr>
<%
while(rs.next()){
	%>
<tr><td><%=rs.getInt("num") %></td>
    <td><%=rs.getString("name") %></td></tr>	
	<%
}
%>
</table>
</body>
</html>

