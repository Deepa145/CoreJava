package com.chainsys.miniproject.pojo;

import java.util.Date;

public class Employees {
private String first_name;
private String last_name;
private String email;
private Date hire_date;
private String job_id;
private float salary;

private int emp_Id;
public int getEmp_Id() {
return emp_Id;
}
public void setEmp_Id(int emp_Id) {
this.emp_Id = emp_Id;
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
