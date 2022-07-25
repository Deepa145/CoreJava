package com.chainsys.springmvc.pojo;

import java.util.Date;

import java.util.Date;
/**
 * 
 * @author shan3102
 * created on 13/5/2022
 * POJO is a simple class with private variables and its getter and setter;
 * 
 */
public class Employee {

	private int emp_id;
	private String first_name;
	private String last_name;
	private String email;
	private Date hire_date;
	private String job_id;
	private float salary;

	public int getEmp_id() {
		return emp_id;
	}

	public void  setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getHire_date() {
		return hire_date;
	}

	public void setHire_date(Date hire_date) {
		this.hire_date = hire_date;
	}

	public String getJob_id() {
		return job_id;
	}

	public void setJob_id(String job_id) {
		this.job_id = job_id;
	}

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}

}