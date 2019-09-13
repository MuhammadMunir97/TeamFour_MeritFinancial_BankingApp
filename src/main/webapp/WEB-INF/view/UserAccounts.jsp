<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>All accounts</title>
<link rel='stylesheet' href='CSS/Transaction.css' />

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
<h1>Create Account</h1>
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
<a href="/newBankAccount">Create New Account</a>
</body>
</html>