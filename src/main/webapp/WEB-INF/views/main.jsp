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
<section> 
<a href="<c:url value='/login/loginForm' />">[로그인]</a>
<a href="<c:url value='/member/join' />">[회원가입]</a>
	<h1>QnA 게시판</h1>
		<table>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일</th>
				<th>조회수</th>
			</tr>
			<c:forEach var="board" items="${Board}" varStatus="b">
				<tr>
					<td>${board.qnaBoardNum}</td>
					<td>${board.qnaBoardTitle}</td>
					<td>${board.memberName}</td>
					<td>${board.qnaBoardRegdate}</td>
					<td>${board.qnaBoardCount}</td>
				</tr>
			</c:forEach>
		</table>
	

</section>
<footer><h2 class="main">Copyright(c)2022 그린 아카데미 All right Reseved</h2></footer>
</body>
</html>