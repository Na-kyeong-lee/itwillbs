<%@page import="java.text.DecimalFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>cart/cart.jsp</title>
	<h1>장바구니</h1>
	<link rel="stylesheet">

	<%
	//세션값 가져오기
	String cartId=session.getId();
	//숫자 천단위 구분
	DecimalFormat dFormat=new DecimalFormat("###,###");
	%>
</head>
<body>
	<jsp:include page="menuList_drink.jsp">
	<table width=100%>
		<tr>
			<th>No.</th>
			<th>상품정보</th>
			<th>수량</th>
			<th>주문금액</th>
		</tr>
	</table>
	
	
	
	</jsp:include>

</body>
</html>