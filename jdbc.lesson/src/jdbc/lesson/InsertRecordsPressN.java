package jdbc.lesson;
import java.sql.*;  
import java.io.*; 
public class InsertRecordsPressN {
 
    public static void main(String args[])throws Exception{  
    Class.forName("oracle.jdbc.driver.OracleDriver");  
    Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","DEEPA");  
      
    PreparedStatement ps=con.prepareStatement("insert into DOG2 values(?,?,?)");  
      
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));  
      
    do{  
    System.out.println("enter NAME:");  
    String name=br.readLine();  
    System.out.println("enter PLACE:");  
    String place=br.readLine();  
    System.out.println("enter COLOR:");  
    //float salary=Float.parseFloat(br.readLine());  
      String color=br.readLine();
    ps.setString(1,name);  
    ps.setString(2,place);  
    ps.setString(3,color);  
    int i=ps.executeUpdate();  
    System.out.println(i+"One records affected");  
      
    System.out.println("Do you want to continue: y/n");  
    String s=br.readLine();  
    if(s.startsWith("n")){  
    break;  
    }  
    }while(true);  
      
    con.close();  
    }  
}