<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jsp1/includeMain.jsp</title>
</head>
<body>
<!-- include 액션태그 : jsp문법 태그처럼 사용
                     : 반복되는 부분을 파일로 만듬
                     : 파일을 include해서 사용
                     : 파일 하나만 수정하면 모든파일 수정 -->
<h1>jsp1/includeMain.jsp</h1>
<table border="1" width=600 >
<tr height=100><td colspan="2">
               <jsp:include page="includeTop.jsp" />
               </td></tr>
<tr height=400><td>왼쪽메뉴</td><td>본문내용1</td></tr>
<tr height=100><td colspan="2">
      <jsp:include page="includeBottom.jsp" /></td></tr>
</table>
</body>
</html>

