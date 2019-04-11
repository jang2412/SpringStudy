<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/index.jsp</title>
</head>
<body>
<!-- 위에 꺼 두개는 동작안함 -->
<a href="/board/list.do">게시판 목록</a><br>
<a href="/pcu/board/list.do">게시판 목록</a><br>
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