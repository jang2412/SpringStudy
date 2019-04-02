<%@page import="study.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

ip : <%=request.getRemoteAddr() %><br>
URI : <%=request.getRequestURI() %><br>
컨텍스트 경로 : <%=request.getContextPath() %><br>
<hr>
ip : ${pageContext.request.remoteAddr }<br>
URI : ${pageContext.request.requestURI }<br>
컨텍스트 경로 : ${pageContext.request.contextPath }<br>
<%
	MemberVO vo = new MemberVO();
	vo.setName("홍길동");
	vo.setBirth("2002-07-07");
	MemberVO vo2 = new MemberVO();
	vo2.setName("재용");
	vo2.setBirth("1991-11-07");
	
	pageContext.setAttribute("member", vo);
	request.setAttribute("member", vo2);
	//pageContext.setAttribute("member2", vo2);
%>

회원명 : ${member.name}<br>
생일 : ${member.birth}<br>

회원명 : ${requestScope.member.name}<br>
생일 : ${requestScope.member.birth}<br>

<c:set var="love" value="100"></c:set>
<c:set var="memName" value="${member.name} 짱~~"></c:set>

${love}<br>
${memName}<br>

<c:set var = "num" value="89" />
<c:if test="${num > 90}">
	아주 우수....<br>
</c:if>
<c:if test="${!(num > 90)}">
	이번달 용돈 없어~~~ <br>
</c:if>

</body>
</html>