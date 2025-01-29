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
<h1>Welcome to active account page</h1>
<body>
<%  List<Bank_account> list= (List<Bank_account>)request.getSession().getAttribute("list");
		
	if(list.isEmpty())
	{%>
	
	<h1>No active account</h1>
		
	<%} else {%>
	
	<h1>Select Bank account</h1>
	
	<%for( Bank_account bank_account:list) {%>
		
		<a href="setactiveaccount?acno=<%=bank_account.getAcc_no()%>"><button><%=bank_account.getAcc_no() %></button></a>
		
	<% }%>
	<% }%>

</body>
</html>