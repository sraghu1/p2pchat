package p2pchat;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
public class Login extends JFrame {
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	   static final String DB_URL = "jdbc:mysql://localhost/chatroom";

	   //  Database credentials
	   static final String USER = "root";
	   static final String PASS = "";
	   Connection conn = null;
public static void main(String[] args) {
Login frameTabel = new Login();
}

JButton blogin = new JButton("Login");
JPanel panel = new JPanel();
JTextField txuser = new JTextField(15);
JPasswordField pass = new JPasswordField(15);
JButton bsignup=new JButton("Signup");
Login(){

super("Login Autentification");
	

//Connection conn = null;
Statement stmt = null;
    try {
//STEP 2: Register JDBC driver
    	  
setSize(300,200);
setLocation(500,280);
panel.setLayout (new GridLayout(4,4)); 


//txuser.setBounds(70,30,150,20);
//pass.setBounds(70,65,150,20);
//blogin.setBounds(110,100,80,20);
txuser.setText("Username");
pass.setText("password");
panel.add(txuser);
panel.add(pass);
panel.add(bsignup);
panel.add(blogin);
getContentPane().add(panel);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);
actionlogin();
    }
    catch(Exception e)
    {
    	e.printStackTrace();}
    }

public void actionlogin(){
blogin.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent ae) {
String puname = txuser.getText();
String ppaswd = pass.getText();
int flag=0;
try {
	Class.forName("com.mysql.jdbc.Driver");

    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/chatroom", "root", "");

	Statement st_Login=conn.createStatement();
	ResultSet rs=st_Login.executeQuery("select * from user");
	while(rs.next())
	{
	    if(rs.getString("email").equals(puname)&&rs.getString("password").equals(MD5.getHash(ppaswd)))
		{
                    flag=1;
         	String nickname=rs.getString(3);
                   
		}
	}
	
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
} catch (Exception e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
} 

if(flag==1) {
UserInfo regFace =new UserInfo();
regFace.setVisible(true);
dispose();
} else {

JOptionPane.showMessageDialog(null,"Wrong Password / Username");
txuser.setText("");
pass.setText("");
txuser.requestFocus();
}

}
});
bsignup.addActionListener(new ActionListener()
{
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		new Signup();
	}
	
});
}
}
