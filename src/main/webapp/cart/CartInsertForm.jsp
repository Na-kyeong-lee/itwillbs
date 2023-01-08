<%@page import="com.itwillbs.cart.db.CartDTO"%>
<%@page import="com.itwillbs.cart.db.CartDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<!-- <style> -->
<!-- /* /*   div { */ */ -->
<!-- /* /*     float:left; */ */ -->
<!-- /* /*   } */ */ -->
<!-- </style> -->
<head>
<meta charset="UTF-8">
<title>cart/cartForm.jsp</title>
</head>
<body>
<h1>장바구니</h1>
<%
String cus_id=(String)session.getAttribute("cus_id");

CartDAO dao =new CartDAO();

CartDTO dto=(CartDTO)request.getAttribute("dto");
%>
<form action="./CartInsertPro.ca" method="get">
No : <input type="number" name="num" >
제품명 : <input type="text" name="menu"  >
수량 : <input type="number" name="count" >
주문금액 : <input type="text" name="price" >
<input type="submit" value="주문하기">
<input type="submit" value="제품목록">
</form>

</body>
</html>