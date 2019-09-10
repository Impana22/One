package one;
import java.sql.*;
import java.io.*;
import java.util.Scanner;
public class One {
public static void main(String[] args)throws Exception{
	      BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		  Class.forName("com.mysql.jdbc.Driver");
		  Connection con=DriverManager.getConnection("jdbc:mysql://localhost/Sakhag","sakha-impana","123");
          System.out.println("Enter deptno");
          int deptno= Integer.parseInt(in.readLine());
//		  String dname= in.readLine();
//		  String location = in.readLine();
		  PreparedStatement ps=con.prepareStatement("delete from dept where deptno=?");
		  ps.setInt(1,deptno);
//		  ps.setString(2,dname);
//		  ps.setString(3,location);
		  
		  
		  int r=ps.executeUpdate();
		  if(r>0){
			  System.out.println("Deleted successfully");
		  }
		  else{
			  System.out.println("Failed");
		  
		  }
		  ResultSet rs=ps.executeQuery("select * from dept");
		  while(rs.next()) {
		  System.out.println(rs.getInt(1)+"\t"+rs.getString(2));
		  }
		}
	}