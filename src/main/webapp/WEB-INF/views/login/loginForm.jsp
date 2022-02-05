<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
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
	<form action="" method="POST">
	<table>
		<tr>
			<th>아이디</th>
				<td><input type="text" id="memberId" name="memberId"></td>
		</tr>
		<tr>
			<th>비밀번호</th>
				<td><input type="password" id="memberPassword" name="memberPassword"></td>
		</tr>
	</table>
	<input type="submit" value="로그인" class=btn>
	<input type="button" value="회원가입" class=btn onclick="location.href='/member/join '">
	</form>	
</section>
<footer><h2 class="main">Copyright(c)2022 그린 아카데미 All right Reseved</h2></footer>

</body>
</html>