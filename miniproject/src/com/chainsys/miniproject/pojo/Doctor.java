package com.chainsys.miniproject.pojo;
import java.util.Date;
public class Doctor{
	private int Id;
	private String Name;
	private Date DOB;
	private String Speciality;
	private String City;
	private long Phone_no;
	private float Standard_fees;
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public Date getDOB() {
		return DOB;
	}
	public void setDOB(Date dOB) {
		DOB = dOB;
	}
	public String getSpeciality() {
		return Speciality;
	}
	public void setSpeciality(String speciality) {
		Speciality = speciality;
	}
	public String getCity() {
		return City;
	}
	public void setCity(String city) {
		City = city;
	}
	public long getPhone_no() {
		return Phone_no;
	}
	public void setPhone_no(long phone_no) {
		Phone_no = phone_no;
	}
	public float getStandard_fees() {
		return Standard_fees;
	}
	public void setStandard_fees(float standard_fees) {
		Standard_fees = standard_fees;
	}
	    
}
	   