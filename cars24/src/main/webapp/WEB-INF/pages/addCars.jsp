<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib  uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cars24</title>
</head>
<body>
<jsp:include page="include.jsp"></jsp:include>
<form:form method="post" action="cars">
<form:label path="model">Model</form:label>
<form:input path="model"/>

<form:label path="year">Year of Manufacture</form:label>
<form:input path="year"/>

<form:label path="kilometers">Kilometers travelled</form:label>
<form:input path="kilometers"/>

<form:label path="brand">Brand</form:label>
<form:input path="brand"/>

<form:label path="status">Status </form:label>
	<form:select path="status" items="${status}"/>
<input type="submit" value="Add">

</form:form>
<p>Row Added</p><c:out value="${rowAdded}"></c:out>
</body>
</html>