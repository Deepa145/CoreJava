package com.chainsys.springmvc.pojo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Appointment")
public class Appointment {
@Id
private int appoint_id;
private Date appoint_date;
public int getAppoint_id() {
	return appoint_id;
}
public void setAppoint_id(int appoint_id) {
	this.appoint_id = appoint_id;
}
public Date getAppoint_date() {
	return appoint_date;
}
public void setAppoint_date(Date appoint_date) {
	this.appoint_date = appoint_date;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getPatient_name() {
	return patient_name;
}
public void setPatient_name(String patient_name) {
	this.patient_name = patient_name;
}
public long getFees_collected() {
	return fees_collected;
}
public void setFees_collected(long fees_collected) {
	this.fees_collected = fees_collected;
}
private int id;
private String patient_name;
private long fees_collected;
}
