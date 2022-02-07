<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../../../resources/CSS/adminmain.css">
</head>
<body><header><h1 class="main">그린 아카데미</h1></header>
<section>
<h2>🙋${authInfo.memberName}님 어서오세요!🙋‍♂️</h2>
<p><a href="<c:url value='/logout' />">[로그아웃]</a></p>


<div class="wrap">
	<div class="first">
		<a href="<c:url value='/adminmain/admin/memberlist' />"><strong>회원관리</strong></a>
	</div>
	<div class="second">
		<a href="<c:url value='/member/ReadMember/${authInfo.memberName}' />"><strong>게시물 관리</strong></a>
	</div>


</div>





</section>
<footer><h2 class="main">Copyright(c)2022 그린 아카데미 All right Reseved</h2></footer>
</body>
</html>