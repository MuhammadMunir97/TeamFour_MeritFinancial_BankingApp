<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    <%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Address</title>
</head>
<body>
<form:form action="/addAddress" method="POST" modelAttribute="address">
 	<p>
        <form:label path="street">street</form:label>
        <form:errors path="street"/>
        <form:input path="street"/>
    </p>
    <p>
        <form:label path="street2">street2</form:label>
        <form:errors path="street2"/>
        <form:input path="street2"/>
    </p>
    <p>
        <form:label path="state">state</form:label>
        <form:errors path="state"/>
        <form:input path="state"/>
    </p>
    <p>
        <form:label path="zipcode">zipcode</form:label>
        <form:errors path="zipcode"/>
        <form:input path="zipcode"/>
    </p>
    <form:select  path="addressType">
			<c:forEach items="${addressTypes}" var="type">
				 <form:option value="${type.id}">
				 	${type.businessTypeName}
				 </form:option>
	    	</c:forEach>
	</form:select>
 <input type="submit" value="Submit"/>
 </form:form>
</body>
</html>