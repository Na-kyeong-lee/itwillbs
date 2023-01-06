<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jsp1/includeMain2.jsp</title>
</head>
<body>
<h1>jsp1/includeMain2.jsp</h1>
<table border="1" width=600 >
<tr height=100><td colspan="2">
               <jsp:include page="includeTop.jsp" /></td></tr>
<tr height=400><td>왼쪽메뉴</td><td>본문내용2</td></tr>
<tr height=100><td colspan="2">
      <jsp:include page="includeBottom.jsp" /></td></tr>
</table>
</body>
</html>

