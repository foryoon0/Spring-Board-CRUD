<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="./resources/CSS/boardCSS.css">
</head>
<body>
<header><h1 class="main">그린 아카데미</h1></header>
<p><a href="<c:url value='/login/loginForm' />">[로그인]</a></p>
<p><a href="<c:url value='/member/join' />">[회원가입]</a></p>
<section> 
	<h1>QnA 게시판</h1>
	<c:if test="${!empty board}">
		<table border=1>
			<tr>
				<th>아이디</th>
				<th>이메일</th>
				<th>이름</th>
			</tr>
			<c:forEach var="board" items="${board}" varStatus="b">
				<tr>
					<td>${b.count}</td>
					<td>${board.qnaBoardTitle}</td>
					<td>${board.memberName}</td>
					<td>${board.qnaBoardRegdate}</td>
					<td>${board.qnaBoardCount}</td>
				</tr>
			</c:forEach>
		</table>
	
	</c:if>
	
	
	

</section>
<footer><h1 class="main">Copyright(c)2022 그린 아카데미 All right Reseved</h1></footer>
</body>
</html>