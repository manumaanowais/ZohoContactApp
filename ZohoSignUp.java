package pkg;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class ZohoSignUp extends JFrame implements ActionListener
{
    JLabel l1,l2,l3,heading,link,p1,p2;
    JTextField t1,t2,t3;
    JButton b1,signin;
    public ZohoSignUp()
    {
        heading=new JLabel("Sign Up");
        heading.setBounds(170,0,200,60);
        heading.setFont(new Font("TimesNewRoman",Font.BOLD,30));
        add(heading);

        link=new JLabel("Already have an account? ");
        link.setBounds(140,50,150,50);
        add(link);

        signin=new JButton("Sign In");
        signin.setBounds(260,60,100,30);
        signin.setBackground(Color.white);
        signin.setForeground(Color.blue);
        signin.setBorderPainted(false);
        signin.setContentAreaFilled(false);
        signin.addActionListener(this);
        add(signin);

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

        l3=new JLabel("Secret");
        l3.setBounds(40,200,100,30);
        add(l3);

        t3=new JPasswordField();
        t3.setBounds(150,200,130,30);
        t3.setOpaque(false);
        add(t3);

        b1=new JButton("Sign Up");
        b1.setBounds(170,250,80,30);
        b1.setBackground(Color.blue);
        b1.setForeground(Color.white);
        b1.addActionListener(this);
        add(b1);

        p1=new JLabel("By clicking the Sign Up button, you are creating an ");
        p1.setBounds(95,280,300,30);
        p1.setFont(new Font("Serif",Font.PLAIN,12));
        add(p1);
        p2=new JLabel("account, and you agree to the Terms of use.");
        p2.setBounds(105,295,280,30);
        p2.setFont(new Font("Serif",Font.PLAIN,12));
        add(p2);

        setLayout(null);
        getContentPane().setBackground(Color.white);
        setBounds(400,150,450,350);
        setUndecorated(true);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
        String email=t1.getText();
        String password=t2.getText();
        String secret=t3.getText();
        String str1;
        if(ae.getSource()==b1)
        {
            if(email.length()!=0 && password.length()!=0 && secret.length()!=0)
            {
                str1="insert into login values('"+email+"','"+password+"','"+secret+"')";
                try 
                {
                    conn1 c=new conn1();
                    c.s.executeUpdate(str1);
                }catch(Exception e){}
                JOptionPane.showMessageDialog(null," Successfully Signed Up");
                new ZohoSignIn().setVisible(true);
                 this.setVisible(false);
            }
            else
            {
                JOptionPane.showMessageDialog(null,"Invalid Details");
            }
        }
        else if(ae.getSource()==signin)
        {
            new ZohoSignIn().setVisible(true);
            this.setVisible(false);
        }
    }
    public static void main(String arg[])
    {
        new ZohoSignUp().setVisible(true);
    }
}