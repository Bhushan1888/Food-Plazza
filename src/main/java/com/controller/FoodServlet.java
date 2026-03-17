package com.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.FoodDaoImpl;
import com.pojo.Food;


@WebServlet("/food")
public class FoodServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	FoodDaoImpl fd = new FoodDaoImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String action = request.getParameter("action");
		if(action!=null && action.equals("delete"))
		{
			int foodId = Integer.parseInt(request.getParameter("foodId"));
			boolean b = fd.deleteFoodById(foodId);
			if(b) {
				response.sendRedirect("food");
			}
			else {
				response.sendRedirect("Failed.jsp");
			}
		}

		else 
		{	
			List<Food> l = fd.getAllFood();
			if(l!=null &&!(l.isEmpty()))
			{
				session.setAttribute("flist", l);
				response.sendRedirect("foodlist.jsp");
			} else {
				response.sendRedirect("Failed.jsp");
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		String action = request.getParameter("action");
		String name = request.getParameter("fname");
		String type = request.getParameter("ftype");
		int quan = Integer.parseInt(request.getParameter("fquan"));
		float price = Float.parseFloat(request.getParameter("fprice"));

		if(action!=null && action.equals("AddFood"))
		{
			boolean b = fd.addFood(new Food(name, type, quan, price));
			if(b) {
				response.sendRedirect("Success.jsp");
			}else {
				response.sendRedirect("Failed.jsp");
			}
		}

		if(action!=null && action.equals("UpdateFood"))
		{
			int fid = Integer.parseInt(request.getParameter("fId")); 
			Food f = new Food(name, type, quan, price);
			f.setFoodId(fid);
			boolean b = fd.updateFoodById(f);

			if(b) {
				response.sendRedirect("Success.jsp");
			}else {
				response.sendRedirect("Failed.jsp");
			}
		}



	}

}
