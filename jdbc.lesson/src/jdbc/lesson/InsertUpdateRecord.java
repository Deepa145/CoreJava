package jdbc.lesson;
import java.sql.*;

public class InsertUpdateRecord {
    public static void main(String args[]) throws Exception {
    //    Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "DEEPA");
        Statement stmt = con.createStatement();

        //int result= stmt.executeUpdate("insert into Dog2 values('Brown','Vetri',50000)");
        //int result=stmt.executeUpdate("update Dog2 set name='Omkumar' where color='Brown'");
        int result=stmt.executeUpdate("delete from Dog2 where name='Omkumar'");  
        System.out.println(result + " records affected");
        con.close();
    }
}