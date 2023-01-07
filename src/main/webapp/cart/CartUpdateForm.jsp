<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>cart/cartUpdateForm.jsp</title>
</head>
<body>
<h1>장바구니 수정</h1>
<%
ArrayList<String> productlist=(ArrayList)session.getAttribute("productlist");
String productname=request.getParameter("product");
if(productlist == null) {
	productlist = new ArrayList<String>();
	productlist.add(productname);
	session.setAttribute(productname, 1);
}else {
	if(!productlist.contains(productname)) {
		productlist.add(productname);
		session.setAttribute(productname, 1);
	}else {
		int count=(int)session.getAttribute(productname);
		session.setAttribute(productname, count+1);
	}
}

session.setAttribute("productlist", productlist);
%>
<script>
alert("<%=productname%>을 장바구니에 담았습니다.");
location.href='setProduct.jsp';
</script>

</body>
</html>