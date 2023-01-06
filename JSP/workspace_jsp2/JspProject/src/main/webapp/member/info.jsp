<%@page import="com.itwillbs.member.db.MemberDTO"%>
<%@page import="com.itwillbs.member.db.MemberDAO"%>
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
<title>member/info.jsp</title>
</head>
<body>
<h1>나의 정보 조회</h1>
<%
//String id = "id" 세션값 가져오기
String id=(String)session.getAttribute("id");
//MemberDAO 객체생성
MemberDAO dao=new MemberDAO();
// 리턴할형MemberDTO getMember(String id)
// 메서드 정의
// MemberDTO dto =디비작업주소.getMember(id) 메서드 호출
MemberDTO dto=dao.getMember(id);
	%>
아이디 : <%=dto.getId() %><br>
비밀번호 : <%=dto.getPass() %><br>
이름 : <%=dto.getName() %><br>
가입날짜 : <%=dto.getDate() %><br>
<a href="main.jsp">main.jsp 이동</a>
</body>
</html>



