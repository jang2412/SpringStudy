<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String ctxPath = request.getContextPath();
%>
<%--
   CDN(Contents Delivery Network) 방식인 경우
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"  
 	 	integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
  		crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
--%>

<link rel="stylesheet" href="<%=ctxPath %>/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="<%=ctxPath %>/bootstrap/css/bootstrap-theme.min.css">

<script src="<%=ctxPath %>/js/jquery-3.3.1.min.js"></script>
<script src="<%=ctxPath %>/bootstrap/js/bootstrap.min.js"></script>