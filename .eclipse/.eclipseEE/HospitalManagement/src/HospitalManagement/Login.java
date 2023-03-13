package HospitalManagement;
import java.sql.Statement;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends JFrame implements ActionListener {
	
// abstract interface method
@Override
public void actionPerformed(ActionEvent e) {
	if(e.getSource()==show) {    // getSource take an Obj return the type of the source obj  where the action happened in this case show
		
		if(show.isSelected()) {
			
			txt_password.setEchoChar('\0');
			show.setText(" show password");
			
		}
			
			else {
				
				txt_password.setEchoChar('*'); // thats what will be shown if we hide it 
				show.setText(" hide password");  // reset text of show button
			}  
			
		
		// cancel Button pressed Logic 
		
		}else if (e.getSource()== cancel) {  // source is equal cancel or if user pressed cancel 
			
			int c = JOptionPane.showConfirmDialog(null, "do you really want to Exit","Close program", JOptionPane.YES_NO_OPTION );
			
			if(c== 0) {
				System.exit(0);
			}
		} else if(e.getSource()== login) {
			
			checkEmail();
		}
		
		
	}


	
// email check

public void checkEmail() {
	
	try {
		   // Load the SQLite JDBC driver
        Class.forName("org.sqlite.JDBC");
        // Connect to the database
        Connection con = DriverManager.getConnection("jdbc:sqlite:Hospitalsql.db");
        
        String username=txt_name.getText(); 
        String password=txt_password.getText();
        String sql = "SELECT * FROM users WHERE username =  '"+username+"' AND password  ='"+password +"'  ;";
     
     // save the data comming from  database
     ResultSet rs= Tools.Select_Query(sql);
     String user ="", pass="";
     while(rs.next()) {
    	 
    	 user = rs.getString(1);// retrive first column from sql Hospitalsq class
    	 pass = rs.getString(2); // retrive second column  
    	 
    	
     }
     // comparing the usename and password entered with user comming from database
     if(username.equals(user)&& password.equals(pass)) {
    	 
    	 System.out.println("Successfully");
     }else {
    	 
    	 JOptionPane.showMessageDialog(null," please make sure the username or password you entered is correct ");
    	 
     }
		
	}catch (Exception e) {
		
		
	}
	
	
	
}


	
	// Create Component
	
	Font f18 = new Font("NewTimesRoman",Font.BOLD,18);
	JButton login = new JButton(" Sign in");
	JButton cancel = new JButton(" cancel");
	JLabel name= new JLabel(" Username");
	JLabel password= new JLabel(" password ");
	JTextField txt_name = new JTextField();
	JPasswordField txt_password = new JPasswordField();
	JCheckBox show = new JCheckBox(" show password");

	JLabel loginform = new JLabel(" Sign in To Hospital ");
	
	JPanel panel = new JPanel(null);
	
	
public Login() {
	  // set component 
	this.setTitle(" Sign in to Hospital");
	this.setLayout(null);
	this.setSize(800,500); 
	this.setLocationRelativeTo(null);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // the Application should terminate if we close
	this.setResizable(false); // disable resizing and maximizing
	this.setVisible(true); // show the Gui
	
	panel.setBounds(0, 0, 800, 140); // x,y; width, height thats top area
	loginform.setBounds(300,50,200,40);
	name.setBounds(140,200,100,35);
	password.setBounds(140,250,100, 35);
	txt_name.setBounds(250, 200, 350, 35);
	txt_password.setBounds(250, 250, 350, 35); 
	login.setBounds(450,330,150,35); // Button
	cancel.setBounds(250,330,150,35);
	show.setBounds(620,260,125,25); // x, y , width height JCheckBox show 
	panel.setBackground(new Color(51,153,255));
	this.getContentPane().setBackground(Color.decode("#33033")); // jframe area
	loginform.setFont(f18);
	name.setFont(f18);
	password.setFont(f18);
	cancel.setFont(f18);
	login.setFont(f18);
	loginform.setForeground(Color.white);
	name.setForeground(Color.white);
	password.setForeground(Color.white);
	show.setBackground(Color.decode("#33033"));
	show.setForeground(Color.white);
	
	// adding component
	panel.add(loginform);
	
	this.add(panel);
	this.add(name);
	this.add(password);
	this.add(txt_name);
	this.add(txt_password);
	this.add(login);
	this.add(cancel);
	this.add(show);
	// 
	
	show.addActionListener(this);
	login.addActionListener(this);
	cancel.addActionListener(this);

} 

public static void main(String[] args) {
	// run obj 
	new Login().setVisible(true);
}


}
