<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jsp1/request.jsp</title>
</head>
<body>
서버 정보 : <%=request.getServerName() %><br>
서버 포트정보 : <%=request.getServerPort() %><br>
요청 주소 : <%=request.getRequestURL() %><br>
요청 URI : <%=request.getRequestURI() %><br>
클라이언트 IP : <%=request.getRemoteAddr() %><br>
프로토콜 : <%=request.getProtocol() %><br>
요청방식 : <%=request.getMethod() %><br>
컨텍스트(프로젝트) 경로 : <%=request.getContextPath() %><br>
물리적인 경로 : <%=request.getRealPath("/") %><br>
HTTP프로토콜정보(브라우저 정보)
 : <%=request.getHeader("user-agent") %><br>

</body>
</html>

