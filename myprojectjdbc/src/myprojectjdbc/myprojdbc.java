package myprojectjdbc;

import java.sql.*;

public class myprojdbc {

	public static void main(String args[])
	{
	try
	{
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/developers","root","Theroshni@01");
	Statement st=con.createStatement();
	ResultSet rs=st.executeQuery("select * from products");
	while(rs.next())
	{
	System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4)+"\t"+rs.getString(5));
	}
	}
	catch(Exception e)
	{
	System.out.println(e.toString());
	}
}
}
