<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	td, h2{
		test-align : center;
	}
</style>
</head>
<body>
<h2>++++++++++++상품 정보를 출력합니다.++++++++++</h2>
<table border="2" align="center" width="50%">
	<thead>
		<tr>
			<th>아이디</th><th>상품명</th><th>제조사</th><th>가격</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${list}" var = "vo">
			<tr>
				<td>${vo.id}</td>
				<td>${vo.name}</td>
				<td>${vo.maker}</td>
				<td>${vo.price}</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
<p></p>

<center><a href="product.jsp">상품가입하기 폼으로....</a></center>
</body>
</html>