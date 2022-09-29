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
		<h2>자동차 관리 - 자동차 등록</h2>
	</div>
	<div>
		<form method="post" action="insertTemp.do">
			<table>
				<tr>
					<td id="tag">차량번호</td>
					<td><input type="text" id="num" name="num" required="required"/></td>
				</tr>
				<tr>
					<td id="tag">모 델 명</td>
					<td><input type="text" id="model" name="model" required="required"/></td>
				</tr>
				<tr>
					<td id="tag">가격</td>
					<td><input type="text" id="price" name="price" required="required"/> 만원</td>
				</tr>
				<tr>
					<td id="tag">제조사코드</td>
					<td>
						<select class="selec" name="vcode" id="vcode" required="required">
							<c:forEach var="item" items="${list}">
								<option value="${item.vcode}"
								title="${item.vcode}">${item.vendor}</option>
							</c:forEach>
						</select>
					</td>
				</tr>
			</table>
			<div id="btn">
				<input type="submit" value="자동차등록" />
				<input type="button" value="취소" />
			</div>
		</form>
	</div>
	
</body>
</html>