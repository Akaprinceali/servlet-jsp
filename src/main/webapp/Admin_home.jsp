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
<h1>Welcome to Admin home page</h1>
<body>

<%List<Bank_account> list=(List<Bank_account>)request.getSession().getAttribute("list");%>

		<table border="1"> 
			<tr>
				<th>Account number</th>
				<th>Account type</th>
				<th>Customer name</th>
				<th>Customer Id</th>
				<th>Account status</th>
				<th>Change status</th>
			</tr>
			<%for(Bank_account bank_account:list){ %>
			<tr>
				<th><%=bank_account.getAcc_no() %></th>
				<th><%=bank_account.getAccount_type() %></th>
				<th><%=bank_account.getCustomer().getCname() %></th>
				<th><%=bank_account.getCustomer().getCid() %></th>
				<th><%=bank_account.isStatus() %></th>
				<th><a href="changestatus?acno=<%=bank_account.getAcc_no()%>"><button type="submit">Change Status</button></a></th>
			</tr>
			<%} %>
		</table>


</body>
</html>