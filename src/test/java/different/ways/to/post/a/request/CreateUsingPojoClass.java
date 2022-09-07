package different.ways.to.post.a.request;

import static io.restassured.RestAssured.*;

import java.util.Random;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import pojoclass.ProjectLibrary;

public class CreateUsingPojoClass {
	@Test
	public void createProject() {
		baseURI="http://localhost:8084";
		Random ran =new Random();
		int random = ran.nextInt(1500);
		
		//step1: create data
		ProjectLibrary pLib= new ProjectLibrary("Sunita", "amdocs_"+random, "created", 25);
		
		//Step 2: send data
		given()
		.body(pLib)
		.contentType(ContentType.JSON)
		.when()
		.post("/addProject")
		.then()
		.assertThat().statusCode(201)
		.log().all();
		
		
	}
	
}
