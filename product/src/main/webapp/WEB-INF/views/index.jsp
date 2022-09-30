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
div div{
	display: inline-block;
}
img{
 width: 50%;
 margin-left: -30%;
}
</style>
</head>
<body>
	<div id="mp">
		<h2>메인 페이지</h2>
		<!-- <div>
			<img src="/resources/image/login.png" />
		</div> -->
		<div>
			<a href="moveLogin">로그인</a><br><br>
			<a href="moveSignup">회원가입</a><br><br>
		</div>
	</div>
</body>
</html>