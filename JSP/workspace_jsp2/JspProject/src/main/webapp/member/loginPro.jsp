<%@page import="com.itwillbs.member.db.MemberDTO"%>
<%@page import="com.itwillbs.member.db.MemberDAO"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>member/loginPro.jsp</title>
</head>
<body>
<%
// 폼에서 입력한 id, pass => 서버 request에 저장 
// request에 저장된 id,pass 파라미터 => 변수에 저장
String id=request.getParameter("id");
String pass=request.getParameter("pass");

// MemberDAO 객체생성
MemberDAO dao=new MemberDAO();
// 리턴할형MemberDTO userCheck(String id,String pass)
// 메서드 정의
System.out.println("디비작업하는 주소 : " + dao);
// MemberDTO dto =디비작업주소.userCheck(id,pass) 메서드 호출
MemberDTO dto=dao.userCheck(id, pass);
System.out.println("데이터 저장된 리턴받은 주소 : " + dto);

//dto null이 아니면  =>"아이디 비밀번호 일치" =>세션값 생성,메인이동
//    null이면      => "아이디 비밀번호 틀림" => 뒤로이동
if(dto!=null){
	//데이터 있으면 => true =>"아이디 비밀번호 일치"
	out.println("아이디 비밀번호 일치");
	// 페이지 상관없이 값이 유지 => 세션값 부여(저장)
	session.setAttribute("id", id);
	// main.jsp 이동
	response.sendRedirect("main.jsp");
}else{
	//데이터 없으면 => false => "아이디 비밀번호 틀림"
	out.println("아이디 비밀번호 틀림");
	// "입력하신 정보 틀림", 뒤로이동
	%>
	<script type="text/javascript">
		alert("입력하신 정보 틀림");
		history.back();
	</script>
	<%
}
%>
</body>
</html>



