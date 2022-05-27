package com.chainsys.webapp.first;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chainsys.miniproject.commonutil.InvalidInputDataException;
import com.chainsys.miniproject.commonutil.Validator1;
import com.chainsys.miniproject.dao.DoctorDao;
import com.chainsys.miniproject.pojo.Doctor;

/**
 * Servlet implementation class Doctors
 */
public class Doctors extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Doctors() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	PrintWriter out=response.getWriter();
        List<Doctor> doclist =DoctorDao.getAllDoctor();
        Iterator<Doctor> docItr=doclist.iterator();
        
        
            response.setContentType("text/html");
            out.print("<html><head><title><Doctors</title></head><body>");
            out.print("<table border=1px bgcolor=\"DodgerBlue\" width=50%>");
            out.print( "<tr bgcolor=\"DarkSlateBlue\" align=center>");
            out.print("<th height=\"10\" width=\"90\">Doc_id:</th>");
            out.print("<th height=\"10\" width=\"90\">Name:</th>");
            out.print("<th height=\"10\" width=\"90\">Speciality:</th>");
            out.print("<th height=\"10\" width=\"90\">City:</th>");
            out.print("<th height=\"10\" width=\"90\">PhoneNo:</th>");
            out.print("<th height=\"10\" width=\"90\">Date:</th>");
            out.print("<th height=\"10\" width=\"90\">StandardFees:</th>");
        while(docItr.hasNext()) {
            out.print("<tr align=center>");
            Doctor doc=docItr.next();
            out.print("<td bgcolor=\"DeepSkyBlue\">"+doc.getId()+"</td>");
            out.print("<td bgcolor=\"DeepSkyBlue\">"+doc.getName()+"</td>");
            out.print("<td bgcolor=\"DeepSkyBlue\">"+doc.getSpeciality()+"</td>");
            out.print("<td bgcolor=\"DeepSkyRed\">"+doc.getCity()+"</td>");
            out.print("<td bgcolor=\"DeepSkyBlue\">"+doc.getPhone_no()+"</td>");
            out.print("<td bgcolor=\"DeepSkyBlue\">"+doc.getDOB()+"</td>");
            out.print("<td bgcolor=\"DeepSkyBlue\">"+doc.getStandard_fees()+"</td>");
            out.print("</tr>");            
        }}
       
    	


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameter("change").equals("ADD")) {
		PrintWriter out=response.getWriter();
		Doctor doc = new Doctor();
		String doc_id = request.getParameter("id");
		try {
			Validator1.checkStringForParse(doc_id);
		}catch(InvalidInputDataException e) {
			e.printStackTrace();
			System.exit(-1);
			
		}
		int doctor_id=Integer.parseInt(doc_id);
		try {
			Validator1.CheckNumberForGreaterThanZero(doctor_id);
		}catch(InvalidInputDataException e) {
			e.printStackTrace();
			System.exit(-1);	
		}
		doc.setId(doctor_id);
		String doc_name = request.getParameter("name");
		try {
			Validator1.checkStringOnly(doc_name);
		}catch(InvalidInputDataException e) {
			e.printStackTrace();
			System.exit(-1);	
		}
		doc.setName(doc_name);
		SimpleDateFormat dobFormate = new SimpleDateFormat("dd/MM/yyyy");
		String Dob = request.getParameter("dob");
		try {
			Validator1.checkDate(Dob);
		}catch(InvalidInputDataException e) {
			e.printStackTrace();
			System.exit(-1);	
		}
		try {
			doc.setDOB(dobFormate.parse(Dob));
		} catch (ParseException e) {
			e.printStackTrace();
			System.exit(-1);
		}
		String speciality = request.getParameter("speciality");
		try {
			Validator1.checkStringOnly(speciality);
		}catch(InvalidInputDataException e) {
			e.printStackTrace();
			System.exit(-1);	
		}
		doc.setSpeciality(speciality);
		String city = request.getParameter("city");
		try {
			Validator1.checkStringOnly(city);
		}catch(InvalidInputDataException e) {
			e.printStackTrace();
			System.exit(-1);	
		}
		doc.setCity(city);
		//---------------------------
		String phone = request.getParameter("phone");
		try {
			Validator1.checkPhone(phone);
		}catch(InvalidInputDataException e) {
			e.printStackTrace();
			System.exit(-1);	
		}
		doc.setPhone_no(Long.parseLong(phone));
		//-----------------------------
		String std_fees = request.getParameter("fees");
		try {
			Validator1.checkStringForParse(std_fees);
		}catch(InvalidInputDataException e) {
			e.printStackTrace();
			System.exit(-1);	
		}
		int fees=Integer.parseInt(std_fees);
		doc.setStandard_fees(fees);
		int result = DoctorDao.insertDoctor(doc);
		out.println(result + "row inserted");
		try {
			out.close();
		}catch(Exception e) {
			e.printStackTrace();
			System.exit(-1);	
		}
		}else if(request.getParameter("change").equals("update")) {
			doPut(request,response);
		}else if(request.getParameter("change").equals("Delete")) {
			doDelete(request,response);
		}

	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		Doctor doc = new Doctor();
		String doc_id = request.getParameter("id");
		try {
			Validator1.checkStringForParse(doc_id);
		}catch(InvalidInputDataException e) {
			e.printStackTrace();
			System.exit(-1);
			
		}
		int doctor_id=Integer.parseInt(doc_id);
		try {
			Validator1.CheckNumberForGreaterThanZero(doctor_id);
		}catch(InvalidInputDataException e) {
			e.printStackTrace();
			System.exit(-1);	
		}
		doc.setId(doctor_id);
		String doc_name = request.getParameter("name");
		try {
			Validator1.checkStringOnly(doc_name);
		}catch(InvalidInputDataException e) {
			e.printStackTrace();
			System.exit(-1);	
		}
		doc.setName(doc_name);
		SimpleDateFormat dobFormate = new SimpleDateFormat("dd/MM/yyyy");
		String Dob = request.getParameter("dob");
		try {
			Validator1.checkDate(Dob);
		}catch(InvalidInputDataException e) {
			e.printStackTrace();
			System.exit(-1);	
		}
		try {
			doc.setDOB(dobFormate.parse(Dob));
		} catch (ParseException e) {
			e.printStackTrace();
			System.exit(-1);
		}
		String speciality = request.getParameter("speciality");
		try {
			Validator1.checkStringOnly(speciality);
		}catch(InvalidInputDataException e) {
			e.printStackTrace();
			System.exit(-1);	
		}
		doc.setSpeciality(speciality);
		String city = request.getParameter("city");
		try {
			Validator1.checkStringOnly(city);
		}catch(InvalidInputDataException e) {
			e.printStackTrace();
			System.exit(-1);	
		}
		doc.setCity(city);
		String phone = request.getParameter("phone");
		try {
			Validator1.checkPhone(phone);
		}catch(InvalidInputDataException e) {
			e.printStackTrace();
			System.exit(-1);	
		}
		doc.setPhone_no(Long.parseLong(phone));
		String std_fees = request.getParameter("fees");
		try {
			Validator1.checkStringForParse(std_fees);
		}catch(InvalidInputDataException e) {
			e.printStackTrace();
			System.exit(-1);	
		}
		int fees=Integer.parseInt(std_fees);
		doc.setStandard_fees(fees);
		int result = DoctorDao.updateDoctor(doc);
		out.println(result + "row Updated");
		try {
			out.close();
		}catch(Exception e) {
			e.printStackTrace();
			System.exit(-1);	
		}
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		String doc_id=request.getParameter("id");
		int result = 1;
		try {
			Validator1.checkStringForParse(doc_id);
		}catch(InvalidInputDataException e) {
			e.printStackTrace();
			System.exit(-1);	
		}
		int id=Integer.parseInt(doc_id);
		result = DoctorDao.deleteDoctor(id);
		out.println(result+"row deleted");
		try {
			out.close();
		}catch(Exception e) {
			e.printStackTrace();
			System.exit(-1);	
		}
	}}



