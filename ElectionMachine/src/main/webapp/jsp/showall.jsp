<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page import="java.util.ArrayList" %>
<%@ page import="app.model.Question" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All datatable rows</title>
</head>
<body>

<table>
<tr>
	<th>ID</th>
	<th>Question</th>
</tr>
<c:forEach var="question" items="${sessionScope.allquestions }">
	<tr>
		<td>${question.q_id }</td>
		<td>${question.question }</td>
		<td>
			<a href="/editquestion?q_id=${question.q_id }">Edit</a>
		</td>
	</tr>
</c:forEach>
</table>

</body>
</html>