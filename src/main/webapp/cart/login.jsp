<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
<%
if(session.getAttribute("id")!=null) { 
   response.sendRedirect("setProduct.jsp");
}
%>

<h2>로그인</h2>
<form method="post" action="setProduct.jsp">
	<input type="text" name="id">
	<input type="submit" name="로그인">
</form>

</body>
</html>