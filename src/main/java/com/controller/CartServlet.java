package com.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.CartDaoImpl;
import com.dao.FoodDaoImpl;
import com.pojo.Cart;

/**
 * Servlet implementation class CartServlet
 */
@WebServlet("/cart")
public class CartServlet extends HttpServlet {

	CartDaoImpl cd = new CartDaoImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String action = request.getParameter("action");
		if(action!=null && action.equals("delete")) {
			int cartId = Integer.parseInt(request.getParameter("cartId"));
			boolean b = cd.deleteCart(cartId);
			if(b)
			{
				response.sendRedirect("cart");
			}else {
				response.sendRedirect("Failed.jsp");
			}
		}

		else {

			String emailId = (String)session.getAttribute("uEmail");
			List<Cart> l = cd.Showcart(emailId);
			if(l!=null && !(l.isEmpty()))
			{
				session.setAttribute("clist", l);
				response.sendRedirect("Cartlist1.jsp");
			}
			else {
				response.sendRedirect("Failed.jsp");
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		String action = request.getParameter("action");

		String fName = (String) session.getAttribute("fName");
		if(action!=null && action.equals("AddToCart"))
		{
			String name = request.getParameter("fname");
			String email = request.getParameter("email");
			int quan = Integer.parseInt(request.getParameter("fquan"));
			int fid = Integer.parseInt(request.getParameter("fid"));
			float fprice = Float.parseFloat(request.getParameter("fprice"));
			float tprice = Float.parseFloat(request.getParameter("tprice"));

			CartDaoImpl cObj = new CartDaoImpl();
			boolean b = cObj.searchCart(fName);
			if(!b)
			{
				boolean b1 = cd.addcart(new Cart(fid, quan, email, name, fprice, tprice));
				if(b1)
				{
					response.sendRedirect("cart");
				}
				else
				{
					response.sendRedirect("Failed.jsp");
				}
			}
			else {
				response.sendRedirect("cart");
			}
		}
	}

}
