<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="registComp" method="POST">
	<p>
		<label>이메일:<br>
			<input type="email" name="useremail" id="useremail">
		</label>
	</p>
	<p>
		<label>아이디:<br>
			<input type="text" name="userid" id="userid" value="${formData.name}">
		</label>
	</p>
	<p>
		<label>이름:<br>
			<input type="text" name="username" id="username">
		</label>
	</p>
	<p>
		<label>비밀번호:<br>
			<input type="password" name="userpassword" id="userpassword">
		</label>
	</p>
	<p>
		<label>비밀번호 확인:<br>
			<input type="password" name="userconfirmPassword" id="userconfirmPassword">
		</label>
	</p>
	<p>
		<label>전화번호:<br>
			<input type="tel" name="userphone" id="userphone">
		</label>
	</p>
	<input type="submit" value="가입 완료">
</form>
</body>
</html>
