<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="../../../resources/CSS/joinCSS.css">
<title>회원 가입</title>
</head>
<body>
<header><h1 class="main">그린 아카데미</h1></header>
<section>
<form action="joining" method="POST">
	<table>
	<tr>
		<th>이메일</th>
			<td><input type="email" name="memberEmail" id="memberEmail" required></td>
	</tr>
	<tr>
		<th>아이디</th>
			<td><input type="text" name="memberId" id="memberId" value="${formData.name}" required></td>
	</tr>
	<tr>
		<th>이름</th>
			<td><input type="text" name="memberName" id="memberName" required></td>
	</tr>
	<tr>
		<th>비밀번호</th>
			<td><input type="password" name="memberPassword" id="memberPassword" required></td>
	</tr>
	<tr>
		<th>비밀번호 확인</th>
			<td><input type="password" name="rePassword" id="rePassword" required></td>
	</tr>
	<tr>
		<th>전화번호</th>
			<td><input type="tel" name="memberPhone" id="memberPhone" required></td>
	</tr>
	<tr><th colspan="2">
	<input type="submit" value="가입 완료">
	<input type="button" value="돌아가기" onclick="location.href='/'"></th></tr>
	</table>
</form>
</section>
<footer><h2 class="main">Copyright(c)2022 그린 아카데미 All right Reseved</h2></footer>

</body>
</html>
