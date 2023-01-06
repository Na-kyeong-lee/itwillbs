<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jsp3/insertForm.jsp</title>
</head>
<body>
<h1>회원가입</h1>
<form action="insertPro.jsp" method="get"> <!-- form에서 아이디비번 넣으면 get방식으로 pro로 넘어감(주소줄에 보이는 형식) -->
아이디 : <input type="text" name="id"><br>
비밀번호 : <input type="password" name="pass"><br>
이름 : <input type="text" name="name" value="나람쥐"><br>
<input type="submit" value="회원가입"> <!-- value에는 상자에 텍스트가 적힘 -->
</form>
</body>
</html>




