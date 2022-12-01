<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" type="text/css" href="/css/style.css"/>
<!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>

<title>Fruit Store</title>
</head>
<body class="bg-secondary">
	<div class="m-5">
		<h1 class="text-info">Fruit Store</h1>
		<c:forEach var="oneFruit" items="${myFruits}">
		<div class="col-sm-5"> 
			<table class="table table-hover table-dark">
				<thead>
					<tr>
						<th scope="col" class="text-warning">Name</th>
						<th scope="col" class="text-success">Price</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td class="w-50"><c:out value="${oneFruit.name}"></c:out></td>
						<td><c:out value="${oneFruit.price}"></c:out></td>
					</tr>
				</tbody>
			</table>
		</div>
		</c:forEach>
	</div>
</body>
</html>