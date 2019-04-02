<%@page import="study.vo.MemberVO"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>member/elTest2.jsp</title>
</head>
<body>
<c:set var="auth" value="CRU" />

회원목록 주르륵... <br>
<c:if test="${fn:contains(auth, 'C') }">
<button type="button">등록</button><br>
	</c:if>
<c:if test="${fn:contains(auth, 'U') }">
	<button type="button">수정</button><br>
</c:if>
<c:if test="${fn:indexOf(auth, 'D') > -1 }">
	<button type="button">삭제</button><br>
</c:if>

C = ${fn:contains(auth, 'C')}

<c:set var="num" value="88"></c:set>
<c:choose>
	<c:when test="${num > 90 and num <= 100}">
		수
	</c:when>
	<c:when test="${num gt 80 }">우</c:when>
	<c:otherwise>
		용돈 없음~~
	</c:otherwise>
</c:choose>
<br>단순한 foreach
<c:set var="dan" value="7"></c:set>
<ul>${dan}단
	<c:forEach var="i" begin="1" end="9">
		<li>${dan} * ${i} = ${dan*i}
	</c:forEach>
</ul>

객체리스트(배열, 리스트) 맵(key, value 로 접근)
<%
	List list = new ArrayList();
	
	list.add(new MemberVO("a","1991","M"));
	list.add(new MemberVO("b","1992","W"));
	list.add(new MemberVO("c","1993","M"));
	list.add(new MemberVO("d","1994","W"));
	request.setAttribute("members", list);
%>

<c:forEach var="vo" items="${members}" varStatus="st">
	${st.count} ${vo.name} ${vo.birth} ${vo.gender}<br>
</c:forEach>

</body>
</html>