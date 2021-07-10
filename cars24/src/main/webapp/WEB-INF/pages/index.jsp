<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<style>
	a {
		text-align:center;
		color:blue;
		font-size: 22px;
	}
</style>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1 style="text-align:center; color:red;"><c:out value="${heading}"></c:out></h1>
<a href="cars">Add Cars</a> <br>
<a href="cars/all">View Cars</a> <br>
<a href="cars/unsold">View Unsold Cars</a> <br>
<a href="cars/showByBrand">View Cars By Brand</a>
</body>
</html>