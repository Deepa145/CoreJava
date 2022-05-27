package com.chainsys.miniproject.test;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.chainsys.miniproject.dao.DoctorDao;
import com.chainsys.miniproject.pojo.Doctor;

public class TestDoctorDao {
	public static void testGetAllDoctors() {
		List<Doctor> allDoctors = DoctorDao.getAllDoctor();
		Iterator<Doctor> doctIterator = allDoctors.iterator();
		while(doctIterator.hasNext()) {
			Doctor doct = doctIterator.next();
			System.out.println(doct.getId()+" "+doct.getName()+" "+doct.getCity());
		}
	}
public static void testGetDoctorById() {
	Doctor doct = DoctorDao.getDoctorById(3);
	System.out.println(doct.getId()+" "+doct.getName()+" "+doct.getCity());
}
public static void testInsertDoctor() {
	Doctor newdoct = new Doctor();
	newdoct.setId(1);
	newdoct.setName("Ana");
	Calendar c1 = Calendar.getInstance();
	java.util.Date newDate =c1.getTime();
	newdoct.setDOB(newDate);
	newdoct.setSpeciality("Ortho");
	newdoct.setCity("Salem");
	newdoct.setPhone_no(82204899);
	newdoct.setStandard_fees(24000);
	int result = DoctorDao.insertDoctor(newdoct);
	System.out.println(result);
	
}
public static void testUpdateDoctor() {
	Doctor oldDoct = DoctorDao.getDoctorById(3);
	System.out.println(oldDoct.getId()+" "+oldDoct.getName()+" "+oldDoct.getCity());
	oldDoct.setId(3);
	oldDoct.setName("Anee");
	Calendar c1 = Calendar.getInstance();
	java.util.Date newDate =c1.getTime();
	oldDoct.setDOB(newDate);
	oldDoct.setSpeciality("General");
	oldDoct.setCity("Karur");
	oldDoct.setPhone_no(8222899);
	oldDoct.setStandard_fees(25000);
	int result=DoctorDao.updateDoctor(oldDoct);
	//int result = DoctorDao.updateDoctorStandard_fees(oldDoct);
	System.out.println(result);
	
}
public static void testDeleteDoctor() {
	int result =DoctorDao.deleteDoctor(1);
	System.out.println(result);
}
}