<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    <%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create Account</title>
	<link rel="stylesheet" type="text/css" href='CSS/box-styles.css'>
  	<link rel='stylesheet' type="text/css" href='CSS/header-styles.css'/>
	<link rel='stylesheet' type="text/css" href='CSS/main-styles.css'/>
	<link rel='stylesheet' type="text/css" href='CSS/footer-styles.css'/>
</head>
<body>
<form:form action="/create_account" method="POST" modelAttribute="user">
		<form:label path="firstName">First Name</form:label>
		<form:errors path="firstName"/>
		<form:input path="firstName"/><span class="req">*</span>
    <p>
        <form:label path="lastName">Last Name</form:label>
        <form:errors path="lastName"/>
        <form:input path="lastName"/>
    </p>
    <p>
        <form:label path="email">Email</form:label>
        <form:errors path="email"/>
        <form:input path="email"/>
    </p>
    <p>
        <form:label path="userName">User Name</form:label>
        <form:errors path="userName"/>
        <form:input path="userName"/>
    </p>
    <p>
        <form:label path="password">Password</form:label>
        <form:errors path="password"/>
        <form:password path="password"/>
    </p>
    <p>
        <form:label path="dateOfBirth">dateOfBirth</form:label>
        <form:errors path="dateOfBirth"/>
        <form:input path="dateOfBirth"/>
    </p>
    <p>
        <form:label path="ssn">Social Security Number</form:label>
        <form:errors path="ssn"/>
        <form:input path="ssn"/>
    </p>
    <p>
        <form:label path="primaryPhone">Primary Phone</form:label>
        <form:errors path="primaryPhone"/>
        <form:input path="primaryPhone"/>
    </p>
    <p>
        <form:label path="secondaryPhone">Secondary Phone</form:label>
        <form:errors path="secondaryPhone"/>
        <form:input path="secondaryPhone"/>
    </p>
    <input type="submit" value="Submit"/>
 </form:form>
</body>
</html>