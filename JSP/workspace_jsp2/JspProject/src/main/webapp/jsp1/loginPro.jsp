<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jsp1/loginPro.jsp</title>
</head>
<body>
<%
// 폼에서 입력한 태그 내용을 서버에 전달
// 서버 request 내장객체 요청 정보 저장
// 태그 정보를 가져오기 id,pass 값을 가져오기 => 변수 저장
String id=request.getParameter("id") ;
String pass=request.getParameter("pass");
%>
폼에서 입력한 아이디 : <%=id %><br>
폼에서 입력한 비밀번호 : <%=pass %><br>
<%
//데이터베이스 1명 저장 아이디 "kim", 비밀번호 "1234"
String dbId="kim";
String dbPass="1234";
%>
디비에서 가져온 아이디 : <%=dbId %><br>
디비에서 가져온 비밀번호 : <%=dbPass %><br>
<%
//폼에서 가져온 아이디,비밀번호 와 디비에 저장된 아이디 비밀번호 비교
if(id.equals(dbId)){
	//아이디 일치
	out.println("아이디 일치");
	if(pass.equals(dbPass)){
		// 비밀번호 일치
		out.println("비밀번호 일치");
		
		// 일치
		// 세션값 생성 (페이지 상관없이 값을 유지)
		session.setAttribute("id", id);
		// loginMain.jsp 이동
		response.sendRedirect("loginMain.jsp");
		
	}else{
		out.println("비밀번호 틀림");
		%>
		<script type="text/javascript">
			alert("비밀번호 틀림");
			history.back();
		</script>
		<%
	}
}else{
	out.println("아이디 틀림");
	%>
	<script type="text/javascript">
		alert("아이디 틀림");
		history.back();
	</script>
	<%
}

%>
</body>
</html>