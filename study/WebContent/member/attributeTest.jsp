<%@page import="study.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>attributeTest.jsp</title>
</head>
<body>
<%
	//	--- 컨트롤러 에서 업무처리를 호출하고 해당 결과(모델)를 속성에 저장
	MemberVO vo = new MemberVO();
	vo.setName("홍길동");
	vo.setBirth("1998-12-25");
	
	//	속성에 저장
	request.setAttribute("member", vo);
%>
<h3>뷰 영역 EL표기법</h3>
이름 : ${member.name}<br>	<%=vo.getName() %><br>
생일 : ${member.birth}<br> <%=vo.getBirth() %><br>
</body>
</html>