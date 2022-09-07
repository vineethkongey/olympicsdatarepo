package requestChaining;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojoclass.ProjectLibrary;

import static io.restassured.RestAssured.*;

import java.util.Random;

public class CreateAndDelete {
	@Test
	public void createAndDelete() {
		baseURI="http://localhost";
		port=8084;
		
		Random  ran =new Random();
		int random = ran.nextInt(500);
		
		      /*step 1: create project using post*/
		
	ProjectLibrary plib = new ProjectLibrary("rammi", "hylex"+random, "created", 45);
		      Response resp = given()
		                      .body(plib)
		                      .contentType(ContentType.JSON)
		                      .when()
		                      .post("/addProject");
		           resp.then().assertThat().statusCode(201).log().all();
		
		      /*Step 2:capture the response using json path*/
		        /*Step 3:store the data in variable*/
		String capturePID = resp.jsonPath().get("projectId");
		      System.out.println(capturePID);
		
		           /*step 4: delete data*/
	                        	given()
		                       .pathParam("pid", capturePID)
		                       .when()
		                       .delete("/projects/{pid}")
		
		            /*step 5: validate*/
		                       .then().assertThat().statusCode(204).log().all();
		
		
		
		
		
	}

}
