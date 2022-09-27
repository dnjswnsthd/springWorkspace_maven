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
	width: 80%;
	margin: auto;
	text-align: center;
	border: 1px solid black;
	border-radius: 10px;
	margin-bottom: 1%;
}
#move{
	margin-top: 2%;
	background-color: skyblue;
	height: 35px;
	color: white;
	text-align: center;
	font-size: 1.3rem;
}
</style>
</head>
<body>
	<div id="mp">
		<h2>자동차 관리 - ${num } 등록 성공</h2>
	</div>
	<div id="move">
		<a href="moveCarList">자동차 목록 조회</a>
	</div>
</body>
</html>