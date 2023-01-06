<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jsp1/session.jsp</title>
</head>
<body>
<%
// HttpSession 자바파일
// session 내장객체 : 클라이언트, 서버 연결 정보를 저장하는 내장객체
// 로그아웃 => session 내장객체 삭제
//  1. 브라우저 모두 닫았을때(사용자가 가지고 있는 session삭제)
//  2. 30분동안 작업하지 않았을때(서버에 있는 session삭제)
//  3. session.invalidate() => 서버 session삭제

%>
session ID : <%=session.getId() %><br>
session 생성시간 : <%=session.getCreationTime() %><br>
session 최종 접근시간 : <%=session.getLastAccessedTime() %><br>
session 유지 시간 : <%=session.getMaxInactiveInterval() %>초(30분)<br>
session 유지 시간 변경 
<%
session.setMaxInactiveInterval(3600);
%>
<br>
session 변경 후 유지 시간 : 
<%=session.getMaxInactiveInterval() %>초(60분)<br>
session 내장객체 삭제 :
<%
// session.invalidate();

// session에 이름,값 => 값을 저장
session.setAttribute("id", "kim");
// session값 가져오기
%>
<br>
session 저장된 값 가져오기 : <%=session.getAttribute("id") %>
</body>
</html>

