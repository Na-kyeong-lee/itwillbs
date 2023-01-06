<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jsp1/scopePro.jsp</title>
</head>
<body>
<h1>jsp1/scopePro.jsp</h1>
<%
// 폼에서 get방식으로 데이터 전송
// http://localhost:8080/JspProject/jsp1/
// scopePro.jsp?id=kim&pass=123

// 폼에서 입력한 정보를 서버에 전달
// 서버에 request 내장객체 저장
// request에 저장된 태그(파라미터)정보를 가져와서 => 변수저장
String id=request.getParameter("id");
String pass=request.getParameter("pass");
//pageContext   request(response)  session application
//현페이지 정보를 저장
pageContext.setAttribute("page", "page Value");
//요청정보를 저장
request.setAttribute("req", "request Value");
session.setAttribute("ses", "session Value");
application.setAttribute("app", "application Value");
%>
아이디 : <%=id %><br>
비밀번호 : <%=pass %><br>
pageContext 값 : <%=pageContext.getAttribute("page") %><br>
request 값 : <%=request.getAttribute("req") %><br>
session 값 : <%=session.getAttribute("ses") %><br>
application 값 : <%=application.getAttribute("app") %><br>
<a href="scopePro2.jsp?id=<%=id%>&pass=<%=pass%>">scopePro2.jsp</a><br>
<script type="text/javascript">
// alert("scopePro2.jsp로 이동");
<%-- location.href="scopePro2.jsp?id=<%=id%>&pass=<%=pass%>"; --%>
</script>
<%
// response.sendRedirect("scopePro2.jsp?id="+id+"&pass="+pass);

// <jsp:forward : request에 있는 모든 정보를 들고 이동
//              : 주소가 변경되지 않으면서 이동
// 액션태그 : jsp문법 태그처럼 사용할수 있게 만든 문법 
%>
<jsp:forward page="scopePro2.jsp" />
</body>
</html>





