<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
      <%@ taglib  uri="http://www.springframework.org/tags/form" prefix="form"%>
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
<title>Cars24</title>
</head>
<body>
<h1 style="text-align:center; color:red;"><c:out value="${heading}"></c:out></h1>
<h2 style="text-align:center;">The best website to sell and buy a new car</h2>
<h3><a href="/">Home</a></h3>
</body>
</html>