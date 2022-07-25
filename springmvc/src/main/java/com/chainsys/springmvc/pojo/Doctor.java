package com.chainsys.springmvc.pojo;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="Doctor")
public class Doctor {
	@Id
	private int id;                     
	private String name;                
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	private Date dob;                        
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	private String speciality;           
	private String city;                
	private long phone_no;            
	private float standard_fees;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getSpeciality() {
		return speciality;
	}
	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public long getPhone_no() {
		return phone_no;
	}
	public void setPhone_no(long phone_no) {
		this.phone_no = phone_no;
	}
	public float getStandard_fees() {
		return standard_fees;
	}
	public void setStandard_fees(float standard_fees) {
		this.standard_fees = standard_fees;
	}
	@Override
	public String toString() {
		return String.format("%d,%s,%s,%s,%s,%d,%d",id,name,dob,speciality,city,phone_no,standard_fees);
}

}