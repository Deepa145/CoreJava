
package com.chainsys.webapp.first;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.miniproject.commonutil.InvalidInputDataException;
import com.chainsys.miniproject.commonutil.LogManager;
import com.chainsys.miniproject.commonutil.Validator1;
import com.chainsys.miniproject.dao.EmployeesDao;
import com.chainsys.miniproject.pojo.Employees;
import com.chainsys.miniproject.commonutil.ExceptionManager;
import com.chainsys.miniproject.commonutil.HTMLHelper;

/**
 * Servlet implementation class Employees
 */
public class Employees1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Employees1() {
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
		PrintWriter out = response.getWriter();
		List<Employees> allEmployees = EmployeesDao.getAllEmployees();
		Iterator<Employees> empIterator = allEmployees.iterator();
		while (empIterator.hasNext()) {
			Employees result = empIterator.next();
			out.println("<hr/>");// in emp

			out.println(result.getEmp_Id() + "," + result.getFirst_name() + "," + result.getLast_name() + ","
					+ result.getEmail() + "," + result.getHire_date() + "," + result.getJob_id() + ","
					+ result.getSalary() + "</p>");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String submitvalue = request.getParameter("submit");
		String source = "AddNewEmployee";
		String message = "<h1>Error while" + source + "</h1>";
		if (submitvalue.equals("UPDATE")) {
			doPut(request, response);
		} else if (submitvalue.equals("DELETE")) {
			doDelete(request, response);
		} else if (submitvalue.equals("ADD")) {
			Employees newemp = null;
			int result = 0;
			int empId = 0;
			String testname = null;
			try {
				newemp = new Employees();
				String id = request.getParameter("id");
				try {
					Validator1.checkStringForParse(id);
				} catch (InvalidInputDataException e) {
					message += " Error in Employee id input </p>";
					String errorPage = ExceptionManager.handleException(e, source, message);
					out.print(errorPage);
					return; // It terminates the Code execution beyond this point
				}
				empId = Integer.parseInt(id);
				try {
					Validator1.CheckNumberForGreaterThanZero(empId);
				} catch (InvalidInputDataException e) {
					message += " Error in Employee id input </p>";
					String errorPage = ExceptionManager.handleException(e, source, message);
					out.print(errorPage);
					return;
				}
				newemp.setEmp_Id(empId);
//--------------------------------
				String fname = request.getParameter("fname");
				testname = fname;
				try {
					Validator1.checkStringOnly(testname);
				} catch (InvalidInputDataException e) {
					message += " Error in First Name input </p>";
					String errorPage = ExceptionManager.handleException(e, source, message);
					out.print(errorPage);
					return;
				}
//				try {
//					Validator1.checklengthOfString(fname);
//				} catch (InvalidInputDataException err) {
//					err.printStackTrace();
//				}
				newemp.setFirst_name(fname);
//-----------------------------------
				String lname = request.getParameter("lname");
				//testname = fname;
				try {
					Validator1.checkStringOnly(testname);
				} catch (InvalidInputDataException e) {
					message +=" Error in Last Name input </p>";
					String errorPage=ExceptionManager.handleException(e, source, message);
					out.print(errorPage);
					return;
				}
//				try {
//					Validator1.checklengthOfString(lname);
//				} catch (InvalidInputDataException e) {
//					message +=" Error in Last Name input </p>";
//					String errorPage=ExceptionManager.handleException(e, source, message);
//					out.print(errorPage);
//				}
				newemp.setLast_name(lname);
//----------------------------------
				String email = request.getParameter("email");
				try {
					Validator1.checkMail(email);
				} catch (InvalidInputDataException e) {
					message +=" Error in Email input </p>";
					String errorPage=ExceptionManager.handleException(e, source, message);
					out.print(errorPage);
					return;
				}
				newemp.setEmail(email);
//--------------------------------------
				SimpleDateFormat hire_dateFormate = new SimpleDateFormat("dd/MM/yyyy");
				String emp_HireDate = request.getParameter("hdate");
// Date hire_date=hire_dateFormate.parse(emp_HireDate);

				try {
					Validator1.checkDateFormat(emp_HireDate);
				} catch (InvalidInputDataException e) {
					message +=" Error in HireDate input </p>";
					String errorPage=ExceptionManager.handleException(e, source, message);
					out.print(errorPage);
					return;
				}
				Date newDate = null;
				try {
					newDate = hire_dateFormate.parse(emp_HireDate);
				} catch (ParseException e) {
					message +=" Error in HireDate input </p>";
					String errorPage=ExceptionManager.handleException(e, source, message);
					out.print(errorPage);
					return;
				}
//try {
//Validator1.CheckNofutureDate(newDate);
//} catch (InvalidInputDataException e) {
//e.printStackTrace();
//}

				newemp.setHire_date(newDate);
//----------------------------------------
				String jobId = request.getParameter("jobid");
				try {
					Validator1.checkjob(jobId);
				} catch (InvalidInputDataException e) {
					message +=" Error in JobId input </p>";
					String errorPage=ExceptionManager.handleException(e, source, message);
					out.print(errorPage);
					return;
				}
				newemp.setJob_id(jobId);
//---------------------------------------
				String sal = request.getParameter("salary");
				try {
					Validator1.checkStringForParse(sal);
				} catch (InvalidInputDataException e) {
					message +=" Error in Salary input </p>";
					String errorPage=ExceptionManager.handleException(e, source, message);
					out.print(errorPage);
					return;
				}
				float salParse = Float.parseFloat(sal);
				try {
					Validator1.checkSalLimit(salParse);
				} catch (InvalidInputDataException e) {
					message +=" Error in Inserting input </p>";
					String errorPage=ExceptionManager.handleException(e, source, message);
					out.print(errorPage);
					return;
				}
				newemp.setSalary(salParse);
//----------------------------------------------
				result = EmployeesDao.insertEmployees(newemp);
			} catch (Exception e) {
				message +="Message: "+e.getMessage();
				String errorPage=ExceptionManager.handleException(e, source, message);
				out.print(errorPage);
				return;
			} finally {
			}
			out.println("<div> Add New Employee: " + result + "</div>");
		}
	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		Employees newemp = null;
		int result = 0;
		int empId = 0;
		String testname = null;
		try {
			newemp = new Employees();
			String id = request.getParameter("id");
			try {
				Validator1.checkStringForParse(id);
			} catch (InvalidInputDataException e) {
				System.out.println("Error:" + e.getMessage());

			}
			empId = Integer.parseInt(id);
			try {
				Validator1.CheckNumberForGreaterThanZero(empId);
			} catch (InvalidInputDataException e) {
				out.println("Error in Id:" + e.getMessage());
			}
			newemp.setEmp_Id(empId);
//--------------------------------
			String fname = request.getParameter("fname");
			testname = fname;
			try {
				Validator1.checkStringOnly(testname);
			} catch (InvalidInputDataException e) {
				out.println("Error first name:" + e.getMessage());
				return;
			}
			try {
				Validator1.checklengthOfString(fname);
			} catch (InvalidInputDataException e) {
				out.println("Error first name:" + e.getMessage());
			}
			newemp.setFirst_name(fname);
//-----------------------------------
			String lname = request.getParameter("lname");
			testname = fname;
			try {
				Validator1.checkStringOnly(testname);
			} catch (InvalidInputDataException e) {
				out.println("Error last name:" + e.getMessage());
				return;
			}
			try {
				Validator1.checklengthOfString(lname);
			} catch (InvalidInputDataException e) {
				out.println("Error last name:" + e.getMessage());
			}
			newemp.setLast_name(lname);
//----------------------------------
			String email = request.getParameter("email");
			try {
				Validator1.checkMail(email);
			} catch (InvalidInputDataException e) {
				out.println("Error mail:" + e.getMessage());
				return;
			}
			newemp.setEmail(email);
//--------------------------------------
			SimpleDateFormat hire_dateFormate = new SimpleDateFormat("dd/MM/yyyy");
			String emp_HireDate = request.getParameter("hdate");
// Date hire_date=hire_dateFormate.parse(emp_HireDate);

			try {
				Validator1.checkDateFormat(emp_HireDate);
			} catch (InvalidInputDataException e) {
				out.println("Error hireDate:" + e.getMessage());
			}
			Date newDate = null;
			try {
				newDate = hire_dateFormate.parse(emp_HireDate);
			} catch (ParseException e) {
				out.println("Error hireDate:" + e.getMessage());
			}
//try {
//Validator1.CheckNofutureDate(newDate);
//} catch (InvalidInputDataException e) {
//e.printStackTrace();
//}

			newemp.setHire_date(newDate);
//----------------------------------------
			String jobId = request.getParameter("jobid");
			try {
				Validator1.checkjob(jobId);
			} catch (InvalidInputDataException e) {
				out.println("Error jobid:" + e.getMessage());
			}
			newemp.setJob_id(jobId);
//---------------------------------------
			String sal = request.getParameter("salary");
			try {
				Validator1.checkStringForParse(sal);
			} catch (InvalidInputDataException e) {
				out.println("Error salary:" + e.getMessage());
			}
			float salParse = Float.parseFloat(sal);
			try {
				Validator1.checkSalLimit(salParse);
			} catch (InvalidInputDataException e) {
				out.println("Error salary:" + e.getMessage());
			}
			newemp.setSalary(salParse);
//----------------------------------------------
			result = EmployeesDao.updateEmployees(newemp);
		} catch (Exception e) {
			out.println("Error in some input data:" + e.getMessage());
		} finally {
		}
		out.println("<div> Update Employee: " + result + "</div>");
	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		Employees emp = null;
		int result = 0;
		// int id=0;
		try {
			emp = new Employees();
			String emp_id = request.getParameter("id");
			System.out.println("Enter Employee id:");
			try {
				Validator1.checkStringForParse(emp_id);
			} catch (InvalidInputDataException e) {
				e.printStackTrace();
			}
			int id = Integer.parseInt(emp_id);
			try {
				Validator1.CheckNumberForGreaterThanZero(id);
			} catch (InvalidInputDataException e) {
				out.println("Error in id:" + e.getMessage());
				return;
			}
			emp.setEmp_Id(id);

			result = EmployeesDao.deleteEmployees(id);
		} catch (Exception e) {
			out.println("Error in id:" + e.getMessage());
		} finally {
		}
		out.println("<div> Delete Employee: " + result + "</div>");
	}
}
