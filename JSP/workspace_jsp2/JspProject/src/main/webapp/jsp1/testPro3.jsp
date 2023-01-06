<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jsp1/testPro3.jsp</title>
</head>
<body>
<%
//post 방식 => 한글처리
request.setCharacterEncoding("utf-8");
// request저장된 태그값을 가져오기
// getParameter() 이름하나에 값하나 전달
String id=request.getParameter("id");
String pass=request.getParameter("pass");
String intro=request.getParameter("intro");
String gender=request.getParameter("gender");
// getParameterValues() 이름하나에 값이 여러개 전달
// 여러개를 저장하는 변수 => 배열변수
String hobby[]=request.getParameterValues("hobby");
//배열개수  hobby.length
String grade=request.getParameter("grade");


%>
아이디 : <%=id %><br>
비밀번호 : <%=pass %><br>
자기소개 : <%=intro %><br>
성별 : <%=gender %><br>
취미 : <%=hobby %><br>
<%-- 취미 선택한 개수(배열크기) : <%=hobby.length %><br> --%>
<%-- 선택한 취미 : <%=hobby[0] %>,<%=hobby[1] %>,<%=hobby[2] %><br> --%>
선택한 취미 :
<%
//hobby가 null이 아니면 동작
if(hobby!=null){
	for(int i=0;i<hobby.length;i++){
		%><%=hobby[i]%><%
	}
}
%> <br>
<table border="1">
<tr><td>취미</td></tr>
<%
if(hobby!=null){
	for(int i=0;i<hobby.length;i++){
		%>
		<tr><td><%=hobby[i]%></td></tr>
		<%
	}
}
%>
</table>
등급 : <%=grade %><br>
</body>
</html>

