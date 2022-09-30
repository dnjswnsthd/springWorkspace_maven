<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
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
	width: 250px;
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
#foot{
	text-align: center;
	margin-top: 1%;
}
</style>
<script type="text/javascript">
	function goSelectCar(){
		location.href = '/moveCarList';
	}
	function goMain(){
		location.href = '/';
	}
	function goCart(){
		location.href = '/moveCart';
	}
</script>
</head>
<body>
	<jsp:include page="../header.jsp"></jsp:include>
	<div id="head">	
		<h2>입력된 상품정보</h2>
	</div>
	<div>
		<form method="post">
			<table>
					<tr>
						<td id="tag">상품명</td>
						<td><input type="text" id="title" name="title" value="${product.title}" readonly="readonly"/></td>
					</tr>
					<tr>
						<td id="tag">상품코드</td>
						<td><input type="text" id="code" name="code" value="${product.code}"/></td>
					</tr>
					<tr>
						<td id="tag">상품 분류</td>
						<td><input type="text" id="category" name="category" value="${product.category}"/></td>
					</tr>
					<tr>
						<td id="tag">이율</td>
						<td><input type="text" id="rate" name="rate" value="${product.rate}"/></td>
					</tr>
					<tr>
						<td id="tag">메모</td>
						<td><input type="text" id="memo" name="memo" value="${product.memo}"/></td>
					</tr>
			</table>
			<div id="btn">
				<input type="button" value="차량목록" onclick="goSelectCar()">
				<input type="submit" value="삭제" formaction="deleteProduct.do" />
			</div>
		</form>
	</div>
	
</body>
</html>