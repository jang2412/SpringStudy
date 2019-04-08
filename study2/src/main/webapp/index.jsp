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
<a href="/board/list.do">게시판 목록</a><br>
<a href="/pcu/board/list.do">게시판 목록</a><br>
<a href="${pageContext.request.contextPath}/board/list.do">게시판 목록</a><br>
<a href="<c:url value="/board/list.do" />">게시판 목록</a><br>
</body>
</html>