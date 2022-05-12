package jdbc.lesson;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCExample {
   static final String DB_URL = "jdbc:oracle:thin:@localhost:1521:xe";
   static final String USER = "system";
   static final String PASS = "DEEPA";

   public static void main(String[] args) {
      System.out.println("Connecting to a selected database...");
      // Open a connection
      try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);) {		      
         System.out.println("Connected database successfully...");  
      } catch (SQLException e) {
         e.printStackTrace();
      } 
   }
}