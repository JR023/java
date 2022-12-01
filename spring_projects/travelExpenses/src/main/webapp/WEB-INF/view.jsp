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

<title>View</title>
</head>
<body class="bg-secondary">
	<div class="m-5 p-3 bg-dark w-75 rounded text-light">
	<div class="d-flex justify-content-between">
		<h1 class="text-info">Expense Details</h1>
		<a href="/expenses">Go Back</a>
	</div>
	<div class="d-flex">
		<div>
			<p>Expense Name:</p>
			<p>Expense Description:</p>
			<p>Vendor:</p>
			<p>Amount:</p>
		</div>
		<div class="m-3">
			<p><c:out value="${expense.name}"/></p>
			<p><c:out value="${expense.description}"/></p>
			<p><c:out value="${expense.vendor}"/></p>
			<p>$<c:out value="${expense.amount}"/></p>
		</div>
	</div>
	</div>
</body>
</html>