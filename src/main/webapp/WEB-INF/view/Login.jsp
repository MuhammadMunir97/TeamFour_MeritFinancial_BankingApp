<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form:form action="/login" method="POST">
    <p>
	<label>UserName <input type="text" name="username"></label>
	</p>
	<p>
	<label>Password <input type="text" name="password"></label>
	</p>
    <input type="submit" value="Submit"/>
 </form:form>
 <a href="/create_account">Create Account</a>
</body>
</html>