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
//���� �Է��� ������ ���� request�� ����
//���� �Ķ���Ͱ� �����ͼ� ����
int crt_num=Integer.parseInt(request.getParameter("crt_num"));
int menu_id=Integer.parseInt(request.getParameter("menu_id"));
int crt_price=Integer.parseInt(request.getParameter("crt_price"));
int crt_count=Integer.parseInt(request.getParameter("crt_count"));


CartDAO dao=new CartDAO();
System.out.println("CartDAO �ּ�: " + dao);

CartDTO dto=new CartDTO();
System.out.println("CartDTO �ּ�: " + dto);

dto.setCrt_num(crt_num);
dto.setMenu_id(menu_id);
dto.setCrt_price(crt_price);
dto.setCrt_count(crt_count);

dao.insertCart(dto);


// ��ٱ��� ����������� �̵�
response.sendRedirect("CartList.jsp");
%>

</body>
</html>