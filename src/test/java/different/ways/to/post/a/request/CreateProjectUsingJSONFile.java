package different.ways.to.post.a.request;

import java.io.File;
import java.util.Random;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreateProjectUsingJSONFile {
	@Test
	public void createProject() {
	 baseURI = "http://localhost:8084";
	
	//Step 1: create necessary data
		//Step 2: send a request
		File file =new File(".\\jsondata.json");
		given()
		.body(file)
		.contentType(ContentType.JSON)
		.when()
		.post("/addProject")
		.then()
		.assertThat().statusCode(201)
		.log().all();
	
		
	}

}
