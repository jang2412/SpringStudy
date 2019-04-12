<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>로그인</title>
<%@include file="/WEB-INF/views/inc/include.jsp" %>
</head>
<body>
<%@ include file="/WEB-INF/views/inc/top.jsp" %>
<div class="container">
<div class="page-header">
<h1>로 그 인</h1>
<!-- 
<form:errors path="member"></form:errors> : 전역에러 메시지 출력
<form:errors path="member.id"></form:errors> : 해당 필드 메시지
<form:errors path="member.*"></form:errors> : 전역 및 필드 에러 메시지 출력
 -->
</div>
<form class="form-horizontal" action="login.do" method="post">

  <div class="form-group">
    <label class="col-sm-2 control-label">아이디</label>
    <div class="col-sm-10">
      <input type="text" name="id" class="form-control" value="${member.id}" placeholder="아이디 입력">
      <form:errors path="member.id"></form:errors>
    </div>
  </div>
  
  <div class="form-group">
    <label class="col-sm-2 control-label">비밀번호</label>
    <div class="col-sm-10">
      <input type="password" name="password" class="form-control" placeholder="비밀번호 입력">
      <form:errors path="member.password"></form:errors>
    </div>
  </div>
  
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" class="btn btn-default">로그인</button>
    </div>
  </div>
</form>
</div>
</body>
</html>