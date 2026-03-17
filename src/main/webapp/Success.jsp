<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
	String uEmail = (String) session.getAttribute("uEmail");
	String aEmail = (String) session.getAttribute("aEmail");
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
			<table>
				<tr>
					<td><h1>Successful...</h1></td>
				</tr>

			</table>
		</form>
	</div>
	<jsp:include page="Footer.jsp"></jsp:include>

</body>
</html>