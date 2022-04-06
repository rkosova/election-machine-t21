<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="app.model.Question" %> 
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Question</title>
</head>
<body>

	<form action='./editquestion' method='post'>
		Breed: <input type='text' name='question' value='${sessionScope.question.question }'><br>
		<input type="hidden" name="id" value="${sessionScope.question.id }">		
		<input type='submit' name='ok' value='Edit'>
	</form>

</body>
</html>