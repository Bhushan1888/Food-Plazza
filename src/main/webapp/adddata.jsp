<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP Page</title>
</head>
<body>
	<table>
		<%
			int quan = Integer.parseInt(request.getParameter("q"));
			String fname = request.getParameter("fname");
			float price = Float.parseFloat(request.getParameter("fprice"));
			int updateQuan = 0;
			float total = 0;
			
		
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bhushandb", "root","Bhushan@123");
			PreparedStatement ps  = con.prepareStatement("select * from cart_bh where fName=?");
			ps.setString(1, fname);
			ResultSet res = ps.executeQuery();
			
			if(res.next()){
				int quan1 = res.getInt("fQuantity");
				updateQuan = quan + quan1;
			}
			if(updateQuan>0)
			{
				total = updateQuan * price;
				
				PreparedStatement ps1 = con.prepareStatement("update cart_bh set fQuantity=?, totalprice=? where fName=?");
						
				ps1.setInt(1, updateQuan);
				ps1.setFloat(2, total);
				ps1.setString(3, fname);
				int row = ps1.executeUpdate();
			}
			
		%>
		
	</table>
</body>
</html>