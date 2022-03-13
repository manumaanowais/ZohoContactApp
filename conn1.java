package pkg;

import java.sql.*;

public class conn1
{
    Connection c;
    Statement s;
    public conn1()
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            c=DriverManager.getConnection("jdbc:mysql://localhost:3306/zohocontact","root","numaan");
            s=c.createStatement();
        }catch(Exception e)
        {
            System.out.println(e);
        }
    }
}