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
<form:form action="joining" commandName="formData">
	<table>
		<tr>
			<th> 아이디 </th>
				<td> <form:input path="memberId"/><br>
				<form:errors path="memberId"/><!--  에러가 없다면 출력이 안됨 / 에러코드가 있다면 에러코드에 해당하는 라벨을 출력 -->
			</td>
		</tr>
		<tr> 
			<th> 비밀번호 </th>		
				<td> <form:password path="memberPassword"/><br>
				<form:errors path="memberPassword"/> </td>
		</tr>
		<tr>
			<th> 비밀번호 확인  </th>
				<td> <form:password path="rePassword"/><br>
				<form:errors path="rePassword"/> </td>
		</tr>
		<tr>
			<th> 이름  </th>
				<td> <form:input path="memberName"/><br>
				<form:errors path="memberName"/> </td>
		<tr>
		<tr>
			<th> 이메일  </th>
				<td> <form:input path="memberEmail"/><br>
				<form:errors path="memberEmail"/> </td>
		<tr>
		<tr>
			<th> 전화번호  </th>
				<td> <form:input path="memberPhone"/><br>
				<form:errors path="memberPhone"/> </td>
		<tr>

	<tr><th colspan="2">
	<input type="submit" value="가입 완료" class="button_base b_butoon first">
	<input type="button" value="돌아가기" class="button_base b_butoon first" onclick="location.href='/'"></th></tr>
	</table>
</form:form>
</section>
<footer><h2 class="main">Copyright(c)2022 그린 아카데미 All right Reseved</h2></footer>

</body>
</html>
