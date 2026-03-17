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


@WebServlet("/cservlet1")
public class ChangePass extends HttpServlet {

	AdminDaoImpl ad = new AdminDaoImpl();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String email = request.getParameter("email");
		String pass = request.getParameter("pass");
		HttpSession session = request.getSession(false);
		//String uEmail = request.getParameter("uEmail");
		//String aEmail = request.getParameter("aEmail");
		String uEmail = (String)session.getAttribute("uEmail");
		String aEmail = (String)session.getAttribute("aEmail");
		String aPass =  (String)session.getAttribute("aPass");
		String uPass =  (String)session.getAttribute("uPass");
		String npass = request.getParameter("cpass");

//		PrintWriter out = response.getWriter();

		if(email.equals(uEmail) && pass.equals(uPass) )
		{
			boolean b = ad.userchangepassword(email, npass);
			if(b)
			{
				response.sendRedirect("Success.jsp");
//				out.println("Succeful.");
			}
			else
			{
//				out.println("Failed");
				response.sendRedirect("Failed.jsp");
			}
		}	

		if(email.equals(aEmail) && pass.equals(aPass))
		{
			boolean b1 = ad.adminchangepassword(email, npass);
			if(b1)
			{
				response.sendRedirect("Success.jsp");
//				out.println("Sucfoeful.");
			}
			else
			{
//				out.println("Failed");
				response.sendRedirect("Failed.jsp");
			}
		}


	}

}
