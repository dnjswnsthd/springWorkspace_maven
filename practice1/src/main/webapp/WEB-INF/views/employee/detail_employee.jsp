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
	background-color: #d3d3d3;
}
.tag{
	display:inline-block;
	width: 100px;
	background-color: #d3d3d3;
	text-align: center;
	border: 1px solid black;
}
#id, #name, #dept{
	margin-top: -1%;	
	height: 18px;
}

#btn{
	text-align: center;
}

#delete{
	width: 100px;
	background-color:gray;
	border: 1px solid black;
}
</style>
<script type="text/javascript">
	function goSelectEmploye(){
		location.href = '/moveEmployeeList';
	}
</script>
</head>
<body>
	<div id="head">	
		<h2>사원 관리 - 사원 상세정보</h2>
	</div>
	<div>
		<form method="post">
			<span class="tag">사원번호</span><input type="text" id="num" name="num" value="${employee.num}"/><br>
			<span class="tag">사원이름</span><input type="text" id="name" name="name" value="${employee.name}"/><br>
			<span class="tag">부서명</span><input type="text" id="dept" name="dept" value="${employee.dept}"/>
			<div id="btn">
				<input type="submit" value="수정" formaction="updateEmployee.do" />
				<input type="button" value="사원목록" onclick="goSelectEmploye()">
				<input type="submit" value="삭제" formaction="deleteEmployee.do" />
			</div>
		</form>
	</div>
	
</body>
</html>