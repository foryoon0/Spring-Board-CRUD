<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="../../../resources/CSS/memberCSS.css">
<script src="../../../resources/jquery/jquery-3.6.0.js"></script>
<title>관리자페이지 - 회원 관리</title>
</head>
<body>
<header><h1 class="main">그린 아카데미</h1></header>
<section>
	<h2>회원 정보 보기</h2>
	
	<form action="/editMember/${member.memberNum}" method="POST">
	<table>
		<tr>
			<th colspan="2">📝회원 번호 ${member.memberNum}📝</th> 
		</tr>
		<tr>
			<th>회원 아이디</th>
			<c:if test="${member.memberName == authInfo.memberName}">
				<td><input type="hidden" id="memberId" name="memberId" value="${member.memberId}">${member.memberId}</td>
			</c:if>
			<c:if test="${member.memberName != authInfo.memberName}">
				<td><input type="text" id="memberId" name="memberId" value="${member.memberId}" class="focused-input" readonly ></td>
			</c:if>
		</tr>

		<tr>
			<th>회원 이름</th>  
			<td><input type="text" id="memberName" name="memberName" value="${member.memberName}" readonly ></td>
		</tr>
		<tr>
			<th>이메일 </th>
			<td><input type="text" id="memberEmail" name="memberEmail" value="${member.memberEmail}" readonly ></td>
		</tr>
		<tr>
			<th>전화번호</th>
			<td><input type="text" id="memberPhone" name="memberPhone" value="${member.memberPhone}" readonly ></td>
		</tr>
		
	</table>
		<input type="button" id="updatebtn" name="updatebtn" value="수정하기" class="btn" onclick="updateMember()">
		<input type="hidden" id="updateToController" name="updateToController" value="수정완료" class="btn">
		<input type="button" value="목록으로" onclick="location.href='/adminmain/admin/memberlist'" class="btn">
</form>
</section>
<script>
	function updateMember(){
		
		$('#memberId').attr('readonly',false);
		$('#memberName').attr('readonly',false);
		$('#memberEmail').attr('readonly',false);
		$('#memberPhone').attr('readonly',false);
		$('.focused-input').focus();
		$('#updatebtn').attr('type','hidden');
		$('#updateToController').attr('type','submit');
	}
</script>
<footer><h2 class="main">Copyright(c)2022 그린 아카데미 All right Reseved</h2></footer>
</body>
</html>