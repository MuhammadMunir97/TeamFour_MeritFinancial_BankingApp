<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create Account</title>
</head>
<body>
<form:form action="/create_account" method="POST" modelAttribute="user">
	<p>
        <form:label path="firstName">First Name</form:label>
        <form:errors path="firstName"/>
        <form:textarea path="firstName"/>
    </p>
    <p>
        <form:label path="lastName">Last Name</form:label>
        <form:errors path="lastName"/>
        <form:textarea path="lastName"/>
    </p>
    <p>
        <form:label path="email">Email</form:label>
        <form:errors path="email"/>
        <form:textarea path="email"/>
    </p>
    <p>
        <form:label path="userName">User Name</form:label>
        <form:errors path="userName"/>
        <form:textarea path="userName"/>
    </p>
    <p>
        <form:label path="password">Password</form:label>
        <form:errors path="password"/>
        <form:textarea path="password"/>
    </p>
    <p>
        <form:label path="dateOfBirth">dateOfBirth</form:label>
        <form:errors path="dateOfBirth"/>
        <form:textarea path="dateOfBirth"/>
    </p>
    <p>
        <form:label path="ssn">Social Security Number</form:label>
        <form:errors path="ssn"/>
        <form:textarea path="ssn"/>
    </p>
    <p>
        <form:label path="primaryPhone">Primary Phone</form:label>
        <form:errors path="primaryPhone"/>
        <form:textarea path="primaryPhone"/>
    </p>
    <p>
        <form:label path="secondaryPhone">Secondary Phone</form:label>
        <form:errors path="secondaryPhone"/>
        <form:textarea path="secondaryPhone"/>
    </p>
    <input type="submit" value="Submit"/>
 </form:form>
</body>
</html>