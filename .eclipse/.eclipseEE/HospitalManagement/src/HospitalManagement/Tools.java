package HospitalManagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;



public class Tools {
	
private static  Connection con = null;


public static Connection connectionToSql() {
	
	try {
		
		 // Load the SQLite JDBC driver
        Class.forName("org.sqlite.JDBC");

        // Connect to the database
        con = DriverManager.getConnection("jdbc:sqlite:Hospitalsql.db");
	}catch(Exception e) {
		
	
		
	}
	return con;
	
	
}
public static void closeConnection() {
	
	try {
		
		con.close();


     
	}catch(Exception e) {
		
	
		
	}

	
}// closeConnection

// insert Delete Update function

public static boolean ExecuteStatement(String sql) {
	
	
try {
	connectionToSql();

	  // Prepare the statement for execution
    PreparedStatement pstmt = con.prepareStatement(sql);

    // Execute the statement to create the table
    pstmt.execute();
    
    return true;

     
	}catch(Exception e) {
		
	JOptionPane.showMessageDialog(null, e," Execute statement Func",JOptionPane.ERROR_MESSAGE);
	return false;
		
	}

	
} // ExecuteStatement



// Select Function

public static ResultSet Select_Query(String sql) {
	
	try {
		
		connectionToSql();
	     // Create a Statement object
	     Statement st = con.createStatement();
	     
	     // save the data comming from  database
	     ResultSet rs= st.executeQuery(sql);
	     return rs;
    
		
		
	}catch(Exception e) {
		
		JOptionPane.showMessageDialog(null, e," Execute Select_Query Func",JOptionPane.ERROR_MESSAGE);
	
	     return null;
		
	}

	
	
}

}
