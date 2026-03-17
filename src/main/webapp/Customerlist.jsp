<%@page import="java.util.Iterator"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="com.pojo.Customer"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
	List<Customer> l = (List) session.getAttribute("cslist");
	%>

	<jsp:include page="AdminHeader.jsp"></jsp:include>

	<div id="templatemo_container">
		<form class="main">
			<table border="1">
				<caption>
					<h1>Customer List</h1>
				</caption>

				<tr>
					<th>Name</th>
					<th>Email Id</th>
					<th>Password</th>
					<th>Address</th>
					<th>ContactNo</th>
					<th colspan="2">Action</th>
				</tr>

				<%
				Iterator<Customer> itr = l.iterator();
				while (itr.hasNext()) {
					Customer cs = itr.next();
				%>

				<tr>
					<td><%=cs.getcName()%></td>
					<td><%=cs.getcEmailId()%></td>
					<td><%=cs.getcPassword()%></td>
					<td><%=cs.getcAddress()%></td>
					<td><%=cs.getcContactNo()%></td>
					<td><a href="customer?action=delete&emailId=<%=cs.getcEmailId()%>">Delete</a></td>
				</tr>
				<%
				}
				%>
			</table>
		</form>
	</div>
	<jsp:include page="Footer.jsp"></jsp:include>

</body>
</html>