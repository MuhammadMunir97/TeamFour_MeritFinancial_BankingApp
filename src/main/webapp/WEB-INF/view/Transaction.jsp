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
<c:out value="${message}" />
<table>
    <thead>
        <tr>
            <th><h3>AccountNumber</h3></th>
            <th><h3>Present Balance</h3></th>
            <th><h3>Account Type</h3></th>
        </tr>
    </thead>
    <tbody>
       <tr>
       	<td><c:out value="${account.accountNumber}"/></td>
       	<td><c:out value="${account.presentBalance}"/></td>
       	<td><c:out value="${account.accountType.accTypeName}"/></td>
       </tr>
    </tbody>
</table>
<h1>Transactions</h1>
<table>
    <thead>
        <tr>
            <th><h3>TransactionType</h3></th>
            <th><h3>Amount</h3></th>
            <th><h3>Date</h3></th>
        </tr>
    </thead>
    <tbody>
	    <c:forEach items="${account.transactionLogs}" var="transaction">
			<tr>
				<td><c:out value="${transaction.transactionType.transactionTypeName}"/></td>
				<td><c:out value="${transaction.amount}"/></td>
				<td><c:out value="${transaction.postDate}"/></td>
			</tr>
		</c:forEach>
    </tbody>
</table>
<br><br><br><br>
<form:form action="/accounts/${account.id}" method="POST" modelAttribute="tranasction">
	<p>
        <form:label path="amount">amount</form:label>
        <form:errors path="amount"/>
        <form:input path="amount"/>
    </p>
	<form:select  path="transactionType">
		<c:forEach items="${transactionTypes}" var="type">
			 <form:option value="${type.id}">
			 	${type.transactionTypeName}
			 </form:option>
    	</c:forEach>
	</form:select>
	<p>
        <form:label path="AccountInternalTransferTo">AccountInternalTransferTo</form:label>
        <form:errors path="AccountInternalTransferTo"/>
        <form:input path="AccountInternalTransferTo"/>
    </p>
    <input type="submit" value="Submit"/>
</form:form>
</body>
</html>