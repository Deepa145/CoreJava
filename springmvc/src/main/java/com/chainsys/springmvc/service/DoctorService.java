package com.chainsys.springmvc.service;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chainsys.springmvc.employeedao.AppointmentRepository;
import com.chainsys.springmvc.employeedao.DoctorRepository;
import com.chainsys.springmvc.pojo.Appointment;
import com.chainsys.springmvc.pojo.Doctor;
import com.chainsys.springmvc.pojo.DoctorAppointmentsDTO;

@Service
public class DoctorService {
    
    @Autowired
    private DoctorRepository repo;
   @Autowired
    private AppointmentRepository apprepo;
    public List<Doctor> getallDoctors() {
        List<Doctor> listDr = repo.findAll();
        return listDr;
    }
   // @Transactional
    public Doctor save(Doctor dr) {
        return repo.save(dr);
    }
    public Doctor findById(int id) {
        return repo.findById(id);
    }
    @Transactional
    public void deleteById(int id) {
        repo.deleteById(id);
    }
    public List<Doctor> getDoctors() {
        List<Doctor> listDr = repo.findAll();
        return listDr;
    }
@Transactional    
public DoctorAppointmentsDTO getDoctorAndAppointments(int id)
    {
    	Doctor dr=findById(id);
    	DoctorAppointmentsDTO dto=new DoctorAppointmentsDTO();
    	dto.setDoctor(dr);
    	for(int i=0;i<=5;i++)
    	{
    		Appointment app=new Appointment();
    		app.setAppoint_id(i);
    		Date dt=new Date(22,7,25);
    		app.setAppoint_date(dt);
    		app.setId(id);
    		app.setPatient_name("Deepa");
    		app.setFees_collected(i*5);
    		dto.addAppointment(app);
    		
    	}
    	return dto;
    }
    public void addDoctorAndAppointments(DoctorAppointmentsDTO dto)
    {
    	Doctor dr=dto.getDoctor();
    	save(dr);
    	List<Appointment> appointmentList=dto.getAppointments();
    	int count=appointmentList.size();
    	for(int i=0;i<count;i++)
    	{
    	apprepo.save(appointmentList.get(i));
    	}
    }
//    public int getNextAppointmentId()
//    {
//    	return repo.getNextId();
//    }
}