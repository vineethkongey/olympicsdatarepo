package endtoend.scenarios.rmgyantra;

import org.testng.annotations.Test;

import genericLibrary.BaseAPilClassWithSpecBuilders;
import genericLibrary.DatabaseLibrary;
import genericLibrary.EndPointsLibrary;
import genericLibrary.RestAssuredLibrary;
import io.restassured.response.Response;
import junit.framework.Assert;

import static io.restassured.RestAssured.*;
import pojoclass.ProjectLibrary;

public class CreateProjectAndVerifyDBUsingSpecBuilders extends BaseAPilClassWithSpecBuilders {
	
	RestAssuredLibrary rLib = new RestAssuredLibrary();
	DatabaseLibrary dLib=new DatabaseLibrary();
	
	@Test
	public void createProject() throws Throwable {
		
		
		/*create data*/
		ProjectLibrary pLib = new ProjectLibrary("kiran","amdocs", "completed",25);
		
		/*send Request*/
		
		Response response = given().spec(req).body(pLib).when()
							.post(EndPointsLibrary.createProject);
			
		/*api response capture the resp*/	
		
		rLib.logAll(response);
		String proId = rLib.getJsonData(response, "projectId");
		
		System.out.println(proId);
		
		/*validate response in database*/
		String query="select * from project";
		String data = dLib.executeQueryandReturnData(query, 1, proId);
		
		Assert.assertEquals(proId, data);
		
		
		
	}
	
}
