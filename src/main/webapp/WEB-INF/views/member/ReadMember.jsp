<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="../../../resources/CSS/memberCSS.css">
<script src="../../../resources/jquery/jquery-3.6.0.js"></script>
<title>회원 정보 보기</title>
</head>
<body>
<header><h1 class="main">그린 아카데미</h1></header>
<section>
	<h2>회원 정보 보기</h2>
	<table>
		<tr>
			<th colspan="2">🍀회원 번호 ${member.memberNum}🍀</th> 
		</tr>
		<tr>
			<th>회원 아이디</th>
			<td>${member.memberId}</td>
		</tr>
		<tr>
			<th>회원 이름</th>  
			<td>${member.memberName}</td>
		</tr>
		<tr>
			<th>이메일 </th>
			<td>${member.memberEmail}</td>
		</tr>
		<tr>
			<th>전화번호</th>
			<td>${member.memberPhone}</td>
		</tr>
		
	</table>





</section>
<footer><h2 class="main">Copyright(c)2022 그린 아카데미 All right Reseved</h2></footer>
</body>
</html>