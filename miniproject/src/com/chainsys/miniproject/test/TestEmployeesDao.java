package com.chainsys.miniproject.test;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

import com.chainsys.miniproject.dao.EmployeesDao;
import com.chainsys.miniproject.pojo.Employees;


public class TestEmployeesDao {
public static void testGetAllEmployees() {
List<Employees> allEmployees = EmployeesDao.getAllEmployees();
Iterator<Employees> empIterator = allEmployees.iterator();
while(empIterator.hasNext()) {
Employees emp = empIterator.next();
System.out.println(emp.getEmp_Id()+" "+emp.getFirst_name()+" "+emp.getSalary());
}
}
public static void testGetEmployeeById() {
Employees emp = EmployeesDao.getEmployeesById(126);
System.out.println(emp.getEmp_Id()+" "+emp.getFirst_name()+" "+emp.getSalary());
}
public static void testInsertEmployee() {
Employees newemp = new Employees();
newemp.setEmp_Id(300);
newemp.setFirst_name("Ana");
newemp.setLast_name("Rose");
newemp.setEmail("ana23@mail.com");
Calendar c1 = Calendar.getInstance();
java.util.Date newDate =c1.getTime();
newemp.setHire_date(newDate);
newemp.setJob_id("IT_PROG");
newemp.setSalary(240000);
int result = EmployeesDao.insertEmployees(newemp);
System.out.println(result);

}
public static void testUpdateEmployee() {
Employees oldEmployee = EmployeesDao.getEmployeesById(126);
System.out.println(oldEmployee.getEmp_Id()+" "+oldEmployee.getFirst_name()+" "+oldEmployee.getSalary());
oldEmployee.setFirst_name("Little");
oldEmployee.setLast_name("Joe");
oldEmployee.setEmail("Jeolil@mail.com");
Calendar c1 = Calendar.getInstance();
java.util.Date newDate =c1.getTime();
oldEmployee.setHire_date(newDate);
oldEmployee.setJob_id("IT_PROG");
oldEmployee.setSalary(240000);
int result = EmployeesDao.updateEmployees(oldEmployee);
System.out.println(result);

}
public static void testDeleteEmployee() {
int result = EmployeesDao.deleteEmployees(126);
System.out.println(result);
   }
}
