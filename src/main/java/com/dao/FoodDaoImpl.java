package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.pojo.Food;
import com.utility.DataConnect;

public class FoodDaoImpl implements FoodDao {

	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	
	@Override
	public boolean addFood(Food food) {
		try
		{
			con = DataConnect.getConnect();
			ps = con.prepareStatement("insert into Food_bh values(?,?,?,?,?)");
			ps.setInt(1, food.getFoodId());
			ps.setString(2, food.getfName());
			ps.setString(3, food.getfType());
			ps.setInt(4, food.getfQuantity());
			ps.setFloat(5, food.getfPrice());
			int row = ps.executeUpdate();
			
			if(row>0)
			{
				return true;
			}
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean updateFoodById(Food food) {
		try
		{
			con = DataConnect.getConnect();
			ps = con.prepareStatement("Update Food_bh set fName =?,fType=?,fQuantity=?,fPrice=? where foodId = ?");
			ps.setString(1, food.getfName());
			ps.setString(2, food.getfType());
			ps.setInt(3, food.getfQuantity());
			ps.setFloat(4, food.getfPrice());
			ps.setInt(5, food.getFoodId());
			int row = ps.executeUpdate();
			
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
	public boolean deleteFoodById(int foodId) {
		try
		{
			con = DataConnect.getConnect();
			ps = con.prepareStatement("delete from Food_bh where foodId = ?");
			ps.setInt(1, foodId);
			int row = ps.executeUpdate();
			
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
	public List<Food> getAllFood() {
		List<Food> l = new ArrayList<Food>();
		try
		{
			con = DataConnect.getConnect();
			ps = con.prepareStatement("Select * from Food_bh");
			rs = ps.executeQuery();
			
			while(rs.next())
			{
				Food food = new Food();
				food.setFoodId(rs.getInt("foodId"));
				food.setfName(rs.getString("fName"));
				food.setfType(rs.getString("fType"));
				food.setfQuantity(rs.getInt("fQuantity"));
				food.setfPrice(rs.getFloat("fPrice"));	
				
				l.add(food);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return l;
	}

	@Override
	public Food searchFoodById(int foodId) {
		Food food = null;
		try
		{
		con = DataConnect.getConnect();
		ps = con.prepareStatement("select * from Food_bh where foodId = ?");
		ps.setInt(1, foodId);
		rs = ps.executeQuery();
		
		while(rs.next())
		{
			food = new Food();
			food.setfName(rs.getString("fName"));
			food.setFoodId(rs.getInt("foodId"));
			food.setfQuantity(rs.getInt("fQuantity"));
			food.setfType(rs.getString("fType"));
			food.setfPrice(rs.getFloat("fPrice"));	
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return food;
	}
	
	

}
