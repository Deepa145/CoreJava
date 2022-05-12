package jdbc.lesson;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Drop1 {
   static final String DB_URL = "jdbc:oracle:thin:@localhost:1521:xe";
   static final String USER = "system";
   static final String PASS = "DEEPA";

   public static void main(String[] args) {
      // Open a connection
     /* try(Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "DEEPA");
         Statement stmt = conn.createStatement();)
      {		      
         String sql = "DROP TABLE DEEP";
         stmt.executeUpdate(sql);
         System.out.println("Database dropped successfully..."); 
         conn.close();
      } catch (Exception e) {
         System.out.println(e.getMessage());
      } 
   }*/
	   
	   //Another method for Drop function
   try { 
   	System.out.println("som");
          Connection myCon  = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","DEEPA"); 
          Statement mystat = myCon.createStatement();
          ResultSet Rs  = mystat.executeQuery("delete Name from Dog where color='Browny' ");
        // while(Rs.next()) {
            //  System.out.println(Rs.getString("last_name") + ", " +Rs.getString("first_name"));
        //  }
          myCon.close();
      }catch(Exception err) {
          err.printStackTrace();
      }
}
}