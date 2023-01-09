<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>cart/selProduct.jsp</title>
<%
	request.setCharacterEncoding("UTF-8");

	session.setAttribute("username", request.getParameter("username"));
%>
</head>
<body>
<h2>상품선택</h2>
<hr>
<%=session.getAttribute("username") %> 님 어서오세요!<br>
<hr>
<div>
<form action="add.jsp" name="selProduct" method="POST">
	<select name="product">
		<option>아메리카노</option>
		<option>카페라떼</option>
		<option>바닐라라떼</option>
		<option>카라멜마끼아또</option>
		<option>연유라떼</option>
	</select>
	<input type="submit" value="추가">
</form>
<a href="checkOut.jsp">장바구니 보기</a><br>
</div>

</body>
</html>