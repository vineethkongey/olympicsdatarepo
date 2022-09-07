  package requestChaining;

import static io.restassured.RestAssured.*;

import java.util.Random;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojoclass.ProjectLibrary;

public class CreateAndGet {
	@Test
	public void createDataAndGet() {
		
		baseURI="http://localhost";
		port=8084;
		Random ran = new Random();
		int random = ran.nextInt(200);
		
		/*create data*/
		//step 1: create project using post
		ProjectLibrary pLib= new ProjectLibrary("kusha", "amity_"+random, "on going", 7);
		Response resp = given()
							.body(pLib)
							.contentType(ContentType.JSON)
							.when()
							.post("/addProject");
		
		/*Step 2:capture the response using json path*/
		/*Step 3:store the data in variable*/
		String capturePID = resp.jsonPath().get("projectId");
		System.out.println(capturePID);
		
		/*step 4: get data*/
					given()
					.pathParam("pid", capturePID)
					.when()
					.get("/projects/{pid}")
		
	   /*step 5: validate*/
				
					.then().assertThat().statusCode(200).log().all();
		
		
					
		
	}
}
