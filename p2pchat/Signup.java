package p2pchat;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.xml.bind.DatatypeConverter;

public class Signup extends JFrame implements ActionListener{
	JLabel l1, l2, l3, l4, l5, l6, l7, l8;

    JTextField tf1, tf2, tf5, tf6, tf7;

    JButton btn1, btn2;

    JPasswordField p1, p2;

	public Signup()
{

 

		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(6,2));
	    setVisible(true);
	    setSize(700, 700);
		panel.setSize(700, 700);

        //setLayout(null);

        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //setTitle("Registration Form in Java");

 

        l1 = new JLabel("Registration Form in Windows Form:");

        l1.setForeground(Color.blue);

        l1.setFont(new Font("Serif", Font.BOLD, 20));

 

        l2 = new JLabel("Name:");

        l3 = new JLabel("Email-ID:");

        l4 = new JLabel("Create Passowrd:");

        l5 = new JLabel("Confirm Password:");

        tf1 = new JTextField();//name

        tf2 = new JTextField();//email

        p1 = new JPasswordField();//pass1

        p2 = new JPasswordField();

        btn1 = new JButton("Submit");

        btn2 = new JButton("Clear");

 

        btn1.addActionListener(this);

        btn2.addActionListener(this);
 

        //panel.add(l1);

        panel.add(l2);

        panel.add(tf1);

        panel.add(l3);

        panel.add(tf2);

        panel.add(l4);

        panel.add(p1);

        panel.add(l5);

        panel.add(p2);

        //panel.add(l6);

        //panel.add(tf5);

        //panel.add(l7);

        //panel.add(tf6);

        //panel.add(l8);

        //panel.add(tf7);

        panel.add(btn1);
        panel.add(btn2);
        
        add(panel);
    }

 

    public void actionPerformed(ActionEvent e)
     {

        if (e.getSource() == btn1)
         {

            int x = 0;

            String name = tf1.getText();

            String email = tf2.getText();

 

            char[] s3 = p1.getPassword();

            char[] s4 = p2.getPassword(); 

            String s8 = new String(s3);

            String s9 = new String(s4);

 

            //String s5 = tf5.getText();

            //String s6 = tf6.getText();

            //String s7 = tf7.getText();

            if (s8.equals(s9))
           {

                try
               {

                    Class.forName("com.mysql.jdbc.Driver");

                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost/chatroom", "root", "");

                    PreparedStatement ps = con.prepareStatement("insert into user values(?,?,?,?,?)");

                    ps.setString(1, email);

                    ps.setString(2, MD5.getHash(s8));

                    ps.setString(3, name);

                    ps.setInt(4, 0);

                    ps.setString(5, "default");


                    int rs = ps.executeUpdate();

                    x++;

                    if (x > 0)
                    {

                        JOptionPane.showMessageDialog(btn1, "Data Saved Successfully");

                    }

                }
          catch (Exception ex)
                {

                    System.out.println(ex);

                }

            }
          else
           {

                JOptionPane.showMessageDialog(btn1, "Password Does Not Match");

            } 

        }
          else
       {

            tf1.setText("");

            tf2.setText("");

            p1.setText("");

            p2.setText("");

            tf5.setText("");

            tf6.setText("");

            tf7.setText("");

        }

    }
    static String getPasswordHashText(String password)
    	    throws NoSuchAlgorithmException, UnsupportedEncodingException {
    	    MessageDigest digest = MessageDigest.getInstance("SHA-1");
    	    digest.reset();
    	    byte[] hash = digest.digest(password.getBytes("UTF-8"));
    	    return DatatypeConverter.printHexBinary(hash);
    	}
}

