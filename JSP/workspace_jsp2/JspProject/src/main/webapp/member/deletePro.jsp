<%@page import="com.itwillbs.member.db.MemberDTO"%>
<%@page import="com.itwillbs.member.db.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>member/deletePro.jsp</title>
</head>
<body>
<%
//폼에서 입력한 파라미터값(id,pass)을 서버에 request에 저장
//변수 = request에 저장된 값 가져오기
String id=request.getParameter("id");
String pass=request.getParameter("pass");
//MemberDAO 객체생성
MemberDAO dao=new MemberDAO();
// MemberDTO dto =디비작업주소.userCheck(id,pass) 메서드 호출
MemberDTO dto=dao.userCheck(id, pass);
//dto null이 아니면  =>"아이디 비밀번호 일치" =>삭제,메인이동
//    null이면      => "아이디 비밀번호 틀림" => 뒤로이동
if(dto!=null){
//다음행이동=> 데이터 있으면 => true =>"아이디 비밀번호 일치"
// 리턴할형없음 void deleteMember(String id) 메서드 정의
// deleteMember(id) 메서드 호출
dao.deleteMember(id);
// 세션초기화
session.invalidate();
// main.jsp 이동
response.sendRedirect("main.jsp");
}else{
//데이터 없으면 => false => "아이디 비밀번호 틀림"	
// 	"입력하신 정보 틀림", 뒤로이동
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