<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
#head{
	background-color: #d3d3d3;
}
table {
	margin: auto;
	text-align: center;
    width: 90%;
    border: 1px solid #444444;
    border-collapse: collapse;
  }
  th, td {
    border: 1px solid #444444;
  }
  th{
  	background-color: #d3d3d3;
  }
  #foot{
  	text-align: center;
  }
</style>
</head>
<body>
	<div id="head">	
		<h2>사원 관리 - 사원 등록</h2>
	</div>
	<table>
		<tr>
			<th>사원번호</th>
			<th>사원이름</th>
			<th>부서</th>
		</tr>
		<c:forEach items="${employee}" var="employee">
			<tr>
				<td><a href="detail.do?num=${employee.num}">${employee.num}</a></td>
				<td>${employee.name}</td>
				<td>${employee.dept}</td>
			</tr>
		</c:forEach>
	</table>
	<div id="foot">
		<a href="/insertEmployee">추가 등록</a>&nbsp;
	</div>
</body>
</html>