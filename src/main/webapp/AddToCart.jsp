<%@page import="com.pojo.Food"%>
<%@page import="com.dao.FoodDaoImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript" src="cart.js"></script>
<script type="text/javascript">

<link href="templatemo_style.css" rel="stylesheet" type="text/css" />
<title>Insert title here</title>


	
	function total() {
		quan = document.getElementById('fquan').value;
		price = document.getElementById('fprice').value;
		total = price * quan;
		document.getElementById('tprice').value = total
	}
</script>

</head>
<body>
	
	<jsp:include page="UserHeader.jsp"></jsp:include>

	<%
	FoodDaoImpl fd = new FoodDaoImpl();
	int foodId = Integer.parseInt(request.getParameter("foodId"));
	Food food = fd.searchFoodById(foodId);
	String emailId = (String) session.getAttribute("uEmail");
	
	String fName = request.getParameter("fName");
	session.setAttribute("fName", fName);
	
	
	%>

	<div id="templatemo_container">
		<form action="cart" method="post" class="main" onsubmit="return AddToCartValidation()">
			<table border="1">
				<caption>Add To Cart</caption>
				
				<tr>
					<td>Existing Food Id:</td>
					<td><input type="text" name="fid" id="fid" value="<%=food.getFoodId()%>" ></td>
					<td><span id="fiderror" style="color:red "></span></td>
				</tr>

				<tr>
					<td>Email Id:</td>
					<td><input type="text" name="email" id="email" value="<%=emailId %>" ></td>
					<td><span id="emailrror" style="color:red "></span></td>
				</tr>
				
				<tr>
					<td>Food Name:</td>
					<td><input type="text" name="fname" id="fname" value="<%=food.getfName() %>" ></td>
					<td><span id="fnameerror" style="color:red "></span></td>
				</tr>
				
				<tr>
					<td>Quantity:</td>
					<td><input type="number" name="fquan" id="fquan"  onkeyup="searchdata(this.value)"  ></td>
					<td><span id="fquanerror" style="color:red "></span></td>
				</tr>	
				
				<tr>
					<td>Price:</td>
					<td><input type="number" name="fprice" id="fprice" value="<%=food.getfPrice() %>" ></td>
					<td><span id="fpriceerror" style="color: red"></span></td>
				</tr>
				
				<tr>
					<td>Total Price:</td>
					<td><input type="number" name="tprice" id="tprice" onclick="total()"></td>
					<td><span id="tpriceerror" style="color: red"></span></td>
				</tr>
				
			</table>
			
				<input type="submit" value="AddToCart" name="action">
				<input type="reset" value="Clear">
		</form>
	</div>
	
		<jsp:include page="Footer.jsp"></jsp:include>
	
</body>
</html>