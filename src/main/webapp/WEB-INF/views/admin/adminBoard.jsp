<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="../../../resources/CSS/boardCSS.css">
<title>관리자 - 게시글 관리</title>
</head>
<body>
<header><h1 class="main">그린 아카데미</h1></header>
<section>
<h2>🙋${authInfo.memberName}님 어서오세요!🙋‍♂️</h2>
<p><a href="<c:url value='/logout' />">[로그아웃]</a></p>
	<h2>관리자 페이지 - 게시물 관리</h2>
	
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
					<td><a href="<c:url value='/admin/adminReadBoard/${board.qnaBoardNum}'/>">${board.qnaBoardTitle}
					<c:forEach var="comment" items="${comment}" varStatus="c">
						<c:if test="${comment.qnaBoardNum == board.qnaBoardNum}"> 🆗 </c:if>
					</c:forEach>	
	
					</a></td>
				
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