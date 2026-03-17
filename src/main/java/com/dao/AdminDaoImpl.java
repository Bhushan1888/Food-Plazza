package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.dao.AdminDao;
import com.utility.DataConnect;

public class AdminDaoImpl implements AdminDao{

	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	
	@Override
	public boolean adminLogin(String aEmailId, String aPassword) {
		try
		{
			con = DataConnect.getConnect();
			ps = con.prepareStatement("select * from Admin_login_bh where aEmailId = ? and aPassword = ?");
			ps.setString(1, aEmailId);
			ps.setString(2, aPassword);
			rs = ps.executeQuery();
			
			if(rs.next())
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
	public boolean adminchangepassword(String aEmailId, String aPassword) {
		try
		{
			con = DataConnect.getConnect();
			ps = con.prepareStatement("update Admin_login_bh set aPassword=? where aEmailId=?");
			ps.setString(2, aEmailId);
			ps.setString(1, aPassword);
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
	public boolean userLogin(String cEmailId, String cPassword) {
		try 
		{
			con = DataConnect.getConnect();
			ps = con.prepareStatement("select * from Customer_BH where cEmailId=? and cPassword=?");
			ps.setString(1, cEmailId);
			ps.setString(2, cPassword);
			rs = ps.executeQuery();
			
			if(rs.next())
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
	public boolean userchangepassword(String cEmailId, String cPassword) {
		
		try
		{
			con = DataConnect.getConnect();
			ps = con.prepareStatement("update Customer_BH set cPassword=? where cEmailId = ?");
			ps.setString(2, cEmailId);
			ps.setString(1, cPassword);
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

}
