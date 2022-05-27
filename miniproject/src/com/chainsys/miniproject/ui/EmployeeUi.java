package com.chainsys.miniproject.ui;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.chainsys.miniproject.commonutil.InvalidInputDataException;
import com.chainsys.miniproject.commonutil.Validator1;
import com.chainsys.miniproject.dao.EmployeesDao;
import com.chainsys.miniproject.pojo.Employees;

public class EmployeeUi {
	
	
	public static void addNewEmployee() {
		Scanner sc = new Scanner(System.in);
		Employees newemp = null;
		int result = 0;
		int empId = 0;
		String testname = null;
		try {
			newemp = new Employees();

			System.out.println("Enter Employee Id: ");
			String id = sc.nextLine();
			try {
				Validator1.checkStringForParse(id);
			} catch (InvalidInputDataException err) {
				err.printStackTrace();
			}
			empId = Integer.parseInt(id);
			try {
				Validator1.CheckNumberForGreaterThanZero(empId);
			} catch (InvalidInputDataException err) {
				err.printStackTrace();
			}
			newemp.setEmp_Id(empId);
//--------------------------------
			System.out.println("Enter Employee FirstName: ");
			String fname = sc.nextLine();
			testname = fname;
			try {
				Validator1.checkStringOnly(testname);
			} catch (InvalidInputDataException e) {
				e.printStackTrace();
				return;
			}
			try {
				Validator1.checklengthOfString(fname);
			} catch (InvalidInputDataException err) {
				err.printStackTrace();
			}
			newemp.setFirst_name(fname);
//-----------------------------------
			System.out.println("Enter Employee lastName: ");
			String lname = sc.nextLine();
			testname = fname;
			try {
				Validator1.checkStringOnly(testname);
			} catch (InvalidInputDataException e) {
				e.printStackTrace();
				return;
			}
			try {
				Validator1.checklengthOfString(lname);
			} catch (InvalidInputDataException err) {
				err.printStackTrace();
			}
			newemp.setLast_name(lname);
//----------------------------------
			System.out.println("Enter Employee Email: ");
			String email = sc.nextLine();
			try {
				Validator1.checkMail(email);
			} catch (InvalidInputDataException e) {
				e.printStackTrace();
				return;
			}
			newemp.setEmail(email);
//--------------------------------------
			/*
			 * System.out.println("Enter Employee hire_date like \"dd/mm/yyyy\":");
			 * SimpleDateFormat hire_dateFormat = new SimpleDateFormat("dd/MM/yyyy"); String
			 * emp_HireDate = sc.nextLine(); // Date
			 * hire_date=hire_dateFormate.parse(emp_HireDate);
			 * 
			 * try { Validator1.checkDateFormat(emp_HireDate); } catch
			 * (InvalidInputDataException e) { e.printStackTrace(); } java.sql.Date newDate
			 * = null; try { newDate = (java.sql.Date) hire_dateFormat.parse(emp_HireDate);
			 * } catch (ParseException e) { e.printStackTrace(); } try {
			 * Validator1.CheckNofutureDate(newDate); } catch (InvalidInputDataException e)
			 * { e.printStackTrace(); }
			 * 
			 * newemp.setHire_date(newDate);
			 */
//----------------------------------------

			System.out.println("Enter Employee hire_date like \"dd/mm/yyyy\":");
			SimpleDateFormat hire_dateFormat = new SimpleDateFormat("dd/mm/yyyy");
			String emp_HireDate = sc.nextLine();
// Date hire_date=hire_dateFormate.parse(emp_HireDate);

			try {
				Validator1.checkDate(emp_HireDate);
			} catch (InvalidInputDataException e) {
				e.printStackTrace();
			}
			Date newDate =null;
			try {
				newDate=hire_dateFormat.parse(emp_HireDate);
			}
			catch(ParseException e)
			{
				e.printStackTrace();
			}
			/*
			 * try { newDate = (java.sql.Date) hire_dateFormat.parse(emp_HireDate); } catch
			 * (ParseException e) { e.printStackTrace(); } /*try {
			 * Validator1.CheckNofutureDate(newDate); } catch (InvalidInputDataException e)
			 * { e.printStackTrace(); }
			 */
			newemp.setHire_date(newDate);
//-----------------------------------------------------------------------------
			System.out.println("Enter Employee JobId: ");
			String jobId = sc.nextLine();
			try {
				Validator1.checkjob(jobId);
			} catch (InvalidInputDataException err) {
				err.printStackTrace();
			}
			newemp.setJob_id(jobId);
//---------------------------------------
			System.out.println("Enter Employee Salary: ");
			String sal = sc.nextLine();
			try {
				Validator1.checkStringForParseFloat(sal);
			} catch (InvalidInputDataException err) {
				err.printStackTrace();
			}
			float salParse = Float.parseFloat(sal);
			try {
				Validator1.checkSalLimit(salParse);
			} catch (InvalidInputDataException err) {
				err.printStackTrace();
			}
			newemp.setSalary(salParse);
//----------------------------------------------
			result = EmployeesDao.insertEmployees(newemp);
			System.out.println(result + " Added Successfully");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sc.close();
		}
	}

	public static void UpdateEmployee() {
		Scanner sc = new Scanner(System.in);
		Employees newemp = new Employees();
		int result = 0;
		try {

			System.out.println("Enter Employee Id: ");
			String id = sc.nextLine();
			try {
				Validator1.checkStringForParse(id);
			} catch (InvalidInputDataException err) {
				err.printStackTrace();
			}
			int empId = Integer.parseInt(id);
			try {
				Validator1.CheckNumberForGreaterThanZero(empId);
			} catch (InvalidInputDataException err) {
				err.printStackTrace();
			}
			newemp.setEmp_Id(empId);
//--------------------------------
			System.out.println("Enter Employee FirstName: ");
			String fname = sc.nextLine();
			try {
				Validator1.checkStringOnly(fname);
			} catch (InvalidInputDataException e) {
				e.printStackTrace();
				return;
			}
			try {
				Validator1.checklengthOfString(fname);
			} catch (InvalidInputDataException err) {
				err.printStackTrace();
			}
			newemp.setFirst_name(fname);
//-----------------------------------
			System.out.println("Enter Employee lastName: ");
			String lname = sc.nextLine();
			try {
				Validator1.checkStringOnly(fname);
			} catch (InvalidInputDataException e) {
				e.printStackTrace();
				return;
			}
			try {
				Validator1.checklengthOfString(lname);
			} catch (InvalidInputDataException err) {
				err.printStackTrace();
			}
			newemp.setLast_name(lname);
//----------------------------------
			System.out.println("Enter Employee Email: ");
			String email = sc.nextLine();
			try {
				Validator1.checkMail(email);
			} catch (InvalidInputDataException e) {
				e.printStackTrace();
				return;
			}
			newemp.setEmail(email);
//--------------------------------------
			System.out.println("Enter Employee hire_date like \"dd/mm/yyyy\":");
			SimpleDateFormat hire_dateFormate = new SimpleDateFormat("dd/MM/yyyy");
			String emp_HireDate = sc.nextLine();
// Date hire_date=hire_dateFormate.parse(emp_HireDate);

			try {
				Validator1.checkDateFormat(emp_HireDate);
			} catch (InvalidInputDataException e) {
				e.printStackTrace();
			}
			Date newDate = null;
			try {
				newDate = hire_dateFormate.parse(emp_HireDate);
			} catch (ParseException e) {
				e.printStackTrace();
			}

			newemp.setHire_date(newDate);
//----------------------------------------
			System.out.println("Enter Employee JobId: ");
			String jobId = sc.nextLine();
			try {
				Validator1.checkjob(jobId);
			} catch (InvalidInputDataException err) {
				err.printStackTrace();
			}
			newemp.setJob_id(jobId);
//---------------------------------------
			System.out.println("Enter Employee Salary: ");
			String sal = sc.nextLine();
			try {
				Validator1.checkStringForParseFloat(sal);
			} catch (InvalidInputDataException err) {
				err.printStackTrace();
			}
			float salParse = Float.parseFloat(sal);
			try {
				Validator1.checkSalLimit(salParse);
			} catch (InvalidInputDataException err) {
				err.printStackTrace();
			}
			newemp.setSalary(salParse);
//----------------------------------------------
			result = EmployeesDao.updateEmployees(newemp);
			System.out.println(result + " Updated Successfully");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sc.close();
		}
	}

	public static void updateFirstnameOfEmployee() {
		Scanner sc = new Scanner(System.in);
		int result = 0;
		String id = null;
		String fname = null;
		try {
			System.out.println("Enter Employee Id: ");
			id = sc.nextLine();
			try {
				Validator1.checkStringForParse(id);
			} catch (InvalidInputDataException err) {
				err.printStackTrace();
			}
			int empId = Integer.parseInt(id);
			try {
				Validator1.CheckNumberForGreaterThanZero(empId);
			} catch (InvalidInputDataException err) {
				err.printStackTrace();
			}
			Employees emp = EmployeesDao.getEmployeesById(empId);
			emp.setEmp_Id(empId);
			System.out.println("Enter Employee FirstName: ");
			fname = sc.nextLine();
			try {
				Validator1.checkStringOnly(fname);
			} catch (InvalidInputDataException e) {
				e.printStackTrace();
				return;
			}
			try {
				Validator1.checklengthOfString(fname);
			} catch (InvalidInputDataException err) {
				err.printStackTrace();
			}
			result = EmployeesDao.updateEmployeesFirstName(empId, fname);
			System.out.println(result + " updated Successfully");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sc.close();
		}
	}

	public static void updateSalaryOfEmployee() {
		Scanner sc = new Scanner(System.in);
		int result = 0;
		String id = null;
		String salary = null;
		try {
			System.out.println("Enter Employee Id: ");
			id = sc.nextLine();
			try {
				Validator1.checkStringForParse(id);
			} catch (InvalidInputDataException err) {
				err.printStackTrace();
			}
			int empId = Integer.parseInt(id);
			try {
				Validator1.CheckNumberForGreaterThanZero(empId);
			} catch (InvalidInputDataException err) {
				err.printStackTrace();
			}
			System.out.println("Enter Salary: ");
			salary = sc.nextLine();
			try {
				Validator1.checkStringForParseFloat(salary);
			} catch (InvalidInputDataException err) {
				err.printStackTrace();
			}
			float salParse = Float.parseFloat(salary);
			try {
				Validator1.checkSalLimit(salParse);
			} catch (InvalidInputDataException err) {
				err.printStackTrace();
			}

			result = EmployeesDao.updateEmployeesSalary(empId, salParse);
			System.out.println(result + " updated Successfully");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sc.close();
		}
	}

	public static void deleteEmployee() {
		Scanner sc = new Scanner(System.in);
		int result = 0;
		String id = null;
		try {
			System.out.println("Enter Employee Id: ");
			id = sc.nextLine();
			try {
				Validator1.checkStringForParse(id);
			} catch (InvalidInputDataException err) {
				err.printStackTrace();
			}
			int empId = Integer.parseInt(id);
			try {
				Validator1.CheckNumberForGreaterThanZero(empId);
			} catch (InvalidInputDataException err) {
				err.printStackTrace();
			}
			result = EmployeesDao.deleteEmployees(empId);
			System.out.println(result + " Deleted Successfully");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sc.close();
		}
	}

	public static void fetchEmployeeById() {
		Scanner sc = new Scanner(System.in);
		Employees result = new Employees();
		try {
			System.out.println("Enter Employee Id: ");
			String id = sc.nextLine();
			try {
				Validator1.checkStringForParse(id);
			} catch (InvalidInputDataException err) {
				err.printStackTrace();
			}
			int empId = Integer.parseInt(id);
			try {
				Validator1.CheckNumberForGreaterThanZero(empId);
			} catch (InvalidInputDataException err) {
				err.printStackTrace();
			}

			result = EmployeesDao.getEmployeesById(empId);
			System.out.println("Employee id: " + result.getEmp_Id() + "\n" + "Employee first name: "
					+ result.getFirst_name() + "\n" + "Employee last name: " + result.getLast_name() + "\n"
					+ "Employee email: " + result.getEmail() + "\n" + "Employee hiredate: " + result.getHire_date()
					+ "\n" + "Employee job id: " + result.getJob_id() + "\n" + "Employee salary: " + result.getSalary()
					+ "\n");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sc.close();
		}
	}// EMPLOYEE_ID,FIRST_NAME,LAST_NAME,EMAIL,HIRE_DATE,JOB_ID,SALARY

	public static void fetchAllEmployee() {
		List<Employees> allEmployees = EmployeesDao.getAllEmployees();
		Iterator<Employees> empIterator = allEmployees.iterator();
		while (empIterator.hasNext()) {
			Employees result = empIterator.next();
			System.out.println("Employee id: " + "\t" + "Employee first name: " + "\t" + "Employee last name: " + "\t"
					+ "Employee email: " + "\t" + "Employee hiredate: " + "\t" + "Employee job id: " + "\t"
					+ "Employee salary: " + "\t");
			System.out.println(
					"---------------------------------------------------------------------------------------------------");
			System.out.println(result.getEmp_Id() + "\t" + result.getFirst_name() + "\t" + result.getLast_name() + "\t"
					+ result.getEmail() + "\t" + result.getHire_date() + "\t" + result.getJob_id() + "\t"
					+ result.getSalary());
		}
	}

}
