package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.CustomerDaoImpl;
import com.pojo.Customer;


@WebServlet("/customer")
public class CustomerServlet extends HttpServlet {

	CustomerDaoImpl custobj = new CustomerDaoImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		String action = request.getParameter("action");
		PrintWriter out = response.getWriter();

		if(action!=null &&action.equals("delete")) {
			String emailId=request.getParameter("emailId");

			boolean b = custobj.deleteCustomerById(emailId);
			if(b) {
				response.sendRedirect("Success.jsp");
			}
			else {
				response.sendRedirect("Failed.jsp");
			}
		}
		else {
			List<Customer> l = custobj.getAllCustomer();
			if(l!=null&& !(l.isEmpty()))
			{
				session.setAttribute("cslist", l);
				response.sendRedirect("Customerlist.jsp");
			}
			else {
				response.sendRedirect("Failed.jsp");
			}
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		String email1 = (String)session.getAttribute("uEmail");
		String pass1=(String)session.getAttribute("uPass");
		PrintWriter out = response.getWriter();
		System.out.println(email1);
		System.out.println(pass1);

		String action = request.getParameter("action");
		String name = request.getParameter("cname");
		String email = request.getParameter("email");
		String pass = request.getParameter("pass");
		String adr = request.getParameter("adr");
		String cNo = request.getParameter("cNo");

		if(action!=null && action.equals("AddCustomer")) {
			boolean b = custobj.addCustomer(new Customer(name, email, pass, adr, cNo));
			if(b) {
				response.sendRedirect("Success.jsp");
			}
			else {
				response.sendRedirect("Failed.jsp");
			}	
		}

		if(action!=null && action.equals("UpdateCustomer")) {
			boolean b = custobj.updateCustomerById(new Customer(name, email1, pass1, adr, cNo));
			if(b) {
				response.sendRedirect("Success.jsp");
			}
			else {
				response.sendRedirect("Failed.jsp");
			}
		}

	}
}
