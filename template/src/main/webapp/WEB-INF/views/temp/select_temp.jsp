<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
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
 th{
 	background-color: navy;
 	color: white;
 }
 #foot{
 	margin-top: 1%;
 	text-align: center;
 }
 #foot a{

 	padding-left : 20px;
 }
</style>
<script>
	$(function(){
		$('#tempDelete').click(function() {
			var param="";
			$(":checkbox:checked").each(function(index, item) {
				param = param + "&num=" + $(item).attr("data-num");
			});
			
			$.ajax({
				type:'post',
				url:'deleteTemp.do',
				data:param,
				
				success:function(result) {
					location.reload();
				}
			});
			
		});
	});
</script>
</head>
<body>
	<jsp:include page="../header.jsp"></jsp:include>
	<div id="head">	
		<h2>사원 관리 - 사원 등록</h2>
	</div>
	<table>
		<tr>
			<th>모델번호</th>
			<th>모델이름</th>
			<th>가격</th>
			<th>제조사명</th>
			<th>삭제</th>
		</tr>
		<c:forEach items="${temp}" var="temp">
			<tr>
				<td><a href="detail.do?num=${temp.num}">${temp.num}</a></td>
				<td>${temp.model}</td>
				<td>${temp.price}</td>
				<td>${temp.company.vendor}</td>
				<td><input type="checkbox" data-num="${temp.num}"></td>
			</tr>
		</c:forEach>
	</table>
	<div id="foot">
		<a href="/moveTemp">추가 등록</a>
		<a href="#" id="tempDelete">선택항목삭제</a>
	</div>
</body>
</html>