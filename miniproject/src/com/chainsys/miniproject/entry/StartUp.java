package com.chainsys.miniproject.entry;

import java.text.ParseException;
import com.chainsys.miniproject.commonutil.InvalidInputDataException;
import com.chainsys.miniproject.ui.AppointmentUi;

import com.chainsys.miniproject.ui.DoctorUi;

import com.chainsys.miniproject.ui.EmployeeUi;

public class StartUp {
	public static void main(String[] args) throws InvalidInputDataException, Exception {
		//loadAppointmentMenu();
		//loadDoctorMenu();
		loadMenu();
		
	}
	
	private static void loadMenu() throws InvalidInputDataException, Exception {
        System.out.println("Enter Menu : 1 is EmployeeMenu, 2 is Doctor Menu, 3 is Appointment Menu ");
        java.util.Scanner sc = new java.util.Scanner(System.in);
      try {
        int call = sc.nextInt();
        switch (call) {
        case 1:
        	loadEmployeeMenu();
            break;
        case 2:
            loadDoctorMenu();
            break;
        case 3:
            loadAppointmentMenu();
            break;
        }
      }finally {
          sc.close();
      }
    }
	private static void loadEmployeeMenu() throws InvalidInputDataException, Exception {
        System.out.println(
                "Enter Employee Method :"
                + " 1=addEmployee,"
                + " 2=UpdateEmployee ,"
                + "3=deleteEmployee ,"
                + "4=updateFirstnameOfEmployee, "
+ "5=updateSalaryOfEmployee, "
                + "6=fetchEmployeeById, 7=fetchAllEmployee");
        java.util.Scanner sc = new java.util.Scanner(System.in);
        try {
        int call = sc.nextInt();
        
        switch (call) {
        case 1:
            EmployeeUi.addNewEmployee();
            break;

        case 2:
        	EmployeeUi.UpdateEmployee();
            break;
        case 3:
        	EmployeeUi.deleteEmployee();
            break;
        case 4:
        	EmployeeUi.updateFirstnameOfEmployee();
            break;
        case 5:
        	EmployeeUi.updateSalaryOfEmployee();
            break;
        case 6:
        	EmployeeUi.fetchEmployeeById();
            break;
        case 7:
        	EmployeeUi.fetchAllEmployee();
        	break;
        }
        }finally {
            sc.close();
        }
    }
	private static void loadDoctorMenu() {
		System.out.println(
				"Enter Doctor Method : 1=addNewDoctor ,"
				+ "2=deleteDoctordetails ,"
				+ "3=updateDoctorDetails ,"
				+ "4=ViewAllDoctorDetails, "
				+ "5=viewDoctorDetailsById, ");
		java.util.Scanner sc = new java.util.Scanner(System.in);
		try {
			int call = sc.nextInt();
			switch (call) {
			case 1:
				DoctorUi.addNewDoctor();
				break;
			case 2:
				DoctorUi.deleteDoctordetails();
				break;
			case 3:
				DoctorUi.updateDoctorDetails();
				break;
			case 4:
				DoctorUi.ViewAllDoctorDetails();
				break;
			case 5:
				DoctorUi.viewDoctorDetailsById();
				break;
			}
		} finally {
			sc.close();
		}
	}

	private static void loadAppointmentMenu() {
		System.out.println(
				"Enter Method : 1=addNewAppointment ,"
				+ "2=updateAppointment ,"
				+ "3=allAppointment ,"
				+ "4=viewAppointment ,5=deleteAppointment ");
		java.util.Scanner sc = new java.util.Scanner(System.in);
		try {
			int call = sc.nextInt();
			switch (call) {
			case 1:
				AppointmentUi.addNewAppointments();
				break;

			case 2:
				AppointmentUi.updateAppointmentDetails();
				break;
			case 3:
				AppointmentUi.allAppointmentDetails();
				break;
			case 4:
				AppointmentUi.viewAppointmentDetails();
				break;
			case 5:
				AppointmentUi.deleteAppointmentDetails();
				break;

			}
		} finally {
			sc.close();
		}
	}

}


