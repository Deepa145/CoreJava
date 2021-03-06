package jdbc.lesson;

import java.sql.*;

public class InsertPrepared {

	public static void main(String args[]) {
		try {
			// Class.forName("oracle.jdbc.driver.OracleDriver");

			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "DEEPA");

			/*
			 * PreparedStatement stmt =
			 * con.prepareStatement("insert into Dog2 values(?,?,?)"); stmt.setString(1,
			 * "Vetri");// 1 specifies the first parameter in the query stmt.setString(2,
			 * "Ratan"); stmt.setString(3, "Narmatha"); //stmt.setString(4, "Omkumar"); int
			 * i = stmt.executeUpdate(); System.out.println(i + " records inserted");
			 */

			// Prepared Statement update the records from the table

			/*
			 * PreparedStatement
			 * stmt1=con.prepareStatement("update Dog2 set Name='Omkumar' where Name='USA'"
			 * ); int result=
			 * stmt1.executeUpdate("insert into Dog2 values('USA','Omkumar')");
			 * stmt1.setString(1, "USA"); stmt1.setString(2, "Om");
			 * 
			 * int i=stmt1.executeUpdate(); System.out.println(i+" records updated");
			 */

			// Delete the records from the table

			PreparedStatement stmt = con.prepareStatement("delete from Dog2 where name='Salem'");
		//tmt.setString(1, "Deepa");
			int i = stmt.executeUpdate();
			System.out.println(i + " records deleted");

		}
		// Retrieve the records from the table

		/*
		 * PreparedStatement stmt=con.prepareStatement("select * from Dog2"); ResultSet
		 * rs=stmt.executeQuery(); while(rs.next()){
		 * System.out.println(rs.getString(1)+" "+rs.getString(2)); }
		 * 
		 * 
		 * 
		 * }
		 */
		catch (Exception e) {
			System.out.println(e);
		}
	}
}
