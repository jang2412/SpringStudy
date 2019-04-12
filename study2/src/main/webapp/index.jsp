<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>/index.jsp</title>
</head>
<body>
<%@ include file="/WEB-INF/views/inc/top.jsp" %>

<a href="${pageContext.request.contextPath}/board/list.do">게시판 목록</a><br>
<a href="<c:url value="/board/list.do" />">게시판 목록</a><br>
<hr>
<a href="<c:url value="/admin/member/list.do" />">관리자 회원 목록</a>
<div class="container">
<p>
	<a href="regist.do" >
	<button type="button" class="btn btn-success">회원가입</button>
	</a>
</p>
</div>
</body>
</html>