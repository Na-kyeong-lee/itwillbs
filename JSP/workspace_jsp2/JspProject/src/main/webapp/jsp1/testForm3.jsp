<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jsp1/testForm3.jsp</title>
</head>
<body>
<form action="testPro3.jsp" method="get">
아이디 : <input type="text" name="id"><br>
비밀번호 : <input type="password" name="pass"><br>
자기소개 : <textarea name="intro" rows="5" cols="10"></textarea><br>
성별 : <input type="radio" name="gender" value="남">남
<input type="radio" name="gender" value="여">여<br>
취미 : <input type="checkbox" name="hobby" value="여행">여행
<input type="checkbox" name="hobby" value="게임">게임
<input type="checkbox" name="hobby" value="운동">운동<br>
등급 : <select name="grade">
	<option value="">등급 선택하세요</option>
	<option value="1">1등급</option>
	<option value="2">2등급</option>
	<option value="3">3등급</option>
</select><br>
<input type="submit" value="전송"> 
</form>
</body>
</html>