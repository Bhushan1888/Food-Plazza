package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.pojo.Order;
import com.utility.DataConnect;

public class OrderDaoImpl implements OrderDao{

	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	int row;

	@Override
	public Order placeOrder(String emailId) {
		String ODate=new Date().toString();
		float totalprice=0;
		Order o=null;
		try {
			con=DataConnect.getConnect();
			ps=con.prepareStatement("select sum(totalprice) as total from cart_bh where emailId=?");
			ps.setString(1, emailId);
			rs = ps.executeQuery();
			if(rs.next()) {
				totalprice=rs.getFloat("total");
			}
				if(totalprice>0) {
					ps=con.prepareStatement("insert into order_bh(emailId,totalprice,date) values(?,?,?)");
					ps.setString(1, emailId);
					ps.setFloat(2, totalprice);
					ps.setString(3, ODate);
					row=ps.executeUpdate();
					if(row>0) {
						ps=con.prepareStatement("select * from order_bh where emailId=? and date=?");
						ps.setString(1, emailId);
						ps.setString(2, ODate);
						rs=ps.executeQuery();
						if(rs.next()) {
							o=new Order();
							o.setOrderId(rs.getInt("orderId"));
							o.setEmailId(rs.getString("emailId"));
							o.setTotalPrice(rs.getFloat("totalprice"));
							o.setDate(rs.getString("date"));
						}
					}
				}
		}catch(SQLException s) {
			s.printStackTrace();
		}
		return o;
	}
	
	@Override
	public List<Order> showOrder() {
		List<Order>l=new ArrayList<>();
		try {
			con=DataConnect.getConnect();
			ps=con.prepareStatement("select * from order_bh");
			rs=ps.executeQuery();
			while(rs.next()) {
				Order o=new Order();
				o.setOrderId(rs.getInt("orderId"));
				o.setEmailId(rs.getString("emailId"));
				o.setTotalPrice(rs.getFloat("totalprice"));
				o.setDate(rs.getString("date"));
				l.add(o);
			}
		}catch(SQLException s) {
			s.printStackTrace();
		}
		return l;
	}
}
