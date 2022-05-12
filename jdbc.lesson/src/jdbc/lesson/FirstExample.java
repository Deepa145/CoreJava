package jdbc.lesson;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class FirstExample {
   static final String DB_URL = "jdbc:oracle:thin:@localhost:1521:xe";
   static final String USER = "system";
   static final String PASS = "DEEPA";
   static final String QUERY = "SELECT EMPLOYEE_ID,FIRST_NAME, LAST_NAME, EMAIL FROM employees";

   public static void main(String[] args) {
      // Open a connection
      try
      (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
       Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery(QUERY);) {
         // Extract data from result set
        while (rs.next()) {
            // Retrieve by column name
            System.out.print("ID: " + rs.getInt("EMPLOYEE_ID"));
            System.out.print(", Email: " + rs.getString("EMAIL"));
            System.out.print(", First: " + rs.getString("FIRST_NAME"));
            System.out.println(", Last: " + rs.getString("LAST_NAME"));
         
      }
      }catch (SQLException e) {
         e.printStackTrace();
      } 
   
      }
}
