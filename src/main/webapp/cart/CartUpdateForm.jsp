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
ArrayList<String> CartList=(ArrayList)session.getAttribute("CartList");
String menu_num=request.getParameter("menu_num");
if(CartList == null) { //장바구니 비어있을 경우
	CartList = new ArrayList<String>();
	CartList.add(menu_num);
	session.setAttribute(menu_num, 1);
}else {
	if(!CartList.contains(menu_num)) { //cartList에 menu_num이 포함되어있지 않으면
		CartList.add(menu_num); //cartList에 menu_num을 추가
		session.setAttribute(menu_num, 1);
	}else {
		int count=(int)session.getAttribute(menu_num);
		session.setAttribute("menuNum" ,menu_num);
// 		session.setAttribute("crtCount" , crt_count);
	}
}

session.setAttribute("CartList", CartList);
%>
<script>
alert("<%=menu_num%>을 장바구니에 담았습니다.");
location.href='Cart.jsp'; 
</script>

</body>
</html>