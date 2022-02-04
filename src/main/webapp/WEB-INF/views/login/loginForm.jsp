<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><spring:message code="login.title"/></title>
</head>
<body>
	<form:form commandName="loginCommand">
		<form:errors /><!--  글로벌 에러코드가 작성되는 부분 -->
		<p>
			<label> <spring:message code="email"/> : <br>
				<form:input path="email"/>
				<form:errors path="email"/>
			</label>
		</p>
		<p>
			<label> <spring:message code="password"/> : <br>
				<form:password path="password"/>
				<form:errors path="password" htmlEscape="false"/>
			</label>
		</p>
		<p>
			<label>
				<spring:message code="rememberEmail"/> : 
					<form:checkbox path="rememberEmail"/>
			</label>
		</p>
		<input type="submit" value="<spring:message code="login.btn"/>">
	</form:form>
</body>
</html>