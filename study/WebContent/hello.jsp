<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>첫날입니다....</title>
</head>
<body>
<%
	String a = "안녕하세요~~~ <br />";	
	for(int i = 0; i < 10; i++ ){
		out.println(a);	
	}
%>

<%--
 hello2.jsp 파일 생성 
 "Hello World ~~~" 5번 반복해서 출력 	
 
 실행방법1 : server 기동 후에 확인  직접 브라우저에서 확인 : 
     http://localhost:8080/study/hello2.jsp

 실행방법2 : hello2.jsp  Ctrl + F11 

--%>



</body>
</html>


