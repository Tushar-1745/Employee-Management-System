package employeemanagementsystem;

import java.sql.*;

public class Connectivity {
    
    Connection c;
    Statement s;
    public Connectivity(){
        try {
            //Load and Register drivers
            Class.forName("com.mysql.cj.jdbc.Driver");

            //Create connection
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeemanagement", "root", "Tushar@1745");
            
            s = c.createStatement();
            }
        catch(Exception e) {
                e.printStackTrace();
        }
    }
    public static void main(String[] args){
        new Connectivity();
    }
}
