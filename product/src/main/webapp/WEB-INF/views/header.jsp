<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
	<link href="/resources/common.css" rel="stylesheet" />
</head>
<body>
	<c:if test="${!empty user}">
		<div style="text-align:center">
			${user.id} 님 로그인 되었습니다. &nbsp;&nbsp;&nbsp; <a href="logout.do">로그아웃</a>
		</div>
	</c:if>
	
	<%-- <h2><b>${title}</b></h2> --%>
</body>