<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 폼</title>
</head>
<body>
<h3>회원가입</h3>
<!-- form action은 클라이언트가 보는 제출 페이지
	 항목 작성하고 입력했을 때 처리해 줄 주소 
	 get 방식은 method="get" 안써줘도 기본으로 get-->
<form action="result.jsp" method="post">
	이름 : <input type="text" name="name" value="" placeholder="이름을 입력"><br />
	생년월일 : <input type="date" name="birth" value="" placeholder="생년월일 입력"><br />
	취미 : <br />
	<input type="checkbox" name="hobby" value="축구" >
	<input type="checkbox" name="hobby" value="야구" >
	<input type="checkbox" name="hobby" value="농구" placeholder="농구">
	<input type="checkbox" name="hobby" value="배구" title="배구">
	<br />
	성별 : <br />
	<input type="radio" name="gender" value="M" title="남자">
	<input type="radio" name="gender" value="W" title="여자">
	<br />
	지역 : <select name="address">
			<option value="">지역을 선택</option>
			<option value="서울">서울</option>
			<option value="대전">대전</option>
			<option value="경기">경기</option>
			<option value="기타">기타등등</option>
	</select><br />
	<input type="submit">
</form>
</body>
</html>