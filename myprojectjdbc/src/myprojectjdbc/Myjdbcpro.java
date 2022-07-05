package myprojectjdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import myprojectjdbc.Myjdbcpro;

public class Myjdbcpro
{
	public void Insert()
	{
		try
		{
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/developers","root","Theroshni@01");
		
		@SuppressWarnings("resource")
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter username:");
		String username =sc.nextLine();
		System.out.println("Enter email:");
		String email =sc.nextLine();
		System.out.println("Enter fullname:");
		String fullname =sc.nextLine();
		System.out.println("Enter password:");
		String password =sc.nextLine();
		
		String sql= "INSERT INTO users (username, email, fullname, password)"+ "VALUES(?, ?, ?, ?)";
		PreparedStatement statement = con.prepareStatement(sql);
		statement.setString(1, username);
		statement.setString(2, email);
		statement.setString(3, fullname);
		statement.setString(4, password);
	
		int rows = statement.executeUpdate();
	
		if(rows > 0)
		{
			System.out.println(" A new user has been Inserted Successfully...");
		}
		System.out.println("After Inserting");
		ResultSet rs1=statement.executeQuery("select * from users");
		while(rs1.next())
		{
			System.out.println(rs1.getString(1)+"\t"+rs1.getString(2)+"\t"+rs1.getString(3)+"\t"+rs1.getString(4));
		}
	}
	catch (Exception e)
	{
		System.out.println(e.toString());
	}
	}
	public void Display()
	{
		try
		{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/developers","root","Theroshni@01");
		String sql= "SELECT * FROM users";
		Statement statement= con.createStatement();
		ResultSet result= statement.executeQuery(sql);
		
		while(result.next())
		{
			
			System.out.println(result.getString(1)+"\t"+result.getString(2)+"\t"+result.getString(3)+"\t"+result.getString(4));
			
		}
		}
		catch (Exception e)
		{
			System.out.println(e.toString());
		}
	}
	public void Update()
	{
		try
		{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/developers","root","Theroshni@01");
		String sql= "UPDATE users SET password='secret' WHERE username='rose01'";
		Statement statement= con.createStatement();
		
		int rows= statement.executeUpdate(sql);
		
		if(rows > 0)
		{
			System.out.println(" The user's information has been Updated Successfully...");
		}
		System.out.println("After Update");
		ResultSet rs1=statement.executeQuery("select * from users");
		while(rs1.next())
		{
		System.out.println(rs1.getString(1)+"\t"+rs1.getString(2)+"\t"+rs1.getString(3)+"\t"+rs1.getString(4));
		}
		}
	
		catch (Exception e)
		{
			System.out.println(e.toString());
		}
	}
	public void Delete()
	{
		try
		{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/developers","root","Theroshni@01");
		
		String sql= "DELETE FROM users WHERE username= 'rose01'";
		PreparedStatement statement = con.prepareStatement(sql);
		
		int rows= statement.executeUpdate();
		
		if(rows > 0)
		{
			System.out.println(" The user's information has been Deleted Successfully...");
		}
		System.out.println("After Delete");
		ResultSet rs1=statement.executeQuery("select * from users");
		while(rs1.next())
		{
		System.out.println(rs1.getString(1)+"\t"+rs1.getString(2)+"\t"+rs1.getString(3)+"\t"+rs1.getString(4));
		}
		}
		catch (Exception e)
		{
			System.out.println(e.toString());
		}
	}
	
	
public static void main(String[] args) 
{

	Myjdbcpro obj=new Myjdbcpro();
	
try
{
int n;
do {
System.out.println("***** JDBC CRUD PROJECT *****");
System.out.println("Enter your choice:");
@SuppressWarnings("resource")
Scanner s=new Scanner(System.in);
n=s.nextInt();
switch(n)
{
	case 1:
	{
		System.out.println("1. Insert \n Enter the Values...");
		obj.Insert();
		break;
	}
	case 2:
	{
		System.out.println("2. Display... ");
		obj.Display();
		break;
	}
	case 3:
	{
		System.out.println("3. Update... \n Enter the Values...");
		obj.Update();
		break;
	}
	case 4:
	{
		System.out.println("4. Delete...");
		obj.Delete();
		break;
	}
	default:
	{
		System.out.println("Exit");
		System.exit(0);
		break;
	}
}
}while(n!=0);
}
catch (Exception ex) 
{
	ex.printStackTrace();
}
}

}
