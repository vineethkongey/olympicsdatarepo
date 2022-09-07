package genericLibrary;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

/**
 * this class contains all the database methods like connection to database,close to
 * the database
 * @author vineeth konge
 *
 */
public class DatabaseLibrary {
	
	Driver driverRef;
	Connection con=null;
	
	/**
	 * this method will establish connection with database
	 * @throws Throwable
	 */
	public void connectToDB() throws Throwable {
		driverRef= new  Driver();
		/*Driver manager is concrete class*/
		DriverManager.registerDriver(driverRef);
		con=DriverManager.getConnection(ConstantLibrary.dbURL, ConstantLibrary.dbUsername, ConstantLibrary.dbPassword);
		
	}
	/**
	 * this method will close the database connection
	 * @throws Throwable
	 */
	public void closeDB() throws Throwable {
		con.close();
	}
	
	public String executeQueryandReturnData(String query, int columnIndex, String expData) throws Throwable {
		boolean flag=false;
		//Statement stat = con.createStatement();
		//ResultSet result = stat.executeQuery(query);
		ResultSet result=con.createStatement().executeQuery(query);
		while(result.next())
		{ 
			String actData = result.getString(columnIndex);
			if(expData.equalsIgnoreCase(actData))
			{
				flag = true;
				break;
			}
		}
		if(flag) {
			System.out.println("data verification successfull");
			return expData;
		}
		else
		{
			System.out.println("data verification failed");
			return "";
		}
	}
}
