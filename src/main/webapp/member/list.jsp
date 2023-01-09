<%@page import="com.itwillbs.member.db.MemberDTO"%>
<%@page import="com.itwillbs.member.db.MemberDAO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>member/list.jsp</title>
</head>
<body>
<h1>회원목록</h1>
<%
//세션값 가져오기
String id=(String)session.getAttribute("id");
if(id==null){
	//세션값이 없으면 => loginForm.jsp
	response.sendRedirect("loginForm.jsp");
}else{
	//세션값이 있으면 => admin 아니면 => main.jsp
	if( ! (id.equals("admin")) ){
		response.sendRedirect("main.jsp");
	}
}

//디비작업 기능 => MemberDAO
// 사용 => MemberDAO 기억장소 할당(객체생성)
MemberDAO dao=new MemberDAO();
// dao주소를 통해서 메서드 호출
// 여러명을 저장하는 List배열변수=dao.getMemberList();
// List memberList =dao.getMemberList();
List<MemberDTO> memberList =dao.getMemberList();
System.out.println("전달 받은 배열 주소 : "+memberList);

// //5단계 : 배열저장 for (select)
%>
<table border="1">
<tr><td>아이디</td><td>비밀번호</td>
    <td>이름</td><td>가입날짜</td></tr>
    <%
    for(int i=0;i<memberList.size();i++){
//     	MemberDTO dto=(MemberDTO)memberList.get(i);
//      참조형의 형변환 없이 가져옴
		MemberDTO dto=memberList.get(i);
    	%>
<tr><td><%=dto.getId() %></td>
    <td><%=dto.getPass() %></td>
    <td><%=dto.getName() %></td>
    <td><%=dto.getDate() %></td></tr>    	
    	<%
    }
    %>
</table>
</body>
</html>