<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jsp1/scopePro2.jsp</title>
</head>
<body>
<h1>jsp1/scopePro2.jsp</h1>
<%
// request에 저장된 태그(파라미터)정보를 가져와서 => 변수저장
String id=request.getParameter("id");
String pass=request.getParameter("pass");
%>
아이디 : <%=id %><br>
비밀번호 : <%=pass %><br>
pageContext 값 : <%=pageContext.getAttribute("page") %><br>
request 값 : <%=request.getAttribute("req") %><br>
session 값 : <%=session.getAttribute("ses") %><br>
application 값 : <%=application.getAttribute("app") %><br>
</body>
</html>
