<%@page import="java.util.ArrayList"%>
<%@page import="com.itwillbs.cart.db.CartDTO"%>
<%@page import="java.util.List"%>
<%@page import="com.itwillbs.cart.db.CartDAO"%>
<%@page import="java.text.DecimalFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>cart/CartList.jsp</title>
</head>
	<link rel="stylesheet">
<body>
<h1>장바구니</h1>
<%
//세션값 가져오기
String id=(String)session.getAttribute("cus_id");
if(id==null){
	%>
	<script type="text/javascript">
		alert("로그인 후 이용해주세요.");
	</script>
	<%
	//세션값이 없으면 loginForm.jsp로 이동
	response.sendRedirect("loginForm.jsp");
	
} else {
	//세션값이 있으면 CartList.jsp로 이동
	response.sendRedirect("CartList.jsp");		
}

CartDAO dao=new CartDAO();
List<CartDTO> cartList=dao.getCartList(id);



//숫자 천단위 구분
// DecimalFormat dFormat=new DecimalFormat("###,###");
%>
<table width="100">
	<tr>
		<th>No.</th>
		<th>상품정보</th>
		<th>수량</th>
		<th>주문금액</th>
	</tr>
	<%
	for(int i=0; i < cartList.size(); i++) {
		CartDTO dto=cartList.get(i);
		%>
	<tr><td><%=dto.getCrt_num() %></td>
		<td><%=dto.getMenu_id() %></td>
		<td><%=dto.getCrt_count() %></td>
		<td><%=dto.getCrt_price() %></td></tr>
		<%
	}
%>
</table>


</body>
</html>