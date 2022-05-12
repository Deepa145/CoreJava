package jdbc.lesson;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class omkumar {
 // static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
  static final String DB_URL = "jdbc:oracle:thin:@localhost:1521:xe";

  static final String USER = "system";
  static final String PASS = "DEEPA";

  public static void main(String[] args) throws Exception {
    Connection conn = null;
    Statement stmt = null;

 //   Class.forName(JDBC_DRIVER);
    conn = DriverManager.getConnection(DB_URL, USER, PASS);
    System.out.println("Deleting database...");
    stmt = conn.createStatement();

    conn = DriverManager.getConnection(DB_URL, USER, PASS);

    stmt = conn.createStatement();

    String sql = "DROP TABLE deep ";

    stmt.executeUpdate(sql);

    System.out.println("Created table in given database...");
    stmt.close();
    conn.close();
  }
}
