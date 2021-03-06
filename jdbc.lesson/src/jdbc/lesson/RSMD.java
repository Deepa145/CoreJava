package jdbc.lesson;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.sql.*;

public class RSMD {
	public static void main(String args[]) throws Exception {
		// resultSetMetaData();
		// DatabaseMetaData();
		// printsTotalNumberOfTables();
		// storeImageInTheDatabase();
		// storeFileInTheDatabase();
		// storedGifInTheDatabase();
		// callableProcedure();
		// callableFunction();
		// transactionManagement();
		//transactionManagementPreparedStmt();
		//batchProcessinginJDBC();
		batchProcessinginJDBCUsingPreparedStmt();

	}

	// find total column,indivdual name and colume data type
	public static void resultSetMetaData() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "DEEPA");

			PreparedStatement ps = con.prepareStatement("select * from Dog2");
			ResultSet rs = ps.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();

			System.out.println("Total columns: " + rsmd.getColumnCount());
			System.out.println("Column Name of 1st column: " + rsmd.getColumnName(2));
			System.out.println("Column Type Name of 1st column: " + rsmd.getColumnTypeName(2));

			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	// Find the JDBC driver details
	public static void DatabaseMetaData() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "DEEPA");
			DatabaseMetaData dbmd = con.getMetaData();

			System.out.println("Driver Name: " + dbmd.getDriverName());
			System.out.println("Driver Version: " + dbmd.getDriverVersion());
			System.out.println("UserName: " + dbmd.getUserName());
			System.out.println("Database Product Name: " + dbmd.getDatabaseProductName());
			System.out.println("Database Product Version: " + dbmd.getDatabaseProductVersion());

			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	// Print total no of tables...by using view or Table
	public static void printsTotalNumberOfTables() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "DEEPA");

			DatabaseMetaData dbmd = con.getMetaData();
			String view[] = { "VIEW" };
			ResultSet rs = dbmd.getTables(null, null, null, view);

			while (rs.next()) {
				System.out.println(rs.getString(3));
			}

			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	// To get images by using the fileInputStream format
	public static void storeImageInTheDatabase() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "DEEPA");

			PreparedStatement ps = con.prepareStatement("insert into ImageJDBC values(?,?)");
			ps.setString(1, "Vetri");

			FileInputStream fin = new FileInputStream("d:\\Vetri.jpeg");
			ps.setBinaryStream(2, fin, fin.available());
			int i = ps.executeUpdate();
			System.out.println(i + " records affected");

			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void storeFileInTheDatabase() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "DEEPA");

			PreparedStatement ps = con.prepareStatement("insert into ImageJDBC1 values(?,?)");

			File f = new File("D:\\temp\\copy\\Ravi.txt");
			FileReader fr = new FileReader(f);

			ps.setInt(1, 101);
			ps.setCharacterStream(2, fr, (int) f.length());
			int i = ps.executeUpdate();
			System.out.println(i + " records affected");

			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		/*
		 * public static void storedGifInTheDatabase() {
		 * //Class.forName("OracleDriver"); try { DriverManager.registerDriver(new
		 * oracle.jdbc.driver.OracleDriver()); Connection con =
		 * DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ora","system",
		 * "DEEPA"); Statement st=con.createStatement();
		 * System.out.println("Vehical to take SQL Statementscreated"); ResultSet
		 * rs=st.executeQuery("select *from ImageJDBC2"); rs.next(); InputStream
		 * in=rs.getBinaryStream("Gif"); FileOutputStream fout=new
		 * FileOutputStream("CWF.GIF"); int byteRead=0; byte[] buffer=new byte[4096];
		 * 
		 * while((byteRead=in.read(buffer))!=-1) fout.write(buffer,0,byteRead);
		 * System.out.println("photo stored into new file"); fout.close(); in.close();
		 * st.close(); con.close(); }catch (Exception e) {e.printStackTrace();}
		 * 
		 * }
		 */

		/*
		 * public static void retrieveFileFromOracleDatabase() { try{
		 * Class.forName("oracle.jdbc.driver.OracleDriver"); Connection
		 * con=DriverManager.getConnection(
		 * "jdbc:oracle:thin:@localhost:1521:xe","system","DEEPA");
		 * 
		 * PreparedStatement ps=con.prepareStatement("select * from ImageJDBC1");
		 * ResultSet rs=ps.executeQuery(); rs.next();//now on 1st row
		 * 
		 * Clob c=rs.getClob(2); Reader r=c.getCharacterStream();
		 * 
		 * FileWriter fw=new FileWriter("d:\\retrivefile.txt");
		 * 
		 * int i; while((i=r.read())!=-1) fw.write((char)i);
		 * 
		 * fw.close(); con.close();
		 * 
		 * System.out.println("success"); }catch (Exception e) {e.printStackTrace(); } }
		 */
	}

	// To create a procedure method in sql then compiled. After to get the table in
	// sql.
	public static void callableProcedure() throws Exception {
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "DEEPA");

		CallableStatement stmt = con.prepareCall("{call insertR1(?,?)}");
		stmt.setInt(1, 1011);
		stmt.setString(2, "Amit");
		stmt.execute();

		System.out.println("success");
	}

//To create a function method in sql then compiled. After to got an output in eclipse.
	public static void callableFunction() throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "DEEPA");

		CallableStatement stmt = con.prepareCall("{?= call sum4(?,?)}");
		stmt.setInt(2, 10);
		stmt.setInt(3, 43);
		stmt.registerOutParameter(1, Types.INTEGER);
		stmt.execute();

		System.out.println(stmt.getInt(1));

	}

//Insert the values in eclipse and view the output in sql. 
	public static void transactionManagement() throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "DEEPA");
		con.setAutoCommit(false);

		Statement stmt = con.createStatement();
		stmt.executeUpdate("insert into Baby1 values(190,'abhi',40000)");
		stmt.executeUpdate("insert into Baby1 values(191,'umesh',50000)");

		con.commit();
		con.close();
	}
	//Insert the values in eclipse and view the output in sql by using prepared Statement.
	public static void transactionManagementPreparedStmt() throws Exception {
		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "DEEPA");
			con.setAutoCommit(false);

			PreparedStatement ps = con.prepareStatement("insert into Baby1 values(?,?,?)");

			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			while (true) {

				System.out.println("enter id");
				String s1 = br.readLine();
				int id = Integer.parseInt(s1);

				System.out.println("enter name");
				String name = br.readLine();

				System.out.println("enter salary");
				String s3 = br.readLine();
				int salary = Integer.parseInt(s3);

				ps.setInt(1, id);
				ps.setString(2, name);
				ps.setInt(3, salary);
				ps.executeUpdate();

				System.out.println("commit/rollback");
				String answer = br.readLine();
				if (answer.equals("commit")) {
					con.commit();
				}
				if (answer.equals("rollback")) {
					con.rollback();
				}

				System.out.println("Want to add more records y/n");
				String ans = br.readLine();
				if (ans.equals("n")) {
					break;
				}

			}
			con.commit();
			System.out.println("record successfully saved");

			con.close();// before closing connection commit() is called
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
		public static void batchProcessinginJDBC() throws Exception {	
	Class.forName("oracle.jdbc.driver.OracleDriver");  
	Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","DEEPA");  
	con.setAutoCommit(false);  
	  
	Statement stmt=con.createStatement();  
	stmt.addBatch("insert into Baby1 values(190,'abhi',40000)");  
	stmt.addBatch("insert into Baby1 values(191,'umesh',50000)");  
	  
	stmt.executeBatch();//executing the batch  
	  
	con.commit();  
	con.close();  
	}

		public static void batchProcessinginJDBCUsingPreparedStmt() throws Exception {
		try{  
			  
			Class.forName("oracle.jdbc.driver.OracleDriver");  
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","DEEPA");  
			  
			PreparedStatement ps=con.prepareStatement("insert into Baby1 values(?,?,?)");  
			  
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));  
			while(true){  
			  
			System.out.println("enter id");  
			String s1=br.readLine();  
			int id=Integer.parseInt(s1);  
			  
			System.out.println("enter name");  
			String name=br.readLine();  
			  
			System.out.println("enter salary");  
			String s3=br.readLine();  
			int salary=Integer.parseInt(s3);  
			  
			ps.setInt(1,id);  
			ps.setString(2,name);  
			ps.setInt(3,salary);  
			  
			ps.addBatch();  
			System.out.println("Want to add more records y/n");  
			String ans=br.readLine();  
			if(ans.equals("n")){  
			break;  
			}  
			  
			}  
			ps.executeBatch();// for executing the batch  
			  
			System.out.println("record successfully saved");  
			  
			con.close();  
			}catch(Exception e){System.out.println(e);}  
			  
}  

}