<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!-- c:out ; c:forEach etc. --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>

<title>View Book</title>
</head>
<body>
	<div class="bg-dark text-light m-5 p-3 border border-dark">
		<div class="d-flex justify-content-between">
			<h1><c:out value="${book.title}"/></h1>
			<a href="/dashboard">Back to the Shelves</a>
		</div>
		<div class="d-flex flex-column">
			<h4><span class="text-info"><c:out value="${book.user.userName}"/></span> read <span class="text-danger"><c:out value="${book.title}"/></span> by <span class="text-success"><c:out value="${book.author}"/></span></h4>
			<h5>Here are <span class="text-info"><c:out value="${book.user.userName}"/>'s</span> thoughts:</h5>
			<p class="fst-italic"><c:out value="${book.thoughts}"/></p>
		</div>
	</div>
</body>
</html>