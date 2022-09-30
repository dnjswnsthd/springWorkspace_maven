<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
	border: 1px solid black;
	border-radius: 10px;
	width: 80%;
	margin: auto;
}
#btn input{
	padding: 10px;
	margin: 1%;
	background-color: navy;
 	color: white;
 	border-radius: 10px;
 	width: 250px;
}
.selec{
	width: 170px;
	height: 30px;
}
table{
	width: 50%;
	border : 1px solid black;
	margin: auto;
	margin-bottom: 1%;
}
</style>
</head>
<body>
	<jsp:include page="../header.jsp"></jsp:include>
	<div id="head">	
		<h2>상품등록화면</h2>
	</div>
	<div>
		<form method="post" action="insertCar.do">
			<table>
				<tr>
					<td id="tag">상품 번호</td>
					<td><input type="text" id="code" name="code"/></td>
				</tr>
				<tr>
					<td id="tag">상품제목</td>
					<td><input type="text" id="title" name="title"/></td>
				</tr>
				<tr>
					<td id="tag">상품종류</td>
					<td>
						<select class="selec" name="category" id="category">
							<option value="목돈마련">목돈마련</option>
							<option value="주택마련">주택마련</option>
							<option value="학자금">학자금</option>
						</select>
					</td>
				</tr>
				<tr>
					<td id="tag">이율</td>
					<td><input type="text" id="rate" name="rate"/></td>
				</tr>
				<tr>
					<td id="tag">상품 설명</td>
					<td><input type="text" id="memo" name="memo"/></td>
				</tr>
			</table>
			<div id="btn">
				<input type="submit" value="상품저장" />
				<input type="button" value="취소" />
			</div>
		</form>
	</div>
	
</body>
</html>