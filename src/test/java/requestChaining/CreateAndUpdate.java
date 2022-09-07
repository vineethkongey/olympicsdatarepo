package requestChaining;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import pojoclass.ProjectLibrary;

import static io.restassured.RestAssured.*;

import java.util.Random;

public class CreateAndUpdate {
	
	@Test
	public void createAndUpdate() {
		baseURI="http://localhost";
		port=8084;
		
		Random ran = new Random();
		int random = ran.nextInt(500);
		             
		           /*create data using pojo class*/
	ProjectLibrary plib= new ProjectLibrary("vaishnav", "mi_"+random, "on going", 52);
	      Response res = given()
		                .body(plib)
		                .contentType(ContentType.JSON)
		                .when()
		                .post("/addProject");
		             res.then().assertThat().log().all();
		
		          /*step 2: capture the data using json path*/
		           /*step 3: store the data in a variable*/
				String captID = res.jsonPath().get("projectId");
		 		System.out.println(captID);
		 		
		           /*step 4: update the data*/
		          /*create another request*/
	ProjectLibrary plib1= new ProjectLibrary("vaishnav", "mi_"+random, "updated", 52); 
		 		           given()
		 		          .pathParam("pid", captID)
		 		          .body(plib1)
		 		          .contentType(ContentType.JSON)
		 		          .when()
		 		          .put("/projects/{pid}")
		 		
		            /*step 5:validate */
		 		          .then().log().all();
	
		
	}
}
