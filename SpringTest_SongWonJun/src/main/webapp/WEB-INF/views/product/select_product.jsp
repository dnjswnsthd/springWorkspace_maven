<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link href="/resources/common.css" rel="stylesheet" />
<style type="text/css">
#head {
	width: 80%;
	margin: auto;
	text-align: center;
	border: 1px solid black;
	border-radius: 10px;
	margin-bottom: 1%;
}

table {
	margin: auto;
	text-align: center;
	width: 80%;
	border: 1px solid #444444;
	border-collapse: collapse;
}

th, td {
	border: 1px solid #444444;
	height: 25px;
}

th {
	background-color: navy;
	color: white;
}

#foot {
	margin-top: 1%;
	text-align: center;
}

#foot a {
	padding-left: 20px;
}

#search {
	text-align: right;
	margin-right: 10%;
	margin-bottom: 1%;
}

#search input[type=text] {
	height: 25px;
}

#search input[type=submit] {
	height: 30px;
}

.selec {
	width: 170px;
	height: 30px;
}
#add{
	text-align: center;
}
</style>
<script>
	$(function() {
		$('td a').hover(function() {
			$("#add").append($(this).html());
		},function(){
			$("#add").empty();
		});
	});
</script>
</head>
<body>
	<jsp:include page="../header.jsp"></jsp:include>
	<div id="head">
		<h2>상품 목록 화면</h2>
	</div>
	<div id="search">
		<form method="post" action="search.do">
			<select class="selec" name="contentKey" id="contentKey">
				<option value="all">전체</option>
				<option value="title">상품명</option>
				<option value="category">분류</option>
			</select> <input type="text" id="contentValue" name="contentValue"
				placeholder="검색어를 입력해주세요" /> <input type="submit" value="검색" />
		</form>
	</div>
	<table>
		<tr>
			<th>상품번호</th>
			<th>상품명</th>
			<th>상품분류</th>
			<th>가격</th>
		</tr>
		<c:forEach items="${product}" var="product">
			<tr>
				<td>${product.code}</td>
				<td><a id="hover" href="detail.do?code=${product.code}">${product.title}</a></td>
				<td>${product.category}</td>
				<td>${product.rate}</td>
			</tr>
		</c:forEach>
	</table>
	<div id="add"></div>
	<div id="foot">
		<a href="/moveProduct">상품 등록</a> <a href="/moveMenu">메인 페이지</a>
	</div>
</body>
</html>