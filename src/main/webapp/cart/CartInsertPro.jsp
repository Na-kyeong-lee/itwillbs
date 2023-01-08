<%@page import="com.itwillbs.cart.db.CartDAO"%>
<%@page import="com.itwillbs.cart.db.CartDTO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>cart/CartInsertPro.jsp</title>
</head>
<body>
<%
request.setCharacterEncoding("utf-8");
//폼에 입력한 데이터 서버 request에 저장
//변수 파라미터값 가져와서 저장
int crt_num=Integer.parseInt(request.getParameter("crt_num"));
int menu_id=Integer.parseInt(request.getParameter("menu_id"));
int crt_price=Integer.parseInt(request.getParameter("crt_price"));
int crt_count=Integer.parseInt(request.getParameter("crt_count"));


CartDAO dao=new CartDAO();
System.out.println("CartDAO 주소: " + dao);

CartDTO dto=new CartDTO();
System.out.println("CartDTO 주소: " + dto);

dto.setCrt_num(crt_num);
dto.setMenu_id(menu_id);
dto.setCrt_price(crt_price);
dto.setCrt_count(crt_count);

dao.insertCart(dto);


// 장바구니 목록페이지로 이동
response.sendRedirect("CartList.jsp");
%>

</body>
</html>