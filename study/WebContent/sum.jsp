<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>sum.jsp</title>
</head>
<body>
<%
String min = request.getParameter("min");
String max = request.getParameter("max");
int sum = 0;
int pmin = 1;
int pmax = 100;
if(min != null){
	pmin = Integer.parseInt(min);
	pmax = Integer.parseInt(max);
	for(int i=pmin;i<=pmax;i++){
		sum += i;
	}
	out.println(sum);
	/*
	if(max != null){
		for(int i=pmin;i<=pmax;i++){
			sum += i;
			break;
		}
		out.println(sum);
	}
	*/
}

/*
if(max != null){
	pmin = Integer.parseInt(min);
	pmax = Integer.parseInt(max);
	for(int i=pmin;i<=pmax;i++){
		sum += i;
	}
	out.println(sum);
	
	if(min != null){
		for(int i=1;i<=pmax;i++){
			sum += i;
			break;
		}
		out.println(sum);
	}
	
}*/
%>

</body>
</html>