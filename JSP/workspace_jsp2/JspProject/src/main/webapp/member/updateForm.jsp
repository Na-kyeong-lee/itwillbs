<%@page import="com.itwillbs.member.db.MemberDTO"%>
<%@page import="com.itwillbs.member.db.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>member/updateForm.jsp</title>
</head>
<body>
<h1>나의 정보 수정</h1>
<%
//String id = "id" 세션값 가져오기
String id=(String)session.getAttribute("id");
//MemberDAO 객체생성
MemberDAO dao=new MemberDAO();
// MemberDTO dto =디비작업주소.getMember(id) 메서드 호출
MemberDTO dto=dao.getMember(id);
	%>
<form action="updatePro.jsp" method="get">
아이디 : <input type="text" name="id" value="<%=dto.getId() %>" readonly><br>
비밀번호 : <input type="password" name="pass"><br>
이름 : <input type="text" name="name" value="<%=dto.getName()%>"><br>
<input type="submit" value="회원정보수정">
</form>	
<a href="main.jsp">main.jsp 이동</a>
</body>
</html>