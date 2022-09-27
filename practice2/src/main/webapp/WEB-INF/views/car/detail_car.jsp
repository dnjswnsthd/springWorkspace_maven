<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
 	width: 150px;
}
.selec{
	width: 170px;
	height: 30px;
}
table{
	width: 80%;
	border : 1px solid black;
	margin: auto;
}
</style>
<script type="text/javascript">
	function goSelectCar(){
		location.href = '/moveCarList';
	}
	function goMain(){
		location.href = '/';
	}
</script>
</head>
<body>
	<div id="head">	
		<h2>사원 관리 - 사원 상세정보</h2>
	</div>
	<div>
		<form method="post">
			<table>
					<tr>
						<td id="tag">차량번호</td>
						<td><input type="text" id="num" name="num" value="${car.num}" readonly="readonly"/></td>
					</tr>
					<tr>
						<td id="tag">모 델 명</td>
						<td><input type="text" id="model" name="model" value="${car.model}"/></td>
					</tr>
					<tr>
						<td id="tag">가 격</td>
						<td><input type="text" id="price" name="price" value="${car.price}"/></td>
					</tr>
					<tr>
						<td id="tag">제 조 사</td>
						<td><input type="text" id="vendor" name="vendor" value="${car.company.vendor}" readonly="readonly"/></td>
					</tr>
			</table>
			<div id="btn">
				<input type="submit" value="수정" formaction="updateCar.do" />
				<input type="button" value="사원목록" onclick="goSelectCar()">
				<input type="button" value="메인페이지로" onclick="goMain()">
			</div>
		</form>
	</div>
	
</body>
</html>