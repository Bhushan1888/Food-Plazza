package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.pojo.Feedback;
import com.utility.DataConnect;

public class FeedbackDaoImpl implements FeedbackDao{

	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	int row;


	@Override
	public boolean addFeedback(Feedback fd) {
		try {
			con = DataConnect.getConnect();
			ps = con.prepareStatement("insert into Feedback values(?,?,?,?,?)");
			ps.setString(1, fd.getName());
			ps.setString(2, fd.getEmailId());
			ps.setString(3, fd.getReview());
			ps.setInt(4, fd.getRank());
			ps.setString(5,  fd.getSuggestion());


			row = ps.executeUpdate();
			if(row>0)

			{
				return true;
			}
			else {
				return false;
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Feedback> getAllFeedback() {

		List<Feedback> l = new ArrayList<Feedback>();
		try
		{
			con = DataConnect.getConnect();
			ps = con.prepareStatement("Select * from Feedback");
			rs = ps.executeQuery();

			rs = ps.executeQuery();

			while(rs.next())
			{
				Feedback f = new Feedback();

				f.setName(rs.getString(1));
				f.setEmailId(rs.getString(2));
				f.setReview(rs.getString(3));
				f.setRank(rs.getInt(4));
				f.setSuggestion(rs.getString(5));

				l.add(f);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return l;
	}

}
