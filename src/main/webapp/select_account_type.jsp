<%@page import="Dto.Customer"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<h1>Welcome to account creation page</h1>
<%Customer customer = (Customer)request.getSession().getAttribute("customer"); %>
<h1>Hello : Dear<%=customer.getCname() %></h1>

<body>
	<form action="createbankaccount">
	<input type="radio" name ="accounttype" value="savings" required="required">Savings
	<input type="radio" name="accounttype" value="current">Current<br><br>
	<button>submit</button> &nbsp;&nbsp;&nbsp;&nbsp; <button type="reset">cancel</button>
	
	
	</form>
</body>
</html>
