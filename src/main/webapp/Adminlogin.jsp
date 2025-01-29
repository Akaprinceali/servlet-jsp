<%@page import="Dto.Bank_account"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<h1>Welcome to Admin login page</h1>
<body>

<%List<Bank_account> list=  ( List<Bank_account>)request.getSession().getAttribute("list") ;%>

<table border="1">
<tr>
<th>Account_number</th>
<th>Account_type</th>
<th>Customer_name</th>
<th>Customer_id</th>
<th>Customer_status</th>
<th>Change_status</th>
</tr>


<% for(Bank_account bank_account: list){%>

<tr>
<th><%= bank_account.getAcc_no() %></th>
<th><%= bank_account.getAccount_type()  %></th>
<th><%= bank_account.getCustomer().getCname() %></th>
<th><%= bank_account.getCustomer().getCid()   %></th>
<th><%= bank_account.isStatus() %></th>
<th><%= bank_account.isStatus() %></th>

</tr>
	
	
	
	<% }%>
	
</table>
</body>
</html>