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
<%
	request.setCharacterEncoding("UTF-8");

	session.setAttribute("id", request.getParameter("id"));
	
	// id세션값 가져오기
	String id=(String)session.getAttribute("id");
	
	if(id==null){
		%>
		<script type="text/javascript">
			alert("로그인 후 이용해주세요.");
		</script>
		<%
		//세션값이 없으면 loginForm.jsp로 이동
		response.sendRedirect("loginForm.jsp");
		
	} else {
		//세션값이 있으면 menu.jsp로 이동
		response.sendRedirect("menu.jsp");		
	}
	
%>
</head>
<body>
<h1>상품선택</h1>
<hr>
<%=session.getAttribute("id") %> 님의 장바구니 입니다:) <br>
<hr>

<div>
<form action="add.jsp" name="cartInsertForm" method="POST">
	<select name="product">
		<option>아메리카노</option>
		<option>카페라떼</option>
		<option>바닐라라떼</option>
		<option>카라멜마끼아또</option>
		<option>연유라떼</option>
	</select>
	<input type="submit" value="추가">
</form>
<a href="CartList.jsp">장바구니 조회</a><br>
</div>



</body>
</html>