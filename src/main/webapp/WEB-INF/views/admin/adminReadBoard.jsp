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
<script src="../../../resources/jquery/jquery-3.6.0.js"></script>
<title>Insert title here</title>
</head>
<body>
<header><h1 class="main">그린 아카데미</h1></header>
<section> 
	<h2>🙋${authInfo.memberName}님 어서오세요!🙋‍♂️</h2>
			<p><a href="<c:url value='/logout' />">[로그아웃]</a></p>
			<h2>관리자 페이지 - 게시물 관리</h2>
	<form action="/editPost/${qnaBoardNum}" method="POST">
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
			<td colspan="2" class="content">${board.qnaBoardContent}</td>
		</tr>
	</table>
	
		<input type="hidden" name="qnaBoardNum" id="qnaBoardNum" value="${board.qnaBoardNum}">
		<input type="button" value="게시글삭제" onclick="location.href='/admin/adminDeletePost/${qnaBoardNum}'" class="btn">
		<input type="button" value="목록으로" onclick="location.href='/adminmain/admin/adminBoard'" class="btn">
	</form>
		
	<form action="/updateComment/${board.qnaBoardNum}.qnaBoardNum}" method="POST">	
		<table class="comment">
			<tr>
				<th> 답변 </th>
				<th> 작성일</th>
			</tr>
			<tr>
					<td><textarea rows="5" cols="30" name="commentContent" id="commentContent" class="focused-input" readonly>${comment.commentContent}</textarea></td>
					<td>${comment.commentRegdate}</td>
					<td><input type="hidden" id="commentNum" name="commentNum" value="${comment.commentNum }">
			
			</tr>
		</table>
			<input type="button" value="답글작성하기" id="mentbtn" name="mentbtn" onclick="updateComment()" class="btn">
			<input type="hidden" value="작성완료" id="submitment" name="submitment" value="submitmentment" onclick="location.href='/updateComment/${qnaBoardNum}'" class="btn">
			<input type="button" value="답글삭제" onclick="location.href='/admin/adminDeleteComment/${qnaBoardNum}'" class="btn">
		
		</form>
</section>
<script>
	function updateComment(){
		
		$('#commentContent').attr('readonly',false);
		$('.focused-input').focus();
		$('#mentbtn').attr('type','hidden');
		$('#submitment').attr('type','submit');
	}
</script>
<footer><h2 class="main">Copyright(c)2022 그린 아카데미 All right Reseved</h2></footer>
</body>
</html>