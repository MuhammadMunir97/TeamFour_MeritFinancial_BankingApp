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
<table>
    <thead>
        <tr>
            <th><h3>First Name</h3></th>
            <th><h3>Last Name</h3></th>
            <th><h3>email</h3></th>
            <th><h3>DOB</h3></th>
            <th><h3>ssn</h3></th>
            <th><h3>primary phone</h3></th>
            <th><h3>secondary phone</h3></th>
        </tr>
    </thead>
    <tbody>
        <tr>
        	<td>${user.firstName}</td>
        	<td>${user.lastName}</td>
        	<td>${user.email}</td>
        	<td>${user.dateOfBirth}</td>
            <td>${user.ssn}</td>
            <td>${user.primaryPhone}</td>
            <td>${user.secondaryPhone}</td>
        </tr>
    </tbody>
</table>
</body>
</html>