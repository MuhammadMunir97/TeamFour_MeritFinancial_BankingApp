<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create Bank Account</title>
</head>
<body>
<form:form action="/newBankAccount" method="POST" modelAttribute="accountInternal">
	<form:select  path="accountType">
		<c:forEach items="${account_types}" var="type">
			 <form:option value="${type.id}">
			 	${type.accTypeName}
			 </form:option>
    	</c:forEach>
	</form:select>
    <input type="submit" value="Submit"/>
</form:form>
</body>
</html>