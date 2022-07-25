package com.chainsys.springmvc.controller;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chainsys.springmvc.employeedao.DoctorRepository;
import com.chainsys.springmvc.pojo.Appointment;
import com.chainsys.springmvc.pojo.Doctor;
import com.chainsys.springmvc.pojo.DoctorAppointmentsDTO;
import com.chainsys.springmvc.service.DoctorService;

@Controller
@RequestMapping("/doctor")
public class DoctorController {
    @Autowired
    DoctorService drservice;
    @GetMapping("/finddoctorbyid")
    public String findDoctorById(@RequestParam("docid") int id, Model model) {
        Doctor theDoc = drservice.findById(id);
        model.addAttribute("finddoctorbyid", theDoc);
        return "find-doctor-id-form";
    }
    
    @GetMapping("/addform")
    public String showAddForm(Model model) {
        Doctor theDoc = new Doctor();
        model.addAttribute("adddoctors", theDoc);
        return "add-doctor-form";
    }
    
    @PostMapping("/add")
    // We need give from where to read data from the HTTP request and also the content type ("application/json")
    public String addNewDoctor(@ModelAttribute("adddoctors") Doctor dr) {
    	drservice.save(dr);
        return "redirect:/doctor/list";
    }
    
    @GetMapping("/updateform")
    public String showUpdateForm(@RequestParam("id") int docid, Model model) {
        Doctor theDoc = drservice.findById(docid);
        model.addAttribute("updatedoctor", theDoc);
        return "update-doctor-form";
    }
    
    @PostMapping("/updatedoc")
    public String UpdateDoctors(@ModelAttribute("updatedoctor") Doctor theDoc)
    {
    	drservice.save(theDoc);
     return "redirect:/doctor/list";
    }
    
    @GetMapping("/list")
    public String getDoctors(Model model) {
    	List<Doctor> theDoc = drservice.getallDoctors();
    	model.addAttribute("alldoctors", theDoc);
        return "list-doctors";
    }
    
    @GetMapping("/deletedoctor")
    public String deleteDoctor(@RequestParam("id") int docid) {
    	drservice.deleteById(docid);
        return "redirect:/doctor/list";
    }
    @GetMapping("/getdocapp")
    public String getAppointments(@RequestParam("id")int id,Model model)
    {
    	DoctorAppointmentsDTO dto=drservice.getDoctorAndAppointments(id);
    	model.addAttribute("getdoc",dto.getDoctor());
    	model.addAttribute("applist",dto.getAppointments());
    	return "list-doctor-appointment";
    }
    @GetMapping("/trans")
    public void testTransaction(@RequestParam("id") int id)
    {
    	DoctorAppointmentsDTO dto=new DoctorAppointmentsDTO();
    	Doctor dr=new Doctor();
    	dr.setId(789);
    	dr.setName("Gopika");
    	Date dt=new Date(92,7,14);
    	dr.setDob(dt);   	
    	dr.setCity("Chennai");
    	dr.setPhone_no(123456789);
    	dr.setSpeciality("Musucle");
    	dr.setStandard_fees(1000);
    	dto.setDoctor(dr);
    	List<Appointment> applist=new ArrayList<Appointment>();
    //	int nextAppId=drservice.getNextAppointmentId();
    //	for(int i=nextAppId;i<nextAppId;i++)
    	for(int i=200;i<=222;i++)
    	{
    		Appointment app=new Appointment();
    		app.setAppoint_id(i);
    		Date appdt=new Date(22,7,25);
    		app.setAppoint_date(appdt);
    		app.setId(id);
    		app.setPatient_name("Vetri");
    		app.setFees_collected(i*500);
    		dto.addAppointment(app);
    	}
    	drservice.addDoctorAndAppointments(dto);
    	System.out.println("Successfully Completed");
    }
}
