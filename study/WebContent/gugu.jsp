<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>구구단</title>
</head>
<body>
<%--

요청 파라미터 규약
파라미터는 영어, 숫자는 그대로 입력, 그 외로 다른 규약에 의해 변환
http://daum.net/news/list.jsp?p=v&2=a&p3=b~~~~~~

Q2
webContent/sum.jsp 생성
사용자가 입력한 최소값부터 최대값까지의 합을 출력
만약 최소값이 없다면 1로 처리
최대값이 없다면 100으로 처리
-------------------
sum.jsp		:	1 부터 100까지 합 : 5050
sum.jsp?min=10	:	10부터 100까지 합 : ???
sum.jsp?min=5&max=10	:	5부터 10까지 합 : ???

 --%>

<h1>구	구	단</h1>
당신의 IP : <%=request.getRemoteAddr() %><br />
당신의 IP : <% out.println(request.getRemoteAddr()); %><br />
<%
	String t = request.getParameter("dan");
	int dan = 2;
	if(t != null){
		dan = Integer.parseInt(t);
	}
	out.println("<h3>" + dan + "단</h3>");
	
	for(int i=1;i<10;i++) {
		out.println(dan + " * " + i + " = " + (dan * i));
		out.println("<br>");
	}
%>
</body>
</html>