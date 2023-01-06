<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jsp1/testPro1.jsp</title>
</head>
<body>
<%
// java, jsp 명령
String sid=request.getParameter("id");
String n=request.getParameter("num");
//request에 사용자가 입력한 값이 저장=> String 형으로 저장됨
//문자열을 정수형으로 변경
int n2=Integer.parseInt(request.getParameter("num"));
%>
아이디 : <%=sid %><br>
좋아하는 숫자 : <%=n %><br>
좋아하는 숫자 + 100: <%=n+100 %><br>
좋아하는 숫자를 정수형으로 변경 + 100: <%=n2+100 %><br>
</body>
</html>

