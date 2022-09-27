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
#tag{
	background-color: #d3d3d3;
}
td input{
	height: 25px;
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
			<table>
				<tr>
					<td id="tag">사원번호</td>
					<td><input type="text" id="num" name="num"/></td>
					<td>(사원번호 입력 형식:1403101)</td>
				</tr>
				<tr>
					<td id="tag">사원이름</td>
					<td><input type="text" id="name" name="name"/></td>
					<td></td>
				</tr>
				<tr>
					<td id="tag">부서명</td>
					<td><input type="text" id="dept" name="dept"/></td>
					<td></td>
				</tr>
			</table>
			<div id="btn">
				<input type="submit" value="사원등록" />
				<input type="button" value="취소" />
			</div>
		</form>
	</div>
	
</body>
</html>