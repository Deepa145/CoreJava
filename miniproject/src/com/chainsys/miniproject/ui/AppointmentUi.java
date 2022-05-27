package com.chainsys.miniproject.ui;

import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.chainsys.miniproject.dao.AppointmentDao;
import com.chainsys.miniproject.pojo.Appointment;

public class AppointmentUi {

	public static void addNewAppointments() {

		Scanner sc = new Scanner(System.in);
		try {
			Appointment app = new Appointment();

			System.out.println("Enter the Appointment id:");
			String app_id = sc.nextLine();
			app.setAppoint_Id(Integer.parseInt(app_id));
			Calendar c1 = Calendar.getInstance();
			java.util.Date newDate = c1.getTime();
			app.setAppoint_Date(newDate);
			System.out.println("Enter Doctor id:");
			String doc_name = sc.nextLine();
			app.setAppoint_Id(Integer.parseInt(doc_name));

			System.out.println("Enter patient Name:");
			String patient = sc.nextLine();
			app.setPatient_Name(patient);

			int result = AppointmentDao.insertAppointment(app);
			System.out.println(result + "row inserted");
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} finally {
			try {
				sc.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static void viewAppointmentDetails() {
		Scanner sc = new Scanner(System.in);
		try {
			System.out.println("Enter the Appointment id:");
			int app_id = sc.nextInt();
			Appointment doc = AppointmentDao.getPatientById(app_id);
			System.out.println("Appointment id:" + doc.getAppoint_Id());
			System.out.println("Appointment date:" + doc.getAppoint_Date());
			System.out.println("Doctor id:" + doc.getAppoint_Id());
			System.out.println("fees Amounts:" + doc.getFees_Collected());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				sc.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static void allAppointmentDetails() {
		List<Appointment> applist = AppointmentDao.getAllAppoinments();
		Iterator<Appointment> appItr = applist.iterator();
		while (appItr.hasNext()) {
			Appointment app = appItr.next();
			System.out.println("app id:" + app.getAppoint_Id() + " " + "DOC ID" + " " + app.getAppoint_Id());
		}
	}

	public static void updateAppointmentDetails() {
		Scanner sc = new Scanner(System.in);
		try {
			Appointment app = new Appointment();

			System.out.println("Enter the Appointment id:");
			String app_id = sc.nextLine();
			app.setAppoint_Id(Integer.parseInt(app_id));

			Calendar c1 = Calendar.getInstance();
			java.util.Date newDate = c1.getTime();
			app.setAppoint_Date(newDate);
			System.out.println("Enter Doctor id:");
			String id = sc.nextLine();
			app.setDoc_Id(Integer.parseInt(id));

			System.out.println("Enter patient Name:");
			String patient_name = sc.nextLine();
			app.setPatient_Name(patient_name);

			System.out.println("Enter the Fees collection :");
			int fees_collection = sc.nextInt();
			app.setFees_Collected(fees_collection);

			int result = AppointmentDao.updateAppointment(app);
			System.out.println(result + "row updated");
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} finally {
			try {
				sc.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static void deleteAppointmentDetails() {
		Scanner sc = new Scanner(System.in);
		try {
			System.out.println("Enter Appointment id:");
			int app_id = sc.nextInt();
			int result = AppointmentDao.deleteAppointment(app_id);
			System.out.println(result + "row deleted");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				sc.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
