<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="../../../resources/CSS/memberlist.css">
<title>Insert title here</title>
</head>
<body>
<header><h1 class="main">그린 아카데미</h1></header>
<section>
<h2>🙋${authInfo.memberName}님 어서오세요!🙋‍♂️</h2>
<p><a href="<c:url value='/logout' />">[로그아웃]</a></p>
	<h1>관리자 페이지 - 회원 관리</h1>
		<table>
			<tr>
				<th>번호</th>
				<th>아이디</th>
				<th>이름</th>
				<th>수정</th>
				<th>삭제</th>
			</tr>
			<c:forEach var="member" items="${Member}" varStatus="m">
				<tr>
					<td>${member.memberNum}</td>
					<td>${member.memberId}</td>
					<td>${member.memberName}</td>
					<td>
					<input type="hidden" value="${member.memberNum}">
					<input type="button" value="수정" class="button_base b_butoon first" onclick="location.href='/admin/editadmin/${member.memberNum}'"></td>
				<c:if test="${member.memberName != authInfo.memberName}">
					<td><input type="button" value="삭제" class="button_base b1_butoon first" onclick="location.href='/admin/deleteMember/${member.memberNum}'"></td>
				</c:if>
				<c:if test="${member.memberName == authInfo.memberName}">
					<td><input type="hidden" value="memberNum"></td>
				</c:if>
				</tr>
			</c:forEach>
		</table>
		<br>
		
			<a href="<c:url value='/adminmain' />">[첫 화면으로]</a>
	
		
</section>
<footer><h2 class="main">Copyright(c)2022 그린 아카데미 All right Reseved</h2></footer>
</body>
</html>