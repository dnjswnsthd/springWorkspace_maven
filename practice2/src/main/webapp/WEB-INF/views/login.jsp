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
	width: 30%;
	margin-top: 1%;
	margin: auto;
	text-align: center;
	border: 1px solid black;
	border-radius: 10px;
	margin-bottom: 1%;
}
#tag{
	background-color: navy;
 	color: white;
	width: 200px;
}
td input{
	height: 25px;
}

#btn{
	text-align: center;
	margin-top: 1%;
}
#btn input{
	padding: 10px;
	margin: 1%;
	background-color: navy;
 	color: white;
 	border-radius: 10px;
}
.selec{
	width: 170px;
	height: 30px;
}
table{
	width: 20%;
	border : 1px solid black;
	margin: auto;
}
</style>
</head>
<body>
	<div id="head">	
		<h2>로그인</h2>
	</div>
	<div>
		<form method="post" action="login.do">
			<table>
				<tr>
					<td id="tag">아이디</td>
					<td><input type="text" id="id" name="id" required="required"/></td>
				</tr>
				<tr>
					<td id="tag">비밀번호</td>
					<td><input type="password" id="pw" name="pw" required="required"/></td>
				</tr>
			</table>
			<div id="btn">
				<input type="submit" value="로그인" />
				<input type="button" value="취소" />
			</div>
		</form>
	</div>
</body>
</html>