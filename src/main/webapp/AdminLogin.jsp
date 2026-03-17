<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Header</title>
</head>
<body>
	<%String aEmail = (String)session.getAttribute("aEmail"); 
		session.setAttribute("aEmail", aEmail);
	%>

	<jsp:include page="AdminHeader.jsp"></jsp:include>
	<jsp:include page="Section.jsp"></jsp:include>
	<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>