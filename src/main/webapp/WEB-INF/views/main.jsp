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
	<c:if test="${empty authInfo}">
		<a href="<c:url value='/login/loginForm' />">[로그인]</a>
		<a href="<c:url value='/member/join' />">[회원가입]</a>
	</c:if>

	<c:if test="${!empty authInfo}">
		<h2>💗${authInfo.memberName}님 반갑습니다💗</h2>
		<a href="<c:url value='/member/ReadMember/${authInfo.memberName}' />">[정보보기]</a>
		<a href="<c:url value='/logout' />">[로그아웃]</a>
	</c:if>


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
					<td><a href="<c:url value='/board/ReadBoard/${board.qnaBoardNum}'/>">${board.qnaBoardTitle}</a></td>
					<td>${board.memberName}</td>
					<td>${board.qnaBoardRegdate}</td>
					<td>${board.qnaBoardCount}</td>
				</tr>
			</c:forEach>
		</table>
		
		<c:if test="${!empty authInfo}">

		<a href="<c:url value='/board/WriteBoard/' />">[글작성]</a>

		</c:if>
		

</section>
<footer><h2 class="main">Copyright(c)2022 그린 아카데미 All right Reseved</h2></footer>
</body>
</html>