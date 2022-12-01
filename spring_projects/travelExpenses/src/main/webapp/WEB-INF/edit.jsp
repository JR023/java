<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>  

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  

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

<title>Edit</title>
</head>
<body class="bg-secondary">
	<div class="m-5 p-3 bg-dark w-75 rounded text-light">
	<div class="d-flex justify-content-between">
		<h1>Edit Expense</h1>
		<a href="/expenses">Go Back</a>
	</div>
	<form:form class="d-flex flex-column align-items-center" action="/expenses/edit/${id}" method="POST" modelAttribute="expense">
    	<input type="hidden" name="_method" value="put">
			<div class="d-flex flex-column w-50">
				<form:label path="name">Expense Name:</form:label>
				<form:errors path="name" class="text-danger"/>
				<form:input path="name"/>
			</div>
			<div class="d-flex flex-column w-50">
				<form:label path="vendor">Vendor:</form:label>
				<form:errors path="vendor" class="text-danger"/>
				<form:input path="vendor"/>
			</div>
			<div class="d-flex flex-column w-50">
				<form:label path="amount">Amount:</form:label>
				<form:errors path="amount" class="text-danger"/>
				<form:input type="number" step="any" min="0" path="amount"/>
			</div>
			<div class="d-flex flex-column w-50">
				<form:label path="description">Description:</form:label>
				<form:errors path="description" class="text-danger"/>
				<form:textarea path="description" rows="2" cols="50"></form:textarea>
			</div>
			<button class="btn btn-info mt-2" type="submit">Submit</button>
	</form:form>
	</div>
</body>
</html>