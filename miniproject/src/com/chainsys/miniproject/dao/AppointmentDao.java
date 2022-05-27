package com.chainsys.miniproject.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.chainsys.miniproject.pojo.Appointment;
import com.chainsys.miniproject.pojo.Doctor;

public class AppointmentDao {
	public static Connection getConnection() {
		String drivername = "oracle.jdbc.OracleDriver";
		String dbUrl = "jdbc:oracle:thin:@localhost:1521:xe";
		String username = "system";
		String password = "DEEPA";
		try {
			Class.forName(drivername);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Connection con = null;
		try {
			con = DriverManager.getConnection(dbUrl, username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}

	private static java.sql.Date convertTosqlDate(java.util.Date date) {
		java.sql.Date sqldate = new java.sql.Date(date.getTime());
		return sqldate;
	}

	public static int insertAppointment(Appointment newap) {
		String insertquery = "insert into Appointment(appoint_id,appoint_date,doctor_id,patient_name,fees_collected) values (?,?,?,?,?)";
		Connection con = null;
		int rows = 0;
//			int rows ;
		PreparedStatement ps = null;
		try {
			con = getConnection();
			ps = con.prepareStatement(insertquery);
			ps.setInt(1, newap.getAppoint_Id());
			// convert java.util.Date to java.sql.date
			ps.setDate(2, convertTosqlDate(newap.getAppoint_Date()));
			ps.setInt(3, newap.getDoc_Id());
			ps.setString(4, newap.getPatient_Name());
			ps.setInt(5, newap.getFees_Collected());
			rows = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return rows;
	}

	public static int updateAppointment(Appointment newap) {
		String updatequery = "update appointment set appoint_date=?,doctor_id=?,patient_name=?,fees_collected=? where appoint_id=?";
		Connection con = null;
		int rows = 0;
//			int rows ;
		PreparedStatement ps = null;
		try {
			con = getConnection();
			ps = con.prepareStatement(updatequery);
			// convert java.util.Date to java.sql.date
			ps.setDate(1, convertTosqlDate(newap.getAppoint_Date()));
			ps.setInt(2, newap.getDoc_Id());
			ps.setString(3, newap.getPatient_Name());
			ps.setInt(4, newap.getFees_Collected());
			ps.setInt(5, newap.getAppoint_Id());
			rows = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return rows;
	}

	public static int updatePatientName(int id, String name) {
		String updatequery = "update appointment set patient_name=? where appoint_id=?";
		Connection con = null;
		int rows = 0;
//			int rows ;
		PreparedStatement ps = null;
		try {
			con = getConnection();
			ps = con.prepareStatement(updatequery);
			ps.setString(1, name);
			ps.setInt(2, id);
			ps.executeUpdate();
			rows = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return rows;
	}

	public static int updateFeesCollected(int appoint_id, int fees_collected) {
		String updatequery = "update appointment set fees_collected=? where appoint_id=?";
		Connection con = null;
		int rows = 0;
//			int rows ;
		PreparedStatement ps = null;
		try {
			con = getConnection();
			ps = con.prepareStatement(updatequery);
			ps.setInt(1, fees_collected);
			ps.setInt(2, appoint_id);
			rows = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return rows;
	}

	public static int deleteAppointment(int id) {
		String deletequery = "delete from appointment where appoint_id=?";
		Connection con = null;
		int rows = 0;
		PreparedStatement ps = null;

		try {
			con = getConnection();
			ps = con.prepareStatement(deletequery);
			ps.setInt(1, id);
			rows = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return rows;
	}

	public static Appointment getPatientById(int id) {
		Appointment ap = null;
		String selectquery = "select appoint_id,appoint_date,doctor_id,patient_name,fees_collected from appointment where appoint_id=?";// need
																																		// change
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = getConnection();
			ps = con.prepareStatement(selectquery);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			ap = new Appointment();
			while (rs.next()) {
				ap.setAppoint_Id(rs.getInt(1));
				ap.setAppoint_Date(rs.getDate(2));
				// convert java.util.Date to java.sql.date
				ap.setDoc_Id(rs.getInt(3));
				ap.setPatient_Name(rs.getString(4));
				ap.setFees_Collected(rs.getInt(5));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return ap;
	}

	public static List<Appointment> getAllAppoinments() {
		List<Appointment> listOfAppointments = new ArrayList<Appointment>();
		Appointment ap = null;
		String selectquery = "select appoint_id,appoint_date,doctor_id,patient_name,fees_collected from appointment";
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = getConnection();
			ps = con.prepareStatement(selectquery);
			rs = ps.executeQuery();

			while (rs.next()) {
				ap = new Appointment();

				ap.setAppoint_Id(rs.getInt(1));
				ap.setAppoint_Id(rs.getInt(1));
				ap.setAppoint_Date(rs.getDate(2));
				// convert java.util.Date to java.sql.date
				ap.setDoc_Id(rs.getInt(3));
				ap.setPatient_Name(rs.getString(4));
				ap.setFees_Collected(rs.getInt(5));
				listOfAppointments.add(ap);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return listOfAppointments;
	}

	// --------------------------------
	public static List<Appointment> getInnerJoinDoctorAndAppointment() {
		List<Appointment> listOfAppointments = new ArrayList<Appointment>();
		Appointment ap = null;
		String selectquery = "select a.doctor_id,a.name,a.dob,a.speciality,a.city,a.phone_number,a.std_fees,b.appoint_id,b.appoint_date,b.doctor_id,b.patient_name,fees_collected from doctor a,appointment b where a.doctor_id= b.doctor_id";
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = getConnection();
			ps = con.prepareStatement(selectquery);
			rs = ps.executeQuery();
			while (rs.next()) {
				ap = new Appointment();

				ap.setId(rs.getInt(1));
				ap.setName(rs.getString(2));
				ap.setDOB(rs.getDate(3));
				ap.setSpeciality(rs.getString(4));
				ap.setCity(rs.getString(5));
				ap.setPhone_no(rs.getLong(6));
				ap.setStandard_fees(rs.getFloat(7));
				ap.setAppoint_Id(rs.getInt(8));
				ap.setAppoint_Date(rs.getDate(9));
				ap.setDoc_Id(rs.getInt(10));
				ap.setPatient_Name(rs.getString(11));
				ap.setFees_Collected(rs.getInt(12));
				listOfAppointments.add(ap);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return listOfAppointments;
	}

	public static List<Appointment> getLeftOuterJoinDoctorAndAppointment() {
		List<Appointment> listOfAppointments = new ArrayList<Appointment>();
		Appointment ap = null;
		String selectquery = "select a.doctor_id,a.name,a.dob,a.speciality,a.city,a.phone_number,a.std_fees,b.appoint_id,b.appoint_date,b.doctor_id,b.patient_name,fees_collected from doctor a,appointment b where a.doctor_id= b.doctor_id(+)";
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = getConnection();
			ps = con.prepareStatement(selectquery);
			rs = ps.executeQuery();
			while (rs.next()) {
				ap = new Appointment();

				ap.setDoc_Id(rs.getInt(1));
				ap.setName(rs.getString(2));
				ap.setDOB(rs.getDate(3));
				ap.setSpeciality(rs.getString(4));
				ap.setCity(rs.getString(5));
				ap.setPhone_no(rs.getLong(6));
				ap.setStandard_fees(rs.getFloat(7));
				ap.setAppoint_Id(rs.getInt(8));
				ap.setAppoint_Date(rs.getDate(9));
				ap.setDoc_Id(rs.getInt(10));
				ap.setPatient_Name(rs.getString(11));
				ap.setFees_Collected(rs.getInt(12));
				listOfAppointments.add(ap);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return listOfAppointments;
	}

	public static List<Appointment> getRightOuterJoinDoctorAndAppointment() {
		List<Appointment> listOfAppointments = new ArrayList<Appointment>();
		Appointment ap = null;
		String selectquery = "select a.doctor_id,a.name,a.dob,a.speciality,a.city,a.phone_number,a.std_fees,b.appoint_id,b.appoint_date,b.doctor_id,b.patient_name,fees_collected from doctor a,appointment b where a.doctor_id(+)= b.doctor_id";
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = getConnection();
			ps = con.prepareStatement(selectquery);
			rs = ps.executeQuery();
			while (rs.next()) {
				ap = new Appointment();

				ap.setDoc_Id(rs.getInt(1));
				ap.setName(rs.getString(2));
				ap.setDOB(rs.getDate(3));
				ap.setSpeciality(rs.getString(4));
				ap.setCity(rs.getString(5));
				ap.setPhone_no(rs.getLong(6));
				ap.setStandard_fees(rs.getFloat(7));
				ap.setAppoint_Id(rs.getInt(8));
				ap.setAppoint_Date(rs.getDate(9));
				ap.setDoc_Id(rs.getInt(10));
				ap.setPatient_Name(rs.getString(11));
				ap.setFees_Collected(rs.getInt(12));
				listOfAppointments.add(ap);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return listOfAppointments;
	}

	public static List<Appointment> getFullOuterJoinDoctorAndAppointment() {
		List<Appointment> listOfAppointments = new ArrayList<Appointment>();
		Appointment ap = null;
		String selectquery = "select a.doctor_id,a.name,a.dob,a.speciality,a.city,a.phone_number,a.std_fees,b.appoint_id,b.appoint_date,b.doctor_id,b.patient_name,fees_collected from doctor a full outer join appointment b on a.doctor_id= b.doctor_id";
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = getConnection();
			ps = con.prepareStatement(selectquery);
			rs = ps.executeQuery();
			while (rs.next()) {
				ap = new Appointment();

				ap.setDoc_Id(rs.getInt(1));
				ap.setName(rs.getString(2));
				ap.setDOB(rs.getDate(3));
				ap.setSpeciality(rs.getString(4));
				ap.setCity(rs.getString(5));
				ap.setPhone_no(rs.getLong(6));
				ap.setStandard_fees(rs.getFloat(7));
				ap.setAppoint_Id(rs.getInt(8));
				ap.setAppoint_Date(rs.getDate(9));
				ap.setDoc_Id(rs.getInt(10));
				ap.setPatient_Name(rs.getString(11));
				ap.setFees_Collected(rs.getInt(12));
				listOfAppointments.add(ap);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return listOfAppointments;
	}

	public static int updateFeesCollected1(int parseInt, int update_fees) {
		// TODO Auto-generated method stub
		return 0;
	}

}
