<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.pojo.Cart"%>
<%@page import="java.util.List"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<jsp:include page="UserHeader.jsp"></jsp:include>

	<%
	List<Cart> l = (List) session.getAttribute("clist");
	Cart c = new Cart();
	%>
	
	<div id="templatemo_container">
		<form action="order1" method="post">
				<table border="1">
				<caption>
					<h1>Cart List</h1>
				</caption>

				<tr>
					<th>CartId</th>
					<th>FoodId</th>
					<th>EmailId</th>
					<th>FoodName</th>
					<th>FoodQuantity</th>
					<th>Price</th>
					<th>TotalPrice</th>
					<th colspan="2">Action</th>
				</tr>

				<%
				Iterator<Cart> itr = l.iterator();
				while (itr.hasNext()) {
					c = itr.next();
				%>

				<tr>
					<td><%=c.getCartId()%></td>
					<td><%=c.getFoodId()%></td>
					<td><%=c.getEmailId()%></td>
					<td><%=c.getFoodName()%></td>
					<td><%=c.getfQuantity()%></td>
					<td><%=c.getPrice()%></td>
					<td><%=c.getTotalPrice()%></td>

					<td><a href="cart?action=delete&cartId=<%=c.getCartId()%>">Delete</a></td>
				</tr>

				<%
				}
				%>
			</table>

			<input type="submit" value="placeOrder" />
		</form>
	</div>

	<jsp:include page="Footer.jsp"></jsp:include>

</body>
</html>