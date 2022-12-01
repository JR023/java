<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

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

<title>Travels</title>
</head>
<body>
	<div class="m-5 p-3 bg-dark text-light w-75 rounded">
		<h1>Save Travels</h1>
		<div class="bg-dark"> 
			<table class="table table-hover table-dark">
				<thead>
					<tr>
						<th scope="col">Expense</th>
						<th scope="col">Vendor</th>
						<th scope="col">Amount</th>
						<th scope="col" colspan="2">Actions</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach var="oneExpense" items="${expenses}">
					<tr>
						<td><a href="/expenses/${oneExpense.id}"><c:out value="${oneExpense.name}"></c:out></a></td>
						<td><c:out value="${oneExpense.vendor}"></c:out></td>
						<td>$<c:out value="${oneExpense.amount}"></c:out></td>
						<td><a href="/expenses/edit/${oneExpense.id}">edit</a></td>
						<td>
							<form action="/expenses/${oneExpense.id}" method="POST">
							<input type="hidden" name="_method" value="delete">
							<button class="btn btn-danger" type="submit">delete</button>
							</form>
						</td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	<div class="m-5 p-3 bg-dark text-light w-75 rounded">
		<h2>Add an expense:</h2>
		<form:form class="d-flex flex-column align-items-center" action="/expenses" method="POST" modelAttribute="expense">
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