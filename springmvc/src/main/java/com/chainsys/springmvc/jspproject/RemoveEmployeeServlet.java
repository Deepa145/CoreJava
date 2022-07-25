package com.chainsys.springmvc.jspproject;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.springmvc.commonutil.ExceptionManager;
import com.chainsys.springmvc.commonutil.InvalidInputDataException;
import com.chainsys.springmvc.commonutil.Validator;
import com.chainsys.springmvc.employeedao.EmployeeDao;


/**
 * Servlet implementation class RemoveEmployeeServlet
 */
@WebServlet("/RemoveEmployeeServlet")
public class RemoveEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoveEmployeeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();

		String source = "AddNewEmployee";
		String message = "<h1>Error while " + source + "</h1>";
		int result = 0;
		String id = null;
		try {
			id = request.getParameter("id");
			try {
				Validator.checkStringForParse(id);
			} catch (InvalidInputDataException err) {
				message += " Error in Employee id input </p>";
				String errorPage = ExceptionManager.HandleException(err, source, message);
				out.print(errorPage);
				return; // it terminate the code execution beyond this point
			}
			int empId = Integer.parseInt(id);
			try {
				Validator.CheckNumberForGreaterThanZero(empId);
			} catch (InvalidInputDataException err) {
				message += " Error in Employee id input </p>";
				String errorPage = ExceptionManager.HandleException(err, source, message);
				out.print(errorPage);
				return;
			}
			result = EmployeeDao.deleteEmployee(empId);
		} catch (Exception e) {
			message += " Error in Deleting the input </p>";
			String errorPage = ExceptionManager.HandleException(e, source, message);
			out.print(errorPage);
		}
		request.setAttribute("result",result);
		RequestDispatcher rd = request.getRequestDispatcher("/deleteemployee.jsp");
		rd.forward(request, response);
		}

}