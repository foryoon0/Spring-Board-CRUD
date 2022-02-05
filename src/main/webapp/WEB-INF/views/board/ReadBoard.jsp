<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./resources/CSS/detailCSS.css">
<title>Insert title here</title>
</head>
<body>
<header><h1 class="main">그린 아카데미</h1></header>
<section> 
<a href="<c:url value='/login/loginForm' />">[로그인]</a>
<a href="<c:url value='/member/join' />">[회원가입]</a>
	<h2>QnA 게시판</h2>
	<table>
		<tr>
			<td>제목 : <input type="text" value="${board.qnaBoardTitle}"></td>
		</tr>
		<tr>
			<td>작성일 : <input type="text" value="${board.qnaBoardRegdate}"></td>
		</tr>
		<tr>
			<td>작성자 : <input type="text" value="${board.memberName}"></td>
		</tr>
		<tr>
			<td>조회수 : <input type="text" value="${board.qnaBoardCount}"></td>
		</tr>
		<tr>
			<td><textarea rows="5" cols="30">${board.qnaBoardContent}</textarea></td>
		</tr>
	</table>
</section>
<footer><h2 class="main">Copyright(c)2022 그린 아카데미 All right Reseved</h2></footer>
</body>
</html>