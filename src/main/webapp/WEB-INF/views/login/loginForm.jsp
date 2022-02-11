<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="../../../resources/CSS/loginCSS.css">
<title>로그인</title>
</head>
<body>
<header><h1 class="main">그린 아카데미</h1></header>
<section> 
	<form:form commandName="loginCommand">
		<table>
			<tr> <th>아이디</th>  
				<td><form:input path="memberId"/>
				<form:errors path="memberId"/></td>
			</tr>
			<tr><th>비밀번호</th>
				<td><form:password path="memberPassword"/>
				<form:errors path="memberPassword" htmlEscape="false"/></td>
		</table>

		<input type="submit" value="로그인" class="button_base b_butoon first"> 
		<input type="button" value="회원가입" class="button_base b_butoon first" onclick="location.href='/member/join '">
	</form:form>

</section>
<footer><h2 class="main">Copyright(c)2022 그린 아카데미 All right Reseved</h2></footer>

</body>
</html>