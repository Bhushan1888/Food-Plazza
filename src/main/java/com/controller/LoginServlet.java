package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.AdminDaoImpl;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	AdminDaoImpl ad = new AdminDaoImpl();
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.invalidate();
		response.sendRedirect("index.jsp");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String type = request.getParameter("type");
		String email = request.getParameter("email");
		String pass = request.getParameter("pass");
		HttpSession session = request.getSession();

		PrintWriter out = response.getWriter();

		if(type.equals("admin")) {
			boolean b = ad.adminLogin(email, pass);
			if(b) {
//				out.println("Success");
				session.setAttribute("aPass", pass);
				session.setAttribute("aEmail", email);
				response.sendRedirect("AdminLogin.jsp");
			}
			else {
				response.sendRedirect("Failed.jsp");
			}
		}


		if(type.equals("user")) {
			boolean b = ad.userLogin(email, pass);
			if(b) {
				session.setAttribute("uPass", pass);
				session.setAttribute("uEmail", email);
				response.sendRedirect("UserLogin.jsp");
			}
			else {
				out.println("Failed");
			}
		}

	}

}
