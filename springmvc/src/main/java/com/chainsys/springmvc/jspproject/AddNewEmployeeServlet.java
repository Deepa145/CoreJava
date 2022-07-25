package com.chainsys.springmvc.jspproject;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
import com.chainsys.springmvc.pojo.Employee;

/**
 * Servlet implementation class AddNewEmployeeServlet
 */
@WebServlet("/AddNewEmployeeServlet")
public class AddNewEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddNewEmployeeServlet() {
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
		Employee newemp = null;
		int result = 0;
		int empId = 0;
		String testname = null;
		try {
			newemp = new Employee();
			String id = request.getParameter("id");
			try {
				Validator.checkStringForParse(id);
			} catch (InvalidInputDataException err) {
				message += " Error in Employee id input </p>";
				String errorPage = ExceptionManager.HandleException(err, source, message);
				out.print(errorPage);
				return; // it terminate the code execution beyond this point
			}
			empId = Integer.parseInt(id);
			try {
				Validator.CheckNumberForGreaterThanZero(empId);
			} catch (InvalidInputDataException err) {
				message += " Error in Employee id input </p>";
				String errorPage = ExceptionManager.HandleException(err, source, message);
				out.print(errorPage);
				return;
			}
			newemp.setEmp_id(empId);
//--------------------------------
			String fname = request.getParameter("fname");
			testname = fname;
			try {
				Validator.checkStringOnly(testname);
			} catch (InvalidInputDataException err) {
				message += " Error in Employee Firt Name input </p>";
				String errorPage = ExceptionManager.HandleException(err, source, message);
				out.print(errorPage);
				return;
			}
			try {
				Validator.checklengthOfString(fname);
			} catch (InvalidInputDataException err) {
				message += " Error in Employee First Name input </p>";
				String errorPage = ExceptionManager.HandleException(err, source, message);
				out.print(errorPage);
				return;
			}
			newemp.setFirst_name(fname);
//-----------------------------------
			String lname = request.getParameter("lname");
			testname = fname;
			try {
				Validator.checkStringOnly(testname);
			} catch (InvalidInputDataException err) {
				message += " Error in Employee Last Name input </p>";
				String errorPage = ExceptionManager.HandleException(err, source, message);
				out.print(errorPage);
				return;
			}
			try {
				Validator.checklengthOfString(lname);
			} catch (InvalidInputDataException err) {
				message += " Error in Employee Last Name input </p>";
				String errorPage = ExceptionManager.HandleException(err, source, message);
				out.print(errorPage);
				return;
			}
			newemp.setLast_name(lname);
//----------------------------------			
			String email = request.getParameter("email");
			try {
				Validator.checkMail(email);
			} catch (InvalidInputDataException err) {
				message += " Error in E-mail input </p>";
				String errorPage = ExceptionManager.HandleException(err, source, message);
				out.print(errorPage);
				return;
			}
			newemp.setEmail(email);
//--------------------------------------			
			SimpleDateFormat hire_dateFormate = new SimpleDateFormat("dd/MM/yyyy");
			String emp_HireDate = request.getParameter("hdate");
			// Date hire_date=hire_dateFormate.parse(emp_HireDate);

			try {
				Validator.checkDateFormat(emp_HireDate);
			} catch (InvalidInputDataException err) {
				message += " Error in Hire Date input </p>";
				String errorPage = ExceptionManager.HandleException(err, source, message);
				out.print(errorPage);
				return;
			}
			Date newDate = null;
			try {
				newDate = hire_dateFormate.parse(emp_HireDate);
			} catch (ParseException err) {
				message += " Error in Hire Date input </p>";
				String errorPage = ExceptionManager.HandleException(err, source, message);
				out.print(errorPage);
				return;
			}
			try {
				Validator.CheckNofutureDate(newDate);
			} catch (InvalidInputDataException err) {
				message += " Error in Hire Date input </p>";
				String errorPage = ExceptionManager.HandleException(err, source, message);
				out.print(errorPage);
				return;
			}

			newemp.setHire_date(newDate);
//----------------------------------------
			String jobId = request.getParameter("jobid");
			try {
				Validator.checkjob(jobId);
			} catch (InvalidInputDataException err) {
				message += " Error in Job id input </p>";
				String errorPage = ExceptionManager.HandleException(err, source, message);
				out.print(errorPage);
				return;
			}
			newemp.setJob_id(jobId);
//---------------------------------------			
			String sal = request.getParameter("salary");
			try {
				Validator.checkStringForParseFloat(sal);
			} catch (InvalidInputDataException err) {
				message += " Error in Job id input </p>";
				String errorPage = ExceptionManager.HandleException(err, source, message);
				out.print(errorPage);
				return;
			}
			float salParse = Float.parseFloat(sal);
			try {
				Validator.checkSalLimit(salParse);
			} catch (InvalidInputDataException err) {
				message += " Error in Salry input </p>";
				String errorPage = ExceptionManager.HandleException(err, source, message);
				out.print(errorPage);
				return;
			}
			newemp.setSalary(salParse);
//----------------------------------------------			
			result = EmployeeDao.insertEmployee(newemp);
		} catch (Exception err) {
			message += " Error in Inserting the input </p>";
			String errorPage = ExceptionManager.HandleException(err, source, message);
			out.print(errorPage);
		}
	    request.setAttribute("result",result);
		RequestDispatcher rd = request.getRequestDispatcher("/addemployee.jsp");
		rd.forward(request, response);
	}

}