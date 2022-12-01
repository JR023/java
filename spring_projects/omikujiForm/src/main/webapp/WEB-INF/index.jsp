<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div id="container"> </div>
		<div id="heading"> </div>
			<h1>Send an Omikuji!</h1>
		<form action="show" method="POST">
			<label> Pick any number from 5 to 25</label>
			<br>	
			<select name="number" id="dropdown">
				<option value="5">5</option>
				<option value="10">10</option>
				<option value="15">15</option>
				<option value="20">20</option>
			</select>
			<br>
			<label>Enter the name of any city</label>
			<br>
			<input type="text" name="city">
			<br>
			<label>Enter the name of any real person</label>
			<br>
			<input type="text" name="name">
			<br>
			<label>Enter professional endeavor or hobby</label>
			<br>
			<input type="text" name="job">
			<br>
			<label>Enter any type of living thing</label>
			<br>	
			<input type="text" name="thing">
			<br>
			<label>Say something nice to someone</label>
			<br>	
			<textarea name="something" id="comment" cols="30" rows="10"></textarea>
			<br>
			<label for="send">Send and show a friend</label>
			<br>
			<input type="submit" value="send">
		</form>

</body>
</html>