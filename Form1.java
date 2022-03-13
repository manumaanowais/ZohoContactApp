package pkg;

import pkg.ZohoSignIn.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;

public class Form1 extends JFrame implements ActionListener
{
    JLabel l1,l2,l3,l4,l5,l6,secret,heading,p;
    JTextField t1,t2,t3,t4;
    JTextArea ta1;
    JButton b1,b2;
    JTable tb1;
    public Form1()
    {
        tb1=new JTable();
        tb1.setBounds(10,380,590,200);
        add(tb1);

        heading=new JLabel("Contact Form and Contact List Page");
        heading.setBounds(120,0,400,60);
        heading.setFont(new Font("TimesNewRoman",Font.BOLD,20));
        add(heading);

        p=new JLabel("Add Contacts");
        p.setBounds(250,60,200,30);
        p.setFont(new Font("Tahoma",Font.BOLD,15));
        add(p);

        l1=new JLabel("Name");
        l1.setBounds(160,110,100,30);//x,y,width,height
        add(l1);

        t1=new JTextField();
        t1.setBounds(260,100,130,30);
        t1.setOpaque(false);
        add(t1);

        l2=new JLabel("Phone No");
        l2.setBounds(160,160,100,30);
        add(l2);

        t2=new JTextField();
        t2.setBounds(260,150,130,30);
        t2.setOpaque(false);
        add(t2);

        l3=new JLabel("Email");
        l3.setBounds(160,210,100,30);
        add(l3);

        t3=new JTextField();
        t3.setBounds(260,200,130,30);
        t3.setOpaque(false);
        add(t3);

        secret=new JLabel("Secret");
        secret.setBounds(160,260,100,30);
        add(secret);

        t4=new JPasswordField();
        t4.setBounds(260,250,130,30);
        add(t4);

        b1=new JButton("Save");
        b1.setBounds(280,320,80,30);
        b1.setBackground(Color.blue);
        b1.setForeground(Color.white);
        b1.addActionListener(this);
        add(b1);

        l4=new JLabel("Name");
        l4.setBounds(70,360,50,20);
        add(l4);

        l5=new JLabel("Phone No");
        l5.setBounds(270,360,70,20);
        add(l5);

        l6=new JLabel("Email");
        l6.setBounds(470,360,50,20);
        add(l6);

        b2=new JButton("Load");
        b2.setBounds(260,620,80,30);
        b2.setBackground(Color.white);
        b2.setForeground(Color.blue);
        b2.addActionListener(this);
        add(b2);

        ta1=new JTextArea(ZohoSignIn.id);
        ta1.setBounds(450,45,140,30);
        ta1.setFont(new Font("TimesNewRoman",Font.BOLD,15));
        ta1.setEditable(false);
        add(ta1);

        setLayout(null);
        getContentPane().setBackground(Color.white);
        setUndecorated(true);
        setBounds(400,10,600,680);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)
    {
            String name=t1.getText();
            String phoneno=t2.getText();
            String email=t3.getText();
            String secret=t4.getText();
            
            String str2;
            if(ae.getSource()==b1)
            {
                if(name.length()!=0 && phoneno.length()!=0 && email.length()!=0 && secret.length()!=0)
                { 
                    str2="insert into form values('"+name+"','"+phoneno+"','"+email+"','"+secret+"')";
                    try
                    {
                        conn1 c=new conn1();
                        c.s.executeUpdate(str2);
                    }catch (Exception e){}
                    JOptionPane.showMessageDialog(null,"Successfully Added New Contact");
                    new Form1().setVisible(true);
                    this.setVisible(false);
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Invlaid Details");
                }
            }
            else if(ae.getSource()==b2)
            {
                try
                {
                    conn1 c=new conn1();
                    ResultSet rs=c.s.executeQuery("select secret from login where email='"+ZohoSignIn.id+"'");
                    if(rs.next())
                    {
                        String id2=rs.getString(1);
                        ResultSet rs1=c.s.executeQuery("select name,phoneno,email from form where secret='"+id2+"'");
                        tb1.setModel(DbUtils.resultSetToTableModel(rs1));
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null,"No Details Found");
                    }
                }catch(Exception e){
                    System.out.println(e);
                }
            }
    }
    public static void main(String arg[])
    {
        new Form1().setVisible(true);
    }
}