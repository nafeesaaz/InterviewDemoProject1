package g;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyListener implements ServletContextListener
{

	@Override
	public void contextInitialized(ServletContextEvent arg0) 
	{
		int status=0;
		Connection con=null;
		
		
		try 
		{
			con=GetCon.getCon();
			PreparedStatement ps=con.prepareStatement("select * from accountInfo");
			try
			{
			status=ps.executeUpdate();
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				status=2;
			}
		} 
		catch (SQLException e) 
		{
			
			e.printStackTrace();
		}
		if(status==0)
		{
			System.out.println("table already created....");
		}
		else if(status==2)
		{
			System.out.println("table is not created....");
		}
		System.out.println("project deployed");
	}
	
	
	
	@Override
	public void contextDestroyed(ServletContextEvent arg0) 
	{
		System.out.println("project undeployed");
		
	}

	

}
