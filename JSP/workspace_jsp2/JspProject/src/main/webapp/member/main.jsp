<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>member/main.jsp</title>
</head>
<body>
<%
String id=(String)session.getAttribute("id");
// id가 null(세션값이 없으면 ) loginForm.jsp 이동
if(id==null){
	response.sendRedirect("loginForm.jsp");
}
%>
<h1>메인 화면</h1>
<%=id %>님 로그인 하셨습니다.
<a href="logout.jsp">로그아웃</a><br>
<a href="info.jsp">정보조회</a><br>
<a href="updateForm.jsp">정보수정</a><br>
<a href="deleteForm.jsp">정보삭제</a><br>
<!-- admin 사용자만 보이게 설정 
    문자열 비교 => 문자열.equals(문자열)
    id null이면 equals 사용못함-->
<%
if(id != null){
	if(id.equals("admin")){
		%>
		<a href="list.jsp">회원목록</a><br>
		<%
	}
}
%>

</body>
</html>

