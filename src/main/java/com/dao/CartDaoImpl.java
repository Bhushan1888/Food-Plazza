package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.pojo.Cart;
import com.utility.DataConnect;

public class CartDaoImpl implements CartDao {
	
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	int row;
	
	@Override
	public boolean addcart(Cart c) {
		try
		{
			con = DataConnect.getConnect();
			ps = con.prepareStatement("Insert into Cart_bh values (?,?,?,?,?,?,?)");
			ps.setInt(1, c.getCartId());
			ps.setInt(2, c.getFoodId());
			ps.setInt(3, c.getfQuantity());
			ps.setString(4, c.getEmailId());
			ps.setString(5, c.getFoodName());
			ps.setFloat(6, c.getPrice());
			ps.setFloat(7, c.getTotalPrice());
			row = ps.executeUpdate();
			
			if(row>0)
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Cart> Showcart(String emailId) {
		List<Cart> l = new ArrayList<>();
		try
		{
			con = DataConnect.getConnect();
			ps = con.prepareStatement("select * from Cart_bh where emailId = ?");
			ps.setString(1, emailId);
			rs = ps.executeQuery();
			
			while(rs.next())
			{
				Cart c = new Cart();
				c.setCartId(rs.getInt("cartId"));
				c.setFoodId(rs.getInt("foodId"));
				c.setfQuantity(rs.getInt("fQuantity"));
				c.setEmailId(rs.getString("emailId"));
				c.setFoodName(rs.getString("fName"));
				c.setPrice(rs.getFloat("price"));
				c.setTotalPrice(rs.getFloat("totalprice"));	
				
				l.add(c);
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return l;
	}

	@Override
	public boolean deleteCart(int cartId) {
		try
		{
			con = DataConnect.getConnect();
			ps = con.prepareStatement("delete from Cart_bh where cartId = ?");
			ps.setInt(1, cartId);
			row = ps.executeUpdate();
			
			if(row>0)
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean clearCart(String emailId) {
		try
		{
			con = DataConnect.getConnect();
			ps = con.prepareStatement("delete from Cart_bh where emailId = ?");
			ps.setString(1, emailId);
			row = ps.executeUpdate();
			
			if(row>0)
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean searchCart(String foodName) {
		
		try {
		 con = DataConnect.getConnect();
		 ps= con.prepareStatement("select * from cart_bh where fName =?");
				 ps.setString(1, foodName);
		 	rs = ps.executeQuery();
		 	
		 	while(rs.next())
		 	{
		 		return true;
		 	}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
