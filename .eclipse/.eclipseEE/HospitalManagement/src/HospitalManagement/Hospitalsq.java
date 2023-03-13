package HospitalManagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Hospitalsq {

    public static void main(String[] args) {
    	
    	String sql = "INSERT INTO users (username, password) VALUES('admin', 'admin') ;";  // that will be executed after the first table is created  
        boolean check = Tools.ExecuteStatement(sql);
        if(check) {
        	
        	System.out.println(" Successfully");
        }
      
        
    }

}