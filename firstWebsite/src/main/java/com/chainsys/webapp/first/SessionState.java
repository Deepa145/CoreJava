package com.chainsys.webapp.first;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SessionState
 */
public class SessionState extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SessionState() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		out.println("<html><head><title>Attribute</title></head><body>");
		String submitValue = request.getParameter("submit");
		HttpSession session = request.getSession(true);// create session id(token)
		System.out.println(session.getId());
		if (submitValue.equals("result")) {
			// response.sendRedirect("Result");// Navigating from one servlet to another
			// within the same website.
			// response.sendRedirect("http://www.google.com");// sendRedirect() Can also be
			// used to navigate to another website.
			RequestDispatcher rd = request.getRequestDispatcher("Result");
			//Navigating from one servlet to another
			// can't be used for navigate to another website.
			rd.forward(request, response);
			// Parsing the request and response object received by the current servlet to the forwarded servlet.
		} else if (submitValue.equals("set")) {
			String salaryInput = request.getParameter("salary");
			session.setAttribute("salary", salaryInput);// Store data in session scope for each user
			// session.setAttribute() Stores the data in a collection using key and value.
			// salary = key ,salaryInput = value .
			out.print("<h1>Value Set</h1>" + salaryInput);
		} else if (submitValue.equals("fetch")) {
			String sessionSalary = (String) session.getAttribute("salary");
//			String sessionSalary = session.getAttribute("salary").toString();
			if (sessionSalary == null) {
				out.print("<h1> SESSION NOT YET SET!!! </h1>");
			} else {
				out.print("<h1>Value Fetched</h1>" + sessionSalary);// returning value from sessionAttribute
			}
		}
		out.println("</body></html>");
	}

}
