<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jsp1/testPro2.jsp</title>
</head>
<body>
<%
//post : form태그에서만 사용가능 - 특수기능 서버에 한글 셋팅 안됨
//get : 기본방식 - 서버에 한글 셋팅
//=> post방식일때 한글처리 필요, request사용하기 전에 설정
request.setCharacterEncoding("utf-8");

String sname=request.getParameter("name");
String sage=request.getParameter("age");
// sage => 문자열을 정수형으로 변경
int age=Integer.parseInt(request.getParameter("age"));
%>
이름 : <%=sname %><br>
나이 : <%=sage %><br>
<%
// 20보다 작으면 "미성년입니다.", 
// 20보다 크거나 같으면 "성인입니다.""
if(age<20){
	%>미성년입니다.<%
}else{
	%>성인입니다.<%
}
%>
</body>
</html>
