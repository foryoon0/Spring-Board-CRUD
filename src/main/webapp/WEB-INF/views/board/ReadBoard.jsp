<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="../../../resources/CSS/detailCSS.css">
<title>Insert title here</title>
</head>
<body>
<header><h1 class="main">그린 아카데미</h1></header>
<section> 
	<c:if test="${empty authInfo}">
		<a href="<c:url value='/login/loginForm' />">[로그인]</a>
		<a href="<c:url value='/member/join' />">[회원가입]</a>
	</c:if>

	<c:if test="${!empty authInfo}">
		<h2>💗${authInfo.memberName}님 반갑습니다💗</h2>
		<a href="<c:url value='/board/ReadBoard' />">[정보보기]</a>
		<a href="<c:url value='/logout' />">[로그아웃]</a>
	</c:if>
	<h2>QnA 게시판</h2>
	<table>
		<tr>
			<th>제목</th> 
			<td>${board.qnaBoardTitle}</td>
		</tr>
		<tr>
			<th>작성일</th>
			<td>${board.qnaBoardRegdate}</td>
		</tr>
		<tr>
			<th>작성자</th>  
			<td>${board.memberName}</td>
		</tr>
		<tr>
			<th>조회수</th>
			<td>${board.qnaBoardCount}</td>
		</tr>
		<tr>
			<td colspan="2"><textarea rows="5" cols="30">${board.qnaBoardContent}</textarea></td>
		</tr>
	</table>
	<c:if test="${!empty authInfo}">
		<a href="<c:url value='/board/ReadBoard' />">[수정]</a>
		<a href="<c:url value='/logout' />">[삭제]</a>
	</c:if>
</section>
<footer><h2 class="main">Copyright(c)2022 그린 아카데미 All right Reseved</h2></footer>
</body>
</html>