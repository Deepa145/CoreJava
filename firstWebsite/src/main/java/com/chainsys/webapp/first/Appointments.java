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
import com.chainsys.miniproject.dao.AppointmentDao;
import com.chainsys.miniproject.pojo.Appointment;


/**
 * Servlet implementation class Appointment
 */
public class Appointments extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Appointments() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
        List<Appointment> applist =AppointmentDao.getAllAppoinments();
		Iterator<Appointment> appItr=applist.iterator();
		
			response.setContentType("text/html");
			out.print("<html><head><title><Appointments</title></head><body>");
			out.print("<table border=1px bgcolor=\"DodgerBlue\" width=50%>");
			out.print( "<tr bgcolor=\"DarkSlateBlue\" align=center>");
			out.print("<th height=\"10\" width=\"90\">App_id:</th>");
			out.print("<th height=\"10\" width=\"90\">Doc_id:</th>");
			out.print("<th height=\"10\" width=\"90\">Patient_name:</th>");
		while(appItr.hasNext()) {
			out.print("<tr align=center>");
			Appointment app=appItr.next();
			out.print("<td bgcolor=\"DeepSkyBlue\">"+app.getAppoint_Id()+"</td>");
			out.print("<td bgcolor=\"DeepSkyBlue\">"+app.getDoc_Id()+"</td>");
			out.print("<td bgcolor=\"DeepSkyBlue\">"+app.getPatient_Name()+"</td>");
			out.print("</tr>");			
		}}
		

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameter("change").equals("ADD")) {
		PrintWriter out=response.getWriter();
		Appointment app = new Appointment();
		String app_id = request.getParameter("id");
		try {
			Validator1.checkStringForParse(app_id);
		}catch(InvalidInputDataException e) {
			e.printStackTrace();
			//System.exit(-1);
			
		}
		int id=Integer.parseInt(app_id);
		try {
			Validator1.CheckNumberForGreaterThanZero(id);
		}catch(InvalidInputDataException e) {
			e.printStackTrace();
			//System.exit(-1);
		}

		app.setAppoint_Id(id);
		
		SimpleDateFormat appFormate = new SimpleDateFormat("dd/MM/yyyy");
		String app_date = request.getParameter("appdate");
		try {
			Validator1.checkDate(app_date);
			//Validator1.checkDateFormat(app_date);
		}catch(InvalidInputDataException e) {
			e.printStackTrace();
			//System.exit(-1);
		}
		try {
			app.setAppoint_Date(appFormate.parse(app_date));
		} catch (ParseException e) {
			e.printStackTrace();
			//System.exit(-1);
		}
		String doc_Id = request.getParameter("docid");
		try {
			Validator1.checkStringForParse(doc_Id);
		}catch(InvalidInputDataException e) {
			e.printStackTrace();
			//System.exit(-1);
		}
		int doctor_id=Integer.parseInt(doc_Id);
		try {
			Validator1.CheckNumberForGreaterThanZero(doctor_id);
		}catch(InvalidInputDataException e) {
			e.printStackTrace();
			//System.exit(-1);
		}
		app.setDoc_Id(doctor_id);
		
		String patient = request.getParameter("name");
		try {
			Validator1.checkStringOnly(patient);
		}catch(InvalidInputDataException e) {
			e.printStackTrace();
			//System.exit(-1);
		}
		app.setPatient_Name(patient);
		String fees_collected = request.getParameter("fees");
		try {
			Validator1.checkStringForParse(fees_collected);
		}catch(InvalidInputDataException e) {
			e.printStackTrace();
			//System.exit(-1);
		}
		int fees=Integer.parseInt(fees_collected);
		
		try {
			Validator1.CheckNumberForGreaterThanZero(fees);
		}catch(InvalidInputDataException e) {
			e.printStackTrace();
			//System.exit(-1);
		}
		app.setFees_Collected(fees);
//		String fees_cat = request.getParameter("feesCat");
//		try {
//			Validator1.checkStringOnly(fees_cat);
//		}catch(InvalidInputDataException e) {
//			e.printStackTrace();
//			System.exit(-1);
//		}
//		app.setFees_category(fees_cat);
		int result = AppointmentDao.insertAppointment(app);
		out.println("Insert New Appointment Details:"+result + "row inserted");
		try {
			out.close();
		}catch(Exception e) {
			e.printStackTrace();
			//System.exit(-1);
		}
		}else if(request.getParameter("change").equals("UPDATE")) {
			doPut(request,response);
		}else if(request.getParameter("change").equals("DELETE")) {
			doDelete(request,response);
		}
		
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		Appointment app = new Appointment();
		String app_id = request.getParameter("id");
		try {
			Validator1.checkStringForParse(app_id);
		}catch(InvalidInputDataException e) {
			e.printStackTrace();
			System.exit(-1);
			
		}
		int id=Integer.parseInt(app_id);
		try {
			Validator1.CheckNumberForGreaterThanZero(id);
		}catch(InvalidInputDataException e) {
			e.printStackTrace();
			System.exit(-1);
		}

		app.setAppoint_Id(id);
		
		SimpleDateFormat appFormate = new SimpleDateFormat("dd/MM/yyyy");
		String app_date = request.getParameter("appdate");
		try {
			Validator1.checkDate(app_date);
			Validator1.checkDateFormat(app_date);
		}catch(InvalidInputDataException e) {
			e.printStackTrace();
			System.exit(-1);
		}
		try {
			app.setAppoint_Date(appFormate.parse(app_date));
		} catch (ParseException e) {
			e.printStackTrace();
			System.exit(-1);
		}
		String doc_Id = request.getParameter("docid");
		try {
			Validator1.checkStringForParse(doc_Id);
		}catch(InvalidInputDataException e) {
			e.printStackTrace();
			System.exit(-1);
		}
		int doctor_id=Integer.parseInt(doc_Id);
		try {
			Validator1.CheckNumberForGreaterThanZero(doctor_id);
		}catch(InvalidInputDataException e) {
			e.printStackTrace();
			System.exit(-1);
		}
		app.setDoc_Id(doctor_id);
		
		String patient = request.getParameter("name");
		try {
			Validator1.checkStringOnly(patient);
		}catch(InvalidInputDataException e) {
			e.printStackTrace();
			System.exit(-1);
		}
		app.setPatient_Name(patient);
		String fees_collected = request.getParameter("fees");
		try {
			Validator1.checkStringForParse(fees_collected);
		}catch(InvalidInputDataException e) {
			e.printStackTrace();
			System.exit(-1);
		}
		int fees=Integer.parseInt(fees_collected);
		
		try {
			Validator1.CheckNumberForGreaterThanZero(fees);
		}catch(InvalidInputDataException e) {
			e.printStackTrace();
			System.exit(-1);
		}
		app.setFees_Collected(fees);
//		String fees_cat = request.getParameter("feesCat");
//		try {
//			Validator1.checkStringOnly(fees_cat);
//		}catch(InvalidInputDataException e) {
//			e.printStackTrace();
//			System.exit(-1);
//		}
//		app.setFees_category(fees_cat);
		int result = AppointmentDao.updateAppointment(app);
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
		String app_id=request.getParameter("id");
		try {
			Validator1.checkStringForParse(app_id);
		}catch(InvalidInputDataException e) {
			e.printStackTrace();
			System.exit(-1);
		}
		int id=Integer.parseInt(app_id);
		int result = AppointmentDao.deleteAppointment(id);
		out.println(result+"row deleted");
		try {
			out.close();
		}catch(Exception e) {
			e.printStackTrace();
			System.exit(-1);
		}
	}

}
