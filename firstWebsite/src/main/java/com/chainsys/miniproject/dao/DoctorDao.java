package com.chainsys.miniproject.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.chainsys.miniproject.pojo.Doctor;
import com.chainsys.miniproject.pojo.Employees;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DoctorDao {
	/**
	 * getConnection() insertEmployee (Employee newemp) getEmployeeById(int id)
	 * getAllEmployee() updateEmployee(Employee newemp) deleteEmployee(int id)
	 */
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
// To insert new row to the table employees
	public static int insertDoctor(Doctor newdoct) {
		String insertquery = "insert into Doctor(Id,Name,DOB,Speciality,City,Phone_no,Standard_fees) values (?,?,?,?,?,?,?)";
		Connection con = null;
		int rows =0;
//		int rows ;
		PreparedStatement ps = null;
		try {
			con = getConnection();
			ps = con.prepareStatement(insertquery);
			ps.setInt(1, newdoct.getId());
			ps.setString(2, newdoct.getName());
			ps.setDate(3, convertTosqlDate(newdoct.getDOB()));
			ps.setString(4, newdoct.getSpeciality());
			//convert java.util.Date to java.sql.date
			//ps.setDate(5, convertTosqlDate(newemp.getHire_Date()));
			ps.setString(5, newdoct.getCity());
			ps.setLong(6, newdoct.getPhone_no());
			ps.setFloat(7, newdoct.getStandard_fees());
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
	public static int updateDoctor(Doctor newdoc) {
        String updatequery = "update Doctor set Name=?,DOB=?,Speciality=?,City=?,Phone_no=?,Standard_fees=? where Id=?";
        Connection con = null;
        int rows = 0; 
        PreparedStatement ps = null;
        try {
            con = getConnection();
            ps = con.prepareStatement(updatequery);
            ps.setInt(7, newdoc.getId());
            ps.setString(1, newdoc.getName());
            ps.setDate(2, convertTosqlDate(newdoc.getDOB()));
            ps.setString(3, newdoc.getSpeciality());
            ps.setString(4, newdoc.getCity());
            // convert java.util.Date to java.sql.date
            ps.setLong(5, newdoc.getPhone_no());
            ps.setFloat(6, newdoc.getStandard_fees());
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
	public static int deleteDoctor(int id) {
		String deletequery = "delete from Doctor where Id=?";
		Connection con = null;
		int rows = 0;
		PreparedStatement ps = null;
	
		try {
			con = getConnection();
			ps = con.prepareStatement(deletequery);
			ps.setInt(1, id);
			ps.executeUpdate();
			rows = ps.executeUpdate();	
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
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
	//To retrive specific Doctor data using Doctor_id
		public static Doctor getDoctorById(int id) {
			Doctor doct =null;
			String selectquery = "select Id,Name,DOB,Speciality,City,Phone_no,Standard_fees from Doctor where Id = ? ";
			Connection con = null;
			PreparedStatement ps = null;
			 ResultSet rs  = null;
			try {
				con = getConnection();
				ps = con.prepareStatement(selectquery);
				ps.setInt(1, id);
				rs =ps.executeQuery();
				doct = new Doctor();
				   if(rs.next()) {
					   doct.setId(rs.getInt(1));
					   doct .setName(rs.getString(2));
					   java.util.Date date = new java.util.Date(rs.getDate(3).getTime());
					   doct.setDOB(date);
					   doct.setSpeciality(rs.getString(4));
			          //why getTime method used ok now clear 
			          //date retrieved from the database will be of type java.sql.Date (rs.getDate(5))
			          //emp.setHire_date requires date of type java.util.Date 
			          //so we are converting sql Date to util Date 
			          //the constructor of java.util.Date requires a long value 
			          //so we use the getTime() which returns the sql date as a long value.
			          //ok sir
			          doct.setCity(rs.getString(5));
			          doct.setPhone_no(rs.getLong(6));
			          doct.setStandard_fees(rs.getFloat(7));
			        }
			}catch(SQLException e) {
				e.printStackTrace();
			}finally {
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
			return doct;
		
		}
		//To retrieve all employee data 
	public static List<Doctor> getAllDoctor(){
		 List<Doctor> listOfDoctors = new ArrayList<Doctor>();//ok sir
		 Doctor doct =null;
			String selectquery = "select Id,Name,DOB,Speciality,City,Phone_no,Standard_fees  from Doctor  ";
			Connection con = null;
			PreparedStatement ps = null;
			 ResultSet rs  = null;
			try {
				con = getConnection();
				ps = con.prepareStatement(selectquery);
				rs =ps.executeQuery();
				doct = new Doctor();
				   if(rs.next()) {
					   doct.setId(rs.getInt(1));
					   doct .setName(rs.getString(2));
					   java.util.Date date = new java.util.Date(rs.getDate(3).getTime());
				          doct.setDOB(date);
					   doct.setSpeciality(rs.getString(4));
			         
			          doct.setCity(rs.getString(5));
			          doct.setPhone_no(rs.getLong(6));
			         doct.setStandard_fees(rs.getFloat(7));
			          listOfDoctors.add(doct);
			        }
			}catch(SQLException e) {
				e.printStackTrace();
			}finally {
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
		 return listOfDoctors;
	 }

	public static int updateDoctor(int doc_id, String doc_name) {
		// TODO Auto-generated method stub
		return 0;
	}

	public static int updateStandardFees(int doc_id, float doc_salary) {
		// TODO Auto-generated method stub
		return 0;
	}
}