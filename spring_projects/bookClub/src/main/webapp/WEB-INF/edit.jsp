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

<title>Edit Book</title>
</head>
<body class="bg-secondary">
	<div class="bg-dark text-light m-5 p-3 border border-dark w-75">
		<div class="d-flex justify-content-between">
			<h1 class="text-info">Change Your Entry</h1>
			<a href="/dashboard">Back to the Shelves</a>
		</div>
		<form:form action="/dashboard/edit/${book.id}" method="POST" modelAttribute="book">
    		<input type="hidden" name="_method" value="put">
    		<form:input type="hidden" name="user" path="user"/>
    		<form:input type="hidden" name="borrower" path="borrower"/>
				<div class="p-2 d-flex flex-column justify-content-between">
					<form:label path="title">Title</form:label>
					<form:errors path="title" class="text-danger"/>
					<form:input path="title"/>
				</div>
				<div class="p-2 d-flex flex-column justify-content-between">
					<form:label path="author">Author</form:label>
					<form:errors path="author" class="text-danger"/>
					<form:input path="author"/>
				</div>
				<div class="p-2 d-flex flex-column justify-content-between">
					<form:label path="thoughts">My Thoughts</form:label>
					<form:errors path="thoughts" class="text-danger"/>
					<form:textarea path="thoughts" rows="2" cols="50"></form:textarea>
				</div> 
    		<button class="btn btn-info w-25 align-self-end" type="submit">Submit</button>
		</form:form>
		<a href="/dashboard/delete/${book.id}">Delete</a>
	</div>
</body>
</html>