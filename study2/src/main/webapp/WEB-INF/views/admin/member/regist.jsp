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
<title>회원가입</title>
<%@include file="/WEB-INF/views/inc/include.jsp" %>
</head>
<body>
<div class="container">
<div class="page-header">
<h1>회 원 등 록</h1>
</div>
<form class="form-horizontal" action="regist.do" method="post">

  <div class="form-group">
    <label class="col-sm-2 control-label">아이디</label>
    <div class="col-sm-10">
      <input type="text" name="id" class="form-control" value="${member.id}" placeholder="">
      <form:errors path="member.id"></form:errors>
    </div>
  </div>
  
  <div class="form-group">
    <label class="col-sm-2 control-label">이름</label>
    <div class="col-sm-10">
      <input type="text" name="name" class="form-control" value="${member.name}" placeholder="">
      <form:errors path="member.name"></form:errors>
    </div>
  </div>
  
  <div class="form-group">
    <label class="col-sm-2 control-label">생년월일</label>
    <div class="col-sm-10">
      <input type="date" name="birth" pattern="yyyy-mm-dd" class="form-control" value="${member.birth}" placeholder="">
      <form:errors path="member.birth"></form:errors>
    </div>
  </div>
  
  <div class="form-group">
    <label class="col-sm-2 control-label">연락처</label>
    <div class="col-sm-10">
      <input type="tel" name="tel" class="form-control" value="${member.tel}" placeholder="">
    </div>
  </div>
  
  <div class="form-group">
    <label class="col-sm-2 control-label">주소</label>
    <div class="col-sm-10">
      <input type="text" name="address" class="form-control" value="${member.address}" placeholder="">
    </div>
  </div>
  
  <div class="form-group">
    <label class="col-sm-2 control-label">지역</label>
    <div class="col-sm-10">
      <select name="localeCd" class="form-control">
        <option value="">지역선택</option>
        <option value="LC01" ${member.localeCd eq 'LC01' ? 'selected' : ''}>서울특별시</option>
        <option value="LC02" ${member.localeCd eq 'LC02' ? 'selected' : ''}>대전광역시</option>
        <option value="LC03" ${member.localeCd eq 'LC03' ? 'selected' : ''}>인천광역시</option>
        <option value="LC04" ${member.localeCd eq 'LC04' ? 'selected' : ''}>경기도</option>
        <option value="LC05" ${member.localeCd eq 'LC05' ? 'selected' : ''}>충청남도</option>
      </select>
    </div>
  </div>
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" class="btn btn-default">가입하기</button>
    </div>
  </div>
</form>
</div>
</body>
</html>