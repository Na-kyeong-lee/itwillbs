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
<title>jsp3/deletePro.jsp</title>
</head>
<body>
<%
//폼에서 입력한 파라미터값(id,pass)을 서버에 request에 저장
//변수 = request에 저장된 값 가져오기
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
//   3단계 sql delete, 4단계 실행, 세션초기화, main.jsp 이동
//else        데이터 없으면 => false => "아이디 비밀번호 틀림"
//       "입력하신 정보 틀림", 뒤로이동
if(rs.next()){
//다음행이동=> 데이터 있으면 => true =>"아이디 비밀번호 일치"	
// 	3단계 sql delete, 4단계 실행, 세션초기화, main.jsp 이동
sql="delete from members where id=?";
pstmt=con.prepareStatement(sql);
pstmt.setString(1, id);
// 4단계 실행
pstmt.executeUpdate();
// 세션초기화
session.invalidate();
// main.jsp 이동
response.sendRedirect("main.jsp");
}else{
//데이터 없으면 => false => "아이디 비밀번호 틀림"	
// 	"입력하신 정보 틀림", 뒤로이동
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