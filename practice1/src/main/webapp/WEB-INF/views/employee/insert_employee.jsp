<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
#head{
	background-color: #d3d3d3;
}
.tag{
	display:inline-block;
	width: 100px;
	background-color: #d3d3d3;
	text-align: center;
	border: 1px solid black;
}
#id, #name, #dept{
	margin-top: -1%;	
	height: 18px;
}

#btn{
	text-align: center;
}
</style>
</head>
<body>
	<div id="head">	
		<h2>사원 관리 - 사원 등록</h2>
	</div>
	<div>
		<form method="post" action="insertEmployee.do">
			<span class="tag">사원번호</span><input type="text" id="num" name="num"/><span>(사원번호 입력 형식:1403101)</span><br>
			<span class="tag">사원이름</span><input type="text" id="name" name="name"/><br>
			<span class="tag">부서명</span><input type="text" id="dept" name="dept"/>
			<div id="btn">
				<input type="submit" value="사원등록" />
				<input type="button" value="취소" />
			</div>
		</form>
	</div>
	
</body>
</html>