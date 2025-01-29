<%@page import="Dto.Customer"%>
<%@page import="Dto.Bank_account"%>
<%@page import="Dao.BankDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<h1>Welcome to balance page</h1>
<body>

<% long acno=(long)request.getSession().getAttribute("acc_number");

	BankDao bankDao= new BankDao();
	
	Bank_account bank_account=bankDao.find(acno);
	
	Customer customer=bank_account.getCustomer();
	
	%>
	
	<h1>Hello <%if(customer.getGender().equals("male")) {%>Mr.<% }else{%>Ms.<%}%><%=customer.getCname() %></h1>
	
	<h1>Your account balance is:  <%= bank_account.getAmount() %></h1>
	
	
	<br>
	<br>
	<br>
	<br>
<a href="Account_home.html"><button>Back</button></a>
</body>

	
</html>