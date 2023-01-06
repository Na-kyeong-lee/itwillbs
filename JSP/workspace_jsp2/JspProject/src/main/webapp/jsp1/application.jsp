<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jsp1/application.jsp</title>
</head>
<body>
<%
//자바 파일 ServletContext => jsp내장객체 application
//application 내장객체 : 서버정보를 저장하는 내장객체
// 서버가 start되어지면 만들어짐, 
// 서버가 stop되면 사라짐
// 서버에 1개만 존재
%>
서버정보 : <%=application.getServerInfo() %><br>
서버물리적 경로 : <%=application.getRealPath("/") %><br>
<%
// 자바파일 PageContext => jsp 내장객체 pageContext
// 현페이지 정보를 저장 
// 페이지가 변경되면 기존정보를 사라지고 새로운 페이지 정보 저장

// 자바파일 JspWriter => jsp 내장객체 out
// 출력정보를 저장하는 내장객체
out.println("출력내장객체");
%>
출력 정보를 저장하는 기억장소 크기 : <%=out.getBufferSize() %><br>
출력 하고 남은 기억장소 크기 : <%=out.getRemaining() %><br>
<%
//출력 끝
out.close();
out.println("출력 끝나고 출력하면 에러남");
%>
</body>
</html>

