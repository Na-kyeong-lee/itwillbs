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
<title>jsp3/loginPro.jsp</title>
</head>
<body>
<%
// 폼에서 입력한 id, pass => 서버 request에 저장 
// request에 저장된 id,pass 파라미터 => 변수에 저장
String id=request.getParameter("id");
String pass=request.getParameter("pass");
//1단계 JDBC 프로그램 가져오기
Class.forName("com.mysql.cj.jdbc.Driver");
//2단계 JDBC 프로그램 이용해서 데이터베이스 연결
String dbUrl="jdbc:mysql://localhost:3306/jspdb2?serverTimezone=Asia/Seoul";
String dbUser="root";
String dbPass="1234";
Connection con=
    DriverManager.getConnection(dbUrl, dbUser, dbPass);
// 3단계 sql구문을 만들고 실행할 준비 select
//String sql="select * from 테이블이름 where id=? and pass=?";
String sql="select * from members where id=? and pass=?";
PreparedStatement pstmt=con.prepareStatement(sql);
pstmt.setString(1, id);
pstmt.setString(2, pass);
//4단계 : sql구문 실행 , 실행결과 저장(select)
//ResultSet : sql구문 실행 결과를 저장하는 자바 내장객체
ResultSet rs=pstmt.executeQuery();
//5단계 : 결과를 출력, 배열저장 (select)
//if 다음행이동=> 데이터 있으면 => true =>"아이디 비밀번호 일치"
//else        데이터 없으면 => false => "아이디 비밀번호 틀림"
if(rs.next()){
	//데이터 있으면 => true =>"아이디 비밀번호 일치"
	out.println("아이디 비밀번호 일치");
	// 페이지 상관없이 값이 유지 => 세션값 부여(저장)
	session.setAttribute("id", id);
	// main.jsp 이동
	response.sendRedirect("main.jsp");
}else{
	//데이터 없으면 => false => "아이디 비밀번호 틀림"
	out.println("아이디 비밀번호 틀림");
	// "입력하신 정보 틀림", 뒤로이동
	%>
	<script type="text/javascript">
		alert("입력하신 정보 틀림");
		history.back();
	</script>
	<%
}
%>
</body>
</html>



