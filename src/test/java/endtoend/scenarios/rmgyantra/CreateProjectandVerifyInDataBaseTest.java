package endtoend.scenarios.rmgyantra;

import org.testng.Assert;
import org.testng.annotations.Test;

import genericLibrary.BaseAPIClass;
import genericLibrary.DatabaseLibrary;
import genericLibrary.EndPointsLibrary;
import genericLibrary.JavaLibrary;
import genericLibrary.RestAssuredLibrary;
import io.restassured.http.ContentType;
import io.restassured.response.Response;


import static io.restassured.RestAssured.*;
import pojoclass.ProjectLibrary;

public class CreateProjectandVerifyInDataBaseTest extends BaseAPIClass{
	
	@Test
	public void createProject() throws Throwable {
		
		//RestAssuredLibrary rLib=new RestAssuredLibrary();
		//DatabaseLibrary dLib= new DatabaseLibrary();
		
		/*step 1: create data*/
		ProjectLibrary plib= new ProjectLibrary("kiran", "amdocs_"+jLib.getRandomNumber(), "created", 25);
		
		/*Step 2: send request*/
			Response response = given()
			.body(plib)
			.contentType(ContentType.JSON)
			.when()
			.post(EndPointsLibrary.createProject);
		/*Step 3: Api response and capture the response*/	
			rLib.logAll(response);
			String proId = rLib.getJsonData(response, "projectId");
			System.out.println(proId);
		
		/*validate response in database*/
			
			String query="select * from project";
			//dLib.connectToDB();
			String data = dLib.executeQueryandReturnData(query, 1, proId);
			System.out.println(data);
			
			Assert.assertEquals(proId, data);
			
			//dLib.closeDB();
		
		
		
	}

}
