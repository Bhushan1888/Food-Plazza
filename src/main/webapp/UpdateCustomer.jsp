<%@page import="com.pojo.Customer"%>
<%@page import="com.dao.CustomerDaoImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Customer</title>
<script type="text/javascript" src="validation.js"></script>
</head>
<body>
	
	<jsp:include page="UserHeader.jsp"></jsp:include>
	
	<%CustomerDaoImpl cd = new CustomerDaoImpl();
	String emailId = (String)session.getAttribute("uEmail");
	Customer c = cd.searchCustomerById(emailId);
	%>
	
	<div id="templatemo_container">
		<form action="customer" method="post" onsubmit="return UpdateCustValidation()"class="main">
			<table border="1">
				<caption>Update Customer</caption>

				<tr>
					<td>Name:</td>
					<td><input type="text" name="cname" id="cname" value="<%=c.getcName()%>"></td>
					<td><span id="cnameerror" style="color: red"></span></td>
				</tr>

				<tr>
					<td>Address:</td>
					<td><input type="text" name="adr" id="adr" value="<%=c.getcAddress()%>"></td>
					<td><span id="adrerror" style="color: red"></span></td>
				</tr>

				<tr>
					<td>Contact No:</td>
					<td><input type="text" name="cNo" id="cNo" value="<%=c.getcContactNo()%>"></td>
					<td><span id="cNoerror" style="color: red"></span></td>
				</tr>
			</table>

			<input type="submit" value="UpdateCustomer" name="action"> 
			<input type="reset" value="clear">

		</form>
	</div>
	<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>