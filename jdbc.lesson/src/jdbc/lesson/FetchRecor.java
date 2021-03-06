package jdbc.lesson;

import java.sql.*;

public class FetchRecor {
    public static void main(String args[]) throws Exception {

        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "DEEPA");
        Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet rs = stmt.executeQuery("select * from Dog2");

//getting the record of 3rd row  
        rs.absolute(2);
        rs.absolute(3);
        System.out.println(rs.getString(1) + " " + rs.getString(2) );//" " + rs.getString(3));
        System.out.println( rs.getString(2) );
        con.close();
    }
}