<%@page import="com.itwillbs.member.db.MemberDTO"%>
<%@page import="com.itwillbs.member.db.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>cart/cartPro.jsp</title>
</head>
<body>
<%
//request 한글처리
request.setCharacterEncoding("UTF-8");

String id=request.getParameter("id");
String pass=request.getParameter("pass");

MemberDAO dao=new MemberDAO();

MemberDTO dto=new MemberDTO();
dto.setCus_id(id);

//dto null이 아니면 => "아이디 비밀번호 일치" => 장바구니 접근가능
//	  null이면	  => "아이디 비밀번호 틀림" => 로그인 페이지로 이동
if(dto!=null) {
	// id 데이터가 있으면
	session.setAttribute("id", id);
	// 장바구니 페이지로 이동
	response.sendRedirect("cartForm.jsp");
} else {
	// id 데이터가 없으면
	%>
	<script type="text/javascript">
		alert("로그인 후 이용해주세요.");
	</script>
	<%
	response.sendRedirect("loginForm.jsp");
}
%>

</body>
</html>