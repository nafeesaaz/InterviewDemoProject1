package g;

import java.sql.DriverManager;
import java.sql.Connection;


public class GetCon
{
	public static Connection con;
	static
	{
		try 
		{
			Class.forName(DBInitializer.DRIVER);
			con=DriverManager.getConnection(DBInitializer.URL,DBInitializer.USERNAME,DBInitializer.PASSWORD);
			
		} 
		catch (Exception e)
		{
			
			e.printStackTrace();
		}
		
	}
	
	public static Connection getCon()
	{
		return con;
	}
}
