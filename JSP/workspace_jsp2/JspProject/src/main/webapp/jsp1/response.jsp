<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jsp1/response.jsp</title>
</head>
<body>
<%
// HttpServletResponse자바파일
// response내장객체 : 서버에서 처리한 결과를 저장하는 내장객체
//                : 웹서버에 전달=> http전달=> 사용자 전달
response.setHeader("user-agent", "변경값");
response.setContentType("text/html; charset=UTF-8");
// response.addCookie("쿠키값");

// 하이퍼링크 <a href="이동주소"></a>
// 자바스크립트 location.href="이동주소"
// jsp에서 response.sendRedirect("이동할 주소");
response.sendRedirect("request.jsp");
%>
</body>
</html>

