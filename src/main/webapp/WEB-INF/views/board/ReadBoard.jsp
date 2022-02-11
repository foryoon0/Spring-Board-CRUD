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
	<c:if test="${empty authInfo}">
		<a href="<c:url value='/login/loginForm' />">[로그인]</a>
		<a href="<c:url value='/member/join' />">[회원가입]</a>
	</c:if>

	<c:if test="${!empty authInfo}">
		<h2>💗${authInfo.memberName}님 반갑습니다💗</h2>
		<a href="<c:url value='/member/ReadMember/${authInfo.memberName}'/>">[정보보기]</a>
		<a href="<c:url value='/logout' />">[로그아웃]</a>
	</c:if>
	<h2>QnA 게시판</h2>
	<form action="/editPost/${qnaBoardNum}" method="POST">
	<table>
		<tr>
			<th>제목</th> 
				<td><textarea rows="1" cols="10"  id="qnaBoardTitle" name="qnaBoardTitle" readonly class="focused-input">${board.qnaBoardTitle}</textarea></td>
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
			<td colspan="2"><textarea rows="5" cols="30" id="qnaBoardContent" name="qnaBoardContent" readonly>${board.qnaBoardContent}</textarea></td>

		</tr>
	</table>
	
		<input type="hidden" name="qnaBoardNum" id="qnaBoardNum" value="${board.qnaBoardNum}">
	<c:if test="${board.memberName == authInfo.memberName}">
		<input type="button"  id="updatebtn" name="updatebtn" value="수정" class="btn" onclick="updateMember()">
		<input type="hidden" id="updateToController" name="updateToController" value="수정완료" class="btn">
		<input type="button" value="삭제" onclick="deleteConfirm()" class="btn">
		<input type="button" value="목록으로" onclick="location.href='/'" class="btn">
	</c:if>
	<c:if test="${board.memberName != authInfo.memberName}">
		<input type="button" value="목록으로" onclick="location.href='/'" class="btn">
	</c:if>
	</form>
			
		<table class="comment">
			<tr>
				<th> 답변 </th>
				<th> 작성일</th>
			</tr>
			<tr>
					<td>${comment.commentContent}</td>
					<td>${comment.commentRegdate}</td>
			</tr>
		</table>
</section>
<script>
	function updateMember(){
		
		$('#qnaBoardTitle').attr('readonly',false);
		$('#qnaBoardContent').attr('readonly',false);
		$('.focused-input').focus();

		$('#updatebtn').attr('type','hidden');
		$('#updateToController').attr('type','submit');
	}
	
	function deleteConfirm(){
		
		if(!confirm("삭제 하시겠습니까?")){
			return false;
		}else{
			location.href='/board/deletePost/${qnaBoardNum}';
		}
	}

</script>

<footer><h2 class="main">Copyright(c)2022 그린 아카데미 All right Reseved</h2></footer>
</body>
</html>