package myprojectjdbc;

import java.util.Scanner;

import java.sql.*;

public class Jdbcproject 
{
		
			public void Insert()
			{
				try
				{
				
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/developers","root","Theroshni@01");
				
				
				Scanner sc= new Scanner(System.in);
				Scanner sc1= new Scanner(System.in);
				System.out.println("Enter P_id:");
				Integer P_id =sc.nextInt();
				System.out.println("Enter Name:");
				String Name =sc1.nextLine();
				System.out.println("Enter Price");
				Integer Price =sc.nextInt();
				System.out.println("Enter Quantity:");
				Integer Quantity =sc.nextInt();
				System.out.println("Enter Brand:");
				String Brand =sc1.nextLine();
				
				String sql="insert into products(P_id, Name, Price, Quantity, Brand)"+"values(?, ?, ?, ?, ?)";
				PreparedStatement statement = con.prepareStatement(sql);
				statement.setInt(1, P_id);
				statement.setString(2, Name);
				statement.setInt(3, Price);
				statement.setInt(4, Quantity);
				statement.setString(5, Brand);
				
				int rows = statement.executeUpdate();
				
				System.out.println("After Inserting...");
				ResultSet rs1=statement.executeQuery("select * from products");
				
				while(rs1.next())
				{
				System.out.println(rs1.getString(1)+"\t"+rs1.getString(2)+"\t"+rs1.getString(3)+"\t"+rs1.getString(4)+"\t"+rs1.getString(5));
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
				Statement st=con.createStatement();
				ResultSet rs=st.executeQuery("select * from products");
				while(rs.next())
				{
				System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4)+"\t"+rs.getString(5));
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
				
				Statement statement=con.createStatement();
				
				/*Scanner sc= new Scanner(System.in);
				Scanner sc1= new Scanner(System.in);
				System.out.println("Enter P_id:");
				Integer P_id =sc.nextInt();
				System.out.println("Enter Name:");
				String Name =sc1.nextLine();
				System.out.println("Enter Price");
				Integer Price =sc.nextInt();
				System.out.println("Enter Quantity:");
				Integer Quantity =sc.nextInt();
				System.out.println("Enter Brand:");
				String Brand =sc1.nextLine();
				
				String sql="update products"+" set (?) where (?);";
				PreparedStatement statement = con.prepareStatement(sql);
				statement.setInt(1, P_id);
				statement.setString(2, Name);
				statement.setInt(3, Price);
				statement.setInt(4, Quantity);
				statement.setString(5, Brand);
				
				int rows = statement.executeUpdate();*/
				
				String sql="update products set Name='Body lotion' where Brand='Vaseline';";
				int rows = statement.executeUpdate(sql); 
				
				System.out.println("After Updating...");
				ResultSet rs1=statement.executeQuery("select * from products");
				while(rs1.next())
				{
				System.out.println(rs1.getString(1)+"\t"+rs1.getString(2)+"\t"+rs1.getString(3)+"\t"+rs1.getString(4)+"\t"+rs1.getString(5));
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
				
				//Statement statement=con.createStatement();
				
				/*Scanner sc= new Scanner(System.in);
				Scanner sc1= new Scanner(System.in);
				System.out.println("Enter P_id:");
				Integer P_id =sc.nextInt();
				System.out.println("Enter Name:");
				String Name =sc1.nextLine();
				System.out.println("Enter Price");
				Integer Price =sc.nextInt();
				System.out.println("Enter Quantity:");
				Integer Quantity =sc.nextInt();
				System.out.println("Enter Brand:");
				String Brand =sc1.nextLine();
				
				String sql="delete from products"+ "where(?, ?, ?, ?, ?)";
				PreparedStatement statement = con.prepareStatement(sql);
				statement.setInt(1, P_id);
				statement.setString(2, Name);
				statement.setInt(3, Price);
				statement.setInt(4, Quantity);
				statement.setString(5, Brand);
				
				int rows = statement.executeUpdate();*/
				
				Scanner sc= new Scanner(System.in);
				System.out.println("Enter P_id:");
				Integer P_id =sc.nextInt();
				
				String sql="delete from products where P_id= 101";
				
				PreparedStatement statement = con.prepareStatement(sql);
				statement.setInt(1, P_id);
				statement.executeUpdate(sql); 
				
				System.out.println("After Deleting...");
				ResultSet rs1=statement.executeQuery("select * from products");
				while(rs1.next())
				{
				System.out.println(rs1.getString(1)+"\t"+rs1.getString(2)+"\t"+rs1.getString(3)+"\t"+rs1.getString(4)+"\t"+rs1.getString(5));
				}
				}
				catch (Exception e)
				{
					System.out.println(e.toString());
				}
				
			}
			
			public static void main(String[] args) 
			{
					//Collection c= new ArrayList<Products>();
					Jdbcproject obj=new Jdbcproject();
					int n;
					do {
					System.out.println("***** JDBC CRUD PROJECT *****");
					System.out.println("Enter your choice:");
					Scanner s=new Scanner(System.in);
					Scanner str= new Scanner(System.in);
					n=s.nextInt();
					switch(n)
					{
						case 1:
						{
							System.out.println("1. Insert...");
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
							System.out.println("3. Update...");
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
							System.out.println("Exited");
							System.exit(0);
							break;
						}
					}
					}while(n!=0);
	
				}
}

