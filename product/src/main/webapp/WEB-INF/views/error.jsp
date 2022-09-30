<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="/resources/common.css" rel="stylesheet" />
<style type="text/css">
#head{
	width: 80%;
	margin: auto;
	text-align: center;
	border: 1px solid black;
	border-radius: 10px;
	margin-bottom: 1%;
}
#mid{
	text-align: center;
	width: 80%;
	border: 1px solid black;
	border-radius: 10px;
	margin: auto;
}
#foot{
	margin-top: 1%;
	text-align: center;
}
</style>
</head>
<body>
	<div id="head">	
		<h2>에러</h2>
	</div>
	<div id="mid">
		<h1>처리 중 문제가 발생하였습니다.</h1>
		<h2>문제 내용 - ${e.message}</h2>
	</div>
	<div id="foot">
		<a href="/">홈으로 돌아가기</a>
	</div>
</body>
</html>