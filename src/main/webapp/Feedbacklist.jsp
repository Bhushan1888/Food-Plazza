<%@page import="com.pojo.Feedback"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.Iterator"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
	List<Feedback> l = (List) session.getAttribute("fdlist");
	%>
	<jsp:include page="AdminHeader.jsp"></jsp:include>

	<div id="templatemo_container">
		<form class="main">
			<table border="1">
				<caption>
					<h1>Feedback List</h1>
				</caption>

				<tr>
					<th>Name</th>
					<th>Email Id</th>
					<th>Review</th>
					<th>Rank</th>
					<th>Suggestion</th>
				</tr>

				<%
				Iterator<Feedback> itr = l.iterator();
				while (itr.hasNext()) {
					Feedback fd = itr.next();
				%>

				<tr>
					<td><%=fd.getName()%></td>
					<td><%=fd.getEmailId()%></td>
					<td><%=fd.getReview()%></td>
					<td><%=fd.getRank()%></td>
					<td><%=fd.getSuggestion()%></td>
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