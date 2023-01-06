<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jsp1/for.jsp</title>
</head>
<body>
<%
// JSP,JAVA 명령
// 배열 = 여행, 게임 운동
String hobby[]={"여행", "게임", "운동"};

%>
배열 주소 : <%=hobby %><br>
배열 크기 : <%=hobby.length %><br>
<%
// hobby[0], hobby[1], hobby[2]
	for(int i=0;i < hobby.length;i++){
		%>
		<%=hobby[i] %>  
		<%
	}
%>
<br>
<%
for(int i=0;i < hobby.length;i++){
// 	System.out.println(hobby[i]);
//  out 출력정보를 저장하는 내장객체
	out.println(hobby[i]+"<br>");
}
%>
<br>
<table border="1">
<tr><td>취미</td></tr>
<%
for(int i=0;i<hobby.length;i++){
	%>
	<tr><td><%=hobby[i] %></td></tr>
	<%
}
%>
</table>
</body>
</html>



