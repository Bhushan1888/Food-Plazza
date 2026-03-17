package com.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.FeedbackDaoImpl;
import com.pojo.Feedback;


@WebServlet("/feedback")
public class FeedbackServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	FeedbackDaoImpl fd = new FeedbackDaoImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		List<Feedback> l = fd.getAllFeedback();
		if(l!=null && !(l.isEmpty()))
		{
			session.setAttribute("fdlist", l);
			response.sendRedirect("Feedbacklist.jsp");
		}else {
			response.sendRedirect("Failed.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession  session = request.getSession();
		String email = (String) session.getAttribute("uEmail");
		String action = request.getParameter("action");

		if(action!=null && action.equals("AddFeedback"))
		{
			String name = request.getParameter("cname");
			String review = request.getParameter("review");
			int rank = Integer.parseInt(request.getParameter("rank"));
			String sug = request.getParameter("sug");

			boolean b = fd.addFeedback(new Feedback(name, email, review, rank, sug));
			if(b)
			{
				response.sendRedirect("Success.jsp");
			}
			else
			{
				response.sendRedirect("Failed.jsp");
			}

		}
	}

}
