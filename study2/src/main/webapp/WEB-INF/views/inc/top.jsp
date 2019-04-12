<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>        
<%-- // 모든 페이지에 인클루드 되어 보여주는 상단 메뉴 부분  --%>
<nav class="navbar navbar-default">
	<div class="navbar-header">      
     <a class="navbar-brand" href="/pcu/">
     	<span class="glyphicon glyphicon-home"></span>
     </a>
   </div>
  <div class="container-fluid">    
      <ul class="nav navbar-nav navbar-right">
        <li><a href="#">관리자 회원목록</a></li>
        <c:if test="${empty LOGIN_INFO}">        	
        	<li><a href="<c:url value="/join/login.do" />">로그인</a></li>
        </c:if>
        <c:if test="${not empty LOGIN_INFO}">
        	<li><a href="<c:url value="/join/logout.do" />">로그아웃</a></li>
        </c:if>
      </ul>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>