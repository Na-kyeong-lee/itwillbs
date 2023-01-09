<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>cart/add.jsp</title>
</head>
<body>
<%
	request.setCharacterEncoding("UTF-8");
	String productName=request.getParameter("product");
	
	ArrayList<String> list=(ArrayList<String>) session.getAttribute("productList");
	if(list==null) {
		list=new ArrayList<String>();
		session.setAttribute("productList", list);
	}
	
	list.add(productName);
%>
<script>
	alert("<%=productName %> 이(가) 추가되었습니다.");
	history.back();
</script>

</body>
</html>