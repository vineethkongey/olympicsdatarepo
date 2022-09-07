 package responseValidation;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojoclass.ProjectLibrary;

import static io.restassured.RestAssured.*;

import java.util.Random;

public class DynamicResponseForPost {
	
	@Test
	public void CreatePost() {
		String expData="Successfully Added";
		
		baseURI="http://localhost:8084";
		Random ran = new Random();
		int random =ran.nextInt(500);
		
		//step 1: create data
		ProjectLibrary pLib=new ProjectLibrary("raju","xebia__"+random,"completed",25);
		
		//step 2: send request
		Response resp = given()
		.body(pLib)
		.contentType(ContentType.JSON)
		.when()
		.post("/addProject");
		
		//step 3: provide validation
		String actDat= resp.jsonPath().get("msg");
		Assert.assertEquals(expData,actDat);
	
	}

}
