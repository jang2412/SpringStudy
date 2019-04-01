<%@page import="org.apache.commons.beanutils.BeanUtils"%>
<%@page import="study.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//	요청된 정보의 인코딩 설정(기본은 라틴어)
	request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>가입 확인</title>
</head>
<body>
<h3>3. 입력하신 정보 : useBean 을 활용 (실제 사용하지 않음)</h3>
useBean 하면 속성에 저장(attributeTest.jsp에 request.setAttribute("member", vo);)<br>
jsp:setProperty property == BeanUtils.populate(member, request.getParameterMap()); 동일한 작업<br>
<jsp:useBean id="mem" class="study.vo.MemberVO"></jsp:useBean>
<jsp:setProperty property="*" name="mem"/>

이름 : ${mem.name}<br>
생년월일 : ${mem.birth}<br>
취미 : ${mem.hobby}<br>
성별 : ${mem.gender}<br>
주소 : ${mem.address}<br>

<h3>2. 입력하신 정보 : 파라미터를 VO에 담아서 기술</h3>
<!-- 파라미터를 VO 에 담아서 기술 -->
<%
	MemberVO member = new MemberVO();
/* 	member.setName(request.getParameter("name"));
	member.setBirth(request.getParameter("birth")); */
	//	받아온 파라미터 중에 이름, 생년월일 이런 것 등이 있다면 객체에 넣어줌.
	BeanUtils.populate(member, request.getParameterMap());
%>
이름 : <%=member.getName() %><br />
생년월일 : <%=member.getBirth() %><br />
취미 : <%=member.getHobby() %><br />
<%
	for(String h : member.getHobby()){
		out.println("취미 : " + h);
	}
%>
성별 : <%=member.getGender() %><br />
주소 : <%=member.getAddress() %><br />


<h3>1. 입력하신 정보 : 파라미터를 직접 기술 getParameter</h3>
<!-- 파라미터를 직접 기술 getParameter -->
접속 IP : <%=request.getRemoteAddr() %><br />
이름 : <%=request.getParameter("name") %><br />
생년월일 : <%=request.getParameter("birth") %><br />
취미 : <%=request.getParameter("hobby") %><br />
성별 : <%=request.getParameter("gender") %><br />
주소 : <%=request.getParameter("address") %><br />
</body>
</html>