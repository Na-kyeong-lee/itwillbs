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
//String cus_id="cus_id" 세션값 가져오기
String cus_id=(String)session.getAttribute("cus_id");
//CartDAO 객체생성
CartDAO dao =new CartDAO();

CartDTO dto=(CartDTO)request.getAttribute("dto");
%>
<form action="cartInsertPro.jsp" method="get">

No : <input type="text" name="num" readonly><br>
제품명 : <input type="text" name="name" value="<%=dto.getCrt_num() %>" readonly><br>
수량 : <input type="number" name="count"><br>
주문금액 : <input type="number" name="price" value="<%=dto.getCrt_price() %>" >
<input type="submit" value="주문하기">
<input type="button" value="제품목록">
</form>
<a href="order.jsp">결제페이지로 이동</a>
<!-- <form action="product.jsp" method="get"> -->
<!-- 제품명: <input type="" name="제품명"><br> -->
<!-- 수량: <input type="" name="수량"><br> -->
<!-- 주문금액:  -->
</body>
</html>