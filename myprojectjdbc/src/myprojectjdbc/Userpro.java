package myprojectjdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Userpro 
{
	@SuppressWarnings("resource")
	public void Insert()
	{
		try
		{
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/developers","root","Theroshni@01");
		
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter username:");
		String username =sc.nextLine();
		System.out.println("Enter Email:");
		String email =sc.nextLine();
		System.out.println("Enter fullname");
		String fullname =sc.nextLine();
		System.out.println("Enter password");
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
			System.out.println("\n A new user has been Inserted Successfully...");
		}
		System.out.println("\n After Inserting... \n ");
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
	@SuppressWarnings("unused")
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
			String username= result.getString("username");
			String fullname= result.getString("fullname");
			String email= result.getString("email");
			String password= result.getString("password");
			
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
		String sql= "UPDATE users SET password='secret' WHERE username='rose'";
		Statement statement= con.createStatement();
		
		int rows= statement.executeUpdate(sql);
		
		if(rows > 0)
		{
			System.out.println(" \n The user's information has been Updated Successfully...");
		}
		System.out.println("\n After Updateting... \n ");
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
		
		String sql= "DELETE FROM users WHERE username= 'Althaf'";
		PreparedStatement statement = con.prepareStatement(sql);
		
		int rows= statement.executeUpdate();
		
		if(rows > 0)
		{
			System.out.println("\n The user's information has been Deleted Successfully...");
		}
		
		System.out.println("\n After Deleting... \n");
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
	
	
@SuppressWarnings("resource")
public static void main(String[] args) 
{

Userpro obj=new Userpro();

try
{
	int n;
do 
{
System.out.println("***** JDBC CRUD PROJECT *****");
System.out.println("Enter your choice:");
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




