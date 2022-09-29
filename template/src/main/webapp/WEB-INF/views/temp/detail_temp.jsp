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
<script type="text/javascript">
	function goSelectTemp(){
		location.href = '/moveTempList';
	}
	function goMain(){
		location.href = '/';
	}
</script>
</head>
<body>
	<jsp:include page="../header.jsp"></jsp:include>
	<div id="head">	
		<h2>사원 관리 - 사원 상세정보</h2>
	</div>
	<div>
		<form method="post">
			<table>
					<tr>
						<td id="tag">차량번호</td>
						<td><input type="text" id="num" name="num" value="${temp.num}" readonly="readonly"/></td>
					</tr>
					<tr>
						<td id="tag">모 델 명</td>
						<td><input type="text" id="model" name="model" value="${temp.model}"/></td>
					</tr>
					<tr>
						<td id="tag">가 격</td>
						<td><input type="text" id="price" name="price" value="${temp.price}"/></td>
					</tr>
					<tr>
						<td id="tag">제 조 사</td>
						<td>
							<select class="selec" name="vcode" id="vcode">
								<c:forEach var="item" items="${list}">
									<c:choose>
										<c:when test="${item.vcode == temp.vcode }">
											<option value="${item.vcode}" title="${item.vcode}" selected="selected">${item.vendor}</option>
										</c:when>
										<c:otherwise>
											<option value="${item.vcode}" title="${item.vcode}">${item.vendor}</option>
										</c:otherwise>
									</c:choose>
								</c:forEach>
							</select>
						</td>
						<%-- <td><input type="text" id="vendor" name="vendor" value="${temp.company.vendor}" readonly="readonly"/></td> --%>
					</tr>
			</table>
			<div id="btn">
				<input type="submit" value="수정" formaction="updateTemp.do" />
				<input type="button" value="차량목록" onclick="goSelectTemp()">
				<input type="button" value="메인페이지로" onclick="goMain()">
			</div>
		</form>
	</div>
	
</body>
</html>