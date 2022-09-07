package genericLibrary;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class BaseAPIClass {
	
	public DatabaseLibrary dLib= new DatabaseLibrary();
	public JavaLibrary jLib=new JavaLibrary();
	public RestAssuredLibrary rLib= new RestAssuredLibrary();

	@BeforeSuite
	public void bsConfig() throws Throwable {
		
		baseURI="http://localhost";
		port=8084;
		
		dLib.connectToDB();
		System.out.println("===database connection successful");
		
		}
	
	@AfterSuite
	public void asConfig() throws Throwable {
		dLib.closeDB();
		System.out.println("== database connection closed==");
		
		}
	
	

}
