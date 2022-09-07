package dataDrivenTestingUsingRestAssured;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import junit.framework.Assert;
import pojoclass.ProjectLibrary;

import static io.restassured.RestAssured.*;

import java.util.Random;

public class CreateMultipleProjects {
	
	@Test(dataProvider="getData")
	public void createMultipleProjects(String createdBy, String projectName, int teamSize) {
		
		baseURI="http://localhost";
		port=8084;
		
		Random ran = new Random();
		int random = ran.nextInt(500);
		
		//step 1: read data from data provider
		ProjectLibrary pLib= new ProjectLibrary(createdBy,projectName+random,"created",teamSize);
		
		//step 2: send request
		Response resp = given()
		.body(pLib)
		.contentType(ContentType.JSON)
		.when()
		.post("/addProject");
		
		//step 3: validate response
			String actData = resp.jsonPath().get("msg");
			Assert.assertEquals("Successfully Added", actData);
			resp.then().log().all();
		}
	
	@DataProvider(name="getData")
	public Object[][] getData(){
		
		Object[][] data = new Object[3][3];
		
		data[0][0]="ramya";
		data[0][1]="accoionlabs";
		//data[0][2]="created";
		data[0][2]=20;
		
		data[1][0]="kavya";
		data[1][1]="accoionlabs";
		//data[1][2]="created";
		data[1][2]=10;
		
		data[2][0]="sandhya";
		data[2][1]="accoionlabs";
		//data[2][2]="created";
		data[2][2]=40;
		
		return data;
		
	}

}
