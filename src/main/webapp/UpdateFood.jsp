<%@page import="com.pojo.Food"%>
<%@page import="com.dao.FoodDaoImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript" src="validation.js"> </script>
<title>Insert title here</title>
</head>
<body>

	<jsp:include page="AdminHeader.jsp"></jsp:include>
	<% 
		int foodId = Integer.parseInt(request.getParameter("foodId"));
		FoodDaoImpl fd = new FoodDaoImpl();
		Food f = fd.searchFoodById(foodId);	
	%>
	<div id="templatemo_container">
		<form action="food" method="post" class="main" onsubmit="return UpdateFoodValidation()">
			<table border="1">
				<caption>Update Food</caption>
				
				<tr>
					<td>FoodId:</td>
					<td><input type="text" name="fId" id="fId" value="<%=f.getFoodId() %>"></td>
					<td><span id="fiderror" style="color:red "></span></td>
				</tr>

				<tr>
					<td>FoodName:</td>
					<td><input type="text" name="fname" id="fname" value="<%=f.getfName() %>" ></td>
					<td><span id="fnameerror" style="color:red "></span></td>
				</tr>
				
				<tr>
					<td>FoodType:</td>
					<td><input type="text" name="ftype" id="ftype" value="<%=f.getfType() %>"></td>
					<td><span id="ftypeerror" style="color:red "></span></td>
				</tr>
				
				<tr>
					<td>Quantity:</td>
					<td><input type="number" name="fquan" id="fquan" value="<%=f.getfQuantity() %>"></td>
					<td><span id="fquanerror" style="color:red "></span></td>
				</tr>	
				
				<tr>
					<td>Price:</td>
					<td><input type="number" name="fprice" id="fprice" value="<%=f.getfPrice() %>"></td>
					<td><span id="fpriceerror" style="color: red"></span></td>
				</tr>
				
			</table>
			
				<input type="submit" value="UpdateFood" name="action">
				<input type="reset" value="Clear">
		</form>
	</div>
	
	<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>