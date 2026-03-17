<%@page import="com.pojo.Food"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="templatemo_style.css" rel="stylesheet" type="text/css" />
</head>
<body>

	<%
	String uEmail = (String) session.getAttribute("uEmail");
	String aEmail = (String) session.getAttribute("aEmail");

	List<Food> l = (List) session.getAttribute("flist");
	%>

	<c:if test="${uEmail==null && aEmail==null}">
		<jsp:include page="Header.jsp"></jsp:include>
	</c:if>

	<c:if test="${uEmail!=null && aEmail==null}">
		<jsp:include page="UserHeader.jsp"></jsp:include>
	</c:if>

	<c:if test="${uEmail==null && aEmail!=null}">
		<jsp:include page="AdminHeader.jsp"></jsp:include>
	</c:if>

	<div id="templatemo_container">
		<form class="main">
			<table border="1">
				<caption>
					<h1>FoodList</h1>
				</caption>

				<tr>
					<th>FoodId</th>
					<th>FoodName</th>
					<th>FoodType</th>
					<th>FQuantity</th>
					<th>Price</th>

					<c:if test="${uEmail==null && aEmail!=null}">
						<th colspan="2">Action</th>
					</c:if>

					<c:if test="${uEmail!=null && aEmail==null}">
						<th colspan="1">Action</th>
					</c:if>
				</tr>
				<%
					Iterator<Food> itr = l.iterator();
					while (itr.hasNext()) {
						Food f = itr.next();
					%>

				<tr>
					<td><%=f.getFoodId()%></td>
					<td><%=f.getfName()%></td>
					<td><%=f.getfType()%></td>
					<td><%=f.getfQuantity()%></td>
					<td><%=f.getfPrice()%></td>

					<c:if test="${uEmail==null && aEmail!=null}">
						<td><a href="UpdateFood.jsp?foodId=<%=f.getFoodId()%>">Edit</a></td>
						<td><a href="food?action=delete&foodId=<%=f.getFoodId()%>">Delete</a></td>
					</c:if>


					<c:if test="${uEmail!=null && aEmail == null}">
						<td><a href="AddToCart.jsp?foodId=<%=f.getFoodId()%>&fName=<%=f.getfName()%>">Add</a></td>
					</c:if>

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