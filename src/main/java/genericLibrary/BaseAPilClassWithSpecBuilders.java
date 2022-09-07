package genericLibrary;

import static io.restassured.RestAssured.*;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class BaseAPilClassWithSpecBuilders {
	public RequestSpecification req;
	public DatabaseLibrary dLib=new DatabaseLibrary();
	
	@BeforeSuite
	public void bsConfig() throws Throwable {
		
		RequestSpecBuilder reqSpec= new RequestSpecBuilder();
		reqSpec.setBaseUri("http://localhost:8084");
		reqSpec.setContentType(ContentType.JSON);
		
		req=reqSpec.build();
		dLib.connectToDB();
		
		System.out.println("==connected to database");
		
	}
	
	@AfterSuite
	public void asConfig() throws Throwable {
		dLib.closeDB();
		System.out.println("==database connection is closed");
	}
	

}
