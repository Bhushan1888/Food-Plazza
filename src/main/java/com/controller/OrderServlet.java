package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.CartDaoImpl;
import com.dao.OrderDaoImpl;
import com.pojo.Order;


@WebServlet("/order1")
public class OrderServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	OrderDaoImpl  od = new OrderDaoImpl();
	CartDaoImpl cd = new CartDaoImpl();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		String email = (String) session.getAttribute("uEmail");
		
		Order o = od.placeOrder(email);
		
		if(o!=null) {
			boolean b = cd.clearCart(email);
			if(b)
			{
				request.setAttribute("order", o);
				request.getRequestDispatcher("Bill.jsp").forward(request, response);
			}
		}
		else {
			response.sendRedirect("Failed.jsp");
		}
		
	}

}
