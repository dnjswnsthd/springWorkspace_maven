<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="/resources/common.css" rel="stylesheet" />
<style type="text/css">
#mp{
	text-align: center;
	border: 3px solid black;
	border-radius: 10px;
	width: 50%;
	margin: auto;
}
#mp a{
	font-size: 20px;
}
</style>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div id="mp">
		<h2>메뉴 페이지</h2>
		<a href="moveTemp">차량 등록</a><br><br>
		<a href="moveTempList">차량 목록</a><br><br>
	</div>
</body>
</html>