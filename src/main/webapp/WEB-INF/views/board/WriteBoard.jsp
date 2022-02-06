<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="../../../resources/CSS/boardWriteCSS.css">
<title>Insert title here</title>
</head>
<body>
<header><h1 class="main">그린 아카데미</h1></header>
	<section>

	<c:if test="${!empty authInfo}">
		<h2>💗${authInfo.memberName}님 반갑습니다💗</h2>
		<a href="<c:url value='/member/ReadMember/${authInfo.memberName}' />">[정보보기]</a>
		<a href="<c:url value='/logout' />">[로그아웃]</a>
	</c:if>
	
		<form action="writing" method="POST">
			<table>
				<tr>
					<th>제목</th>
					<td><input type="text" name="qnaBoardTitle" id="qnaBoardTitle"
						required></td>
				</tr>
				<tr>
					<td colspan="2"><textarea rows="5" cols="30"
							placeholder="글 내용을 입력하세요"></textarea></td>
				</tr>
			</table>

			<input type="submit" value="질문 작성" class="btn"> 
			<input type="button" value="목록보기" class="btn" onclick="location.href='/'">
		</form>


	</section>
	<footer>
		<h2 class="main">Copyright(c)2022 그린 아카데미 All right Reseved</h2>
	</footer>
</body>
</html>