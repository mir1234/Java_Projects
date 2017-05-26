package conec;

import java.sql.*;


public class connector{

 public Connection con;
 public Statement stmt;
 public ResultSet rs;
    
//public static void main(String args[]){
public connector(){
String dbtime;
String dbUrl = "jdbc:mysql://localhost/lottery";
String query = "Select * FROM data";

try {

Class.forName("com.mysql.jdbc.Driver");
 con = DriverManager.getConnection (dbUrl,"root","");
 stmt = con.createStatement();
 rs = stmt.executeQuery(query);

while (rs.next()) {
dbtime = rs.getString(1);
//System.out.println(dbtime);
} //end while

//con.close();
} //end try

catch(ClassNotFoundException e) {
e.printStackTrace();

}

catch(SQLException e) {
e.printStackTrace();

}

}  //end main

}  //end class