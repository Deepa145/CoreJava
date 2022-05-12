package jdbc.lesson;
import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
public class StoredData {

   public static void main(String[] args) {
      try {
          Class.forName("oracle.jdbc.driver.OracleDriver");
          Connection myCon = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","DEEPA");
          PreparedStatement ps = myCon.prepareStatement("insert into Dog1 values(?,?)");
          ps.setInt(1, 1555501);
        //  ps.setCharacterStream(2, fr,(int)f.length());
          ps.setString(2, "omkytgsumar");
          int i = ps.executeUpdate();
          System.out.println(i + " " + "record affected");
          myCon.close();
      }catch(Exception err) {
          err.printStackTrace();
      }
}
}