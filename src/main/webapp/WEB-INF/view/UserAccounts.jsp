<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>All accounts</title>
</head>
<body>
${error}
<table>
    <thead>
        <tr>
            <th><h3>AccountNumber</h3></th>
            <th><h3>Present Balance</h3></th>
            <th><h3>Account Type</h3></th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${allAccounts}" var="account">
        <tr>
        	<td> <a href="accounts/${account.id}"><c:out value="${account.accountNumber}"/></a></td>
        	<td><c:out value="${account.presentBalance}"/></td>
        	<td><c:out value="${account.accountType.accTypeName}"/></td>
        </tr>
        </c:forEach>
    </tbody>
</table>
<a href="/newBankAccount">Create New Account</a>
</body>
</html>