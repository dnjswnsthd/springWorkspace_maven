<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

</head>
<body>
	<jsp:include page="/header.jsp"></jsp:include>
	<table>
		<tr>
			<th>모델번호</th>
			<th>모델이름</th>
			<th>가격</th>
			<th>제조사명</th>
			<th>삭제</th>
		</tr>
		<c:forEach items="${phones}" var="phone">
			<tr>
				<td><a href="detail.do?num=${phone.num}">${phone.num}</a></td>
				<td>${phone.model}
				<td>${phone.price}</td>
				<td>${phone.company.vendor}</td><!-- 중요! phone에서 company객체 getter해서 vendor가져오는 거임 -->
				<td><input type="checkbox" data-num="${phone.num}"></td><!-- num에 대한 내용을 보낸다 -->
			</tr>
		</c:forEach>
	</table>
	<a href="regPhone.do">추가 등록</a>&nbsp;
	<a href="#" id="selectedDel">선택항목삭제</a>
</body>
<script>
	$('#selectedDel').click(function() {
		var param="";
		
		$(":checkbox:checked").each(function(index, item) {
			param = param + "&num=" + $(item).attr("data-num");
		});//each
		
		$.ajax({
			type:'post',
			url:'deleteAjax.do',
			data:param,
			
			success:function(result) {
				location.reload();
			}
		});
		
	});
</script>
</html>