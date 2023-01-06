<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jsp1/logout.jsp</title>
</head>
<body>
<%
//세션값 초기화(연결 종료, 로그아웃)
session.invalidate();
//loginForm.jsp 
response.sendRedirect("loginForm.jsp");
%>
</body>
</html>



