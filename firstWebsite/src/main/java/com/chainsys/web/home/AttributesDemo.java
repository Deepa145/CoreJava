package com.chainsys.web.home;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AttributesDemo
 */
public class AttributesDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AttributesDemo() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	public String salary = null;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponseresponse)
	 *The global variable declared in servlet is stateless in nature.
	 *The data is shared with all users accessing the servlet.
	 *The data will be available in the servlet until the server is destroyed.
	 *If a  user modifies the value of the global variable,then all others users
	  currently using the servlet,or users who amy user the servlet in the
	  future will get the last modified value
	 *
	 *Global variable are not suitable for single user state(stateful).
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		out.println("<html><head><title>HelloWorld</title></head><body>");
		String submitvalue = request.getParameter("submit");
		System.out.println("value :" + submitvalue);
		if (submitvalue.equals("set")) {
			String SalaryInput = request.getParameter("salary");
			salary = SalaryInput;
			System.out.println("Salary Input :" + salary);
			// out.println("<h1>Value Set</h1>");
		} else if (submitvalue.equals("fetch")) {
			out.println("<h1>Value fetched</h1>" + salary);
		}
		out.println("</body></html>");
	}

}
