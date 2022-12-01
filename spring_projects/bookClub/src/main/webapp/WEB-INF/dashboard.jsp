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

<title>Book Broker</title>
</head>
<body>
	<div class="container d-flex flex-column align-items-left text-light bg-dark p-3">
		<div>
			<div class="d-flex justify-content-between">
				<h1 class="text-info">Welcome, <c:out value="${user.userName}"></c:out>!</h1>
				<a href="/logout">Logout</a>
			</div>
			<div class="d-flex justify-content-between">
				<h5>Available Books to Borrow:</h5>
				<a href="/dashboard/new">+Add a book to my shelf</a>
			</div>
			<div>
			<table class="table table-hover table-dark">
				<thead>
					<tr>
						<th scope="col">ID</th>
						<th scope="col">Title</th>
						<th scope="col">Author</th>
						<th scope="col">Owner</th>
						<th scope="col">Actions</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="oneBook" items="${books}">
					<tr>
						<td><c:out value="${oneBook.id}"></c:out></td>
						<td><a href="/dashboard/${oneBook.id}"><c:out value="${oneBook.title}"></c:out></a></td>
						<td><c:out value="${oneBook.author}"></c:out></td>
						<td><c:out value="${oneBook.user.userName}"></c:out></td>
						<c:if test="${oneBook.user.id == user.id}">
							<td><a href="/dashboard/edit/${oneBook.id}">Edit</a>
							<a href="/dashboard/delete/${oneBook.id}">Delete</a>
							</td>
						</c:if>
						<c:if test="${oneBook.user.id != user.id}">
							<td><a href="/dashboard/borrow/${oneBook.id}">Borrow</a></td>
						</c:if>
					</tr>
					</c:forEach>
				</tbody>
			</table>
			</div>
			<div>
			<h5>Books I'm Borrowing...</h5>
			<table class="table table-hover table-dark">
				<thead>
					<tr>
						<th scope="col">ID</th>
						<th scope="col">Title</th>
						<th scope="col">Author</th>
						<th scope="col">Owner</th>
						<th scope="col">Actions</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="oneBook" items="${userBooks}">
					<tr>
						<td><c:out value="${oneBook.id}"></c:out></td>
						<td><a href="/dashboard/${oneBook.id}"><c:out value="${oneBook.title}"></c:out></a></td>
						<td><c:out value="${oneBook.author}"></c:out></td>
						<td><c:out value="${oneBook.user.userName}"></c:out></td>
						<td><a href="/dashboard/return/${oneBook.id}">Return</a></td>
					</tr>
					</c:forEach>
				</tbody>
			</table>
			</div>
		</div>
	</div>
</body>
</html>