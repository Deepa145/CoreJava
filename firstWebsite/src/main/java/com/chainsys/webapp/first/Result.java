package com.chainsys.webapp.first;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Result
 */
public class Result extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Result() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		out.println("<html><head><title>Result</title></head><body>");
		HttpSession session = request.getSession(true);
		String sessionSalary = (String) session.getAttribute("salary");
		if(sessionSalary == null) {
			out.print("<h1> SESSION NOT YET SET!!! </h1>");
		}
		else {
		out.print("<h1>Value Fetched From Result</h1>" + sessionSalary);//returning value from sessionAttribute
		}
		out.println("</body></html>");
		String submitValue = request.getParameter("submit");
		if(submitValue!=null)
		{
			System.out.println(submitValue);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("DoPost Called");
		doGet(request,response);
	}

}
