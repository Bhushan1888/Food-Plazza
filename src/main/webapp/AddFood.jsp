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

	<div id="templatemo_container">
		<form action="food" method="post" onsubmit="return AddFoodValidation()"
			class="main">
			<table border="1">
				<caption>Add Food</caption>

				<tr>
					<td>FoodName:</td>
					<td><input type="text" name="fname" id="fname"></td>
					<td><span id="fnameerror" style="color: red"></span></td>
				</tr>

				<tr>
					<td>FoodType:</td>
					<td><input type="text" name="ftype" id="ftype"></td>
					<td><span id="ftypeerror" style="color: red"></span></td>
				</tr>
				
				<tr>
					<td>Quantity:</td>
					<td><input type="number" name="fquan" id="fquan"></td>
					<td><span id="fquanerror" style="color: red"></span></td>
				</tr>
				
				<tr>
					<td>Price:</td>
					<td><input type="number" name="fprice" id="fprice"></td>
					<td><span id="fpriceerror" style="color: red"></span></td>
				</tr>
				
			</table>
			
			<input type="submit" value="AddFood" name="action">
			<input type="reset" value="Clear">
			
		</form>
	</div>
	
	<jsp:include page="Footer.jsp"></jsp:include>
</body>
</html>