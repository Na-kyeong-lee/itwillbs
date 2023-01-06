<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>js2/a.jsp</title>
</head>
<body>
<h1>js2/a.jsp</h1>
<!-- JSP 내장객체 : 
    request 내장객체 => 사용자가 전달한 값을 서버 저장하는 내장객체
    request.변수
    request.함수() 
    reqeust.getParameter("태그이름") 
    : request에 저장된 태그이름에 해당되는 값을 가져오는 함수
http://localhost:8080/JspProject/js2/
a.jsp?tx=kim&pass=1111&ta=11&ra=%EB%82%A8&ch=%EC%97%AC%ED%96%89&se=1    
    -->
아이디 : <%=request.getParameter("tx") %><br> 
비밀번호 : <%=request.getParameter("pass") %><br> 
자기소개 : <%=request.getParameter("ta") %><br> 
성별 : <%=request.getParameter("ra") %><br> 
취미 : <%=request.getParameter("ch") %><br> 
등급 : <%=request.getParameter("se") %><br> 

</body>
</html>




