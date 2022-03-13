package pkg;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class ZohoSignIn extends JFrame implements ActionListener
{
    JLabel l1,l2,heading,link;
    JTextField t1,t2;
    JButton b1,signup;
    public static String id;
    public ZohoSignIn()
    {
        heading=new JLabel("Sign In");
        heading.setBounds(170,0,200,60);
        heading.setFont(new Font("TimesNewRoman",Font.BOLD,30));
        add(heading);

        link=new JLabel("Don't have an account? ");
        link.setBounds(150,50,150,50);
        add(link);

        signup=new JButton("Sign Up");
        signup.setBounds(260,60,100,30);
        signup.setBackground(Color.white);
        signup.setForeground(Color.blue);
        signup.setBorderPainted(false);
        signup.setContentAreaFilled(false);
        signup.addActionListener(this);
        add(signup);

        l1=new JLabel("Email");
        l1.setBounds(40,100,100,30);//x,y,width,height
        add(l1);

        t1=new JTextField();
        t1.setBounds(150,100,130,30);
        t1.setOpaque(false);
        add(t1);

        l2=new JLabel("Password");
        l2.setBounds(40,150,100,30);
        add(l2);

        t2=new JPasswordField();
        t2.setBounds(150,150,130,30);
        t2.setOpaque(false);
        add(t2);

        b1=new JButton("Sign In");
        b1.setBounds(170,200,80,30);
        b1.setBackground(Color.blue);
        b1.setForeground(Color.white);
        b1.addActionListener(this);
        add(b1);

        setLayout(null);
        getContentPane().setBackground(Color.white);
        setBounds(400,150,450,280);
        setUndecorated(true);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==b1)
        {
            try
            {
                conn1 c=new conn1();
                String email=t1.getText();
                String password=t2.getText();
                if(email.length()!=0 && password.length()!=0)
                {
                    ResultSet rs=c.s.executeQuery("select * from login where email='"+email+"' and password='"+password+"'");
                    if(rs.next())
                    {   
                        id=t1.getText();
                        new Form1().setVisible(true);  
                        this.setVisible(false);
                    }
                    else
                    {   
                        JOptionPane.showMessageDialog(null,"Invalid email and password");
				    	this.setVisible(false);
                    }
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Invalid Details");
                }
             }catch(Exception e)
             {
                 e.printStackTrace();
             }
        }
        else if(ae.getSource()==signup)
        {
            new ZohoSignUp().setVisible(true);
            this.setVisible(false);
        }
    }
    public static void main(String arg[])
    {
        new ZohoSignIn().setVisible(true);
    }
}