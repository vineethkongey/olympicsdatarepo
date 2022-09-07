package practiceCRUDwithBDD;

import static org.testng.Assert.assertTrue;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreateProject {
	
	@Test
	public void createnewprojectTest() {
		//step 1: create data
		JSONObject jobj= new JSONObject();
		jobj.put("createdBy", "kashish");
		jobj.put("projectName", "hp");
		jobj.put("status", "on going");
		jobj.put("teamSize", 10);
		
		//step 2: send request
		
		given()
		.body(jobj)
		.contentType(ContentType.JSON)
		
		.when()
		.post("http://localhost:8084/addProject")
		.then()
		
		.contentType(ContentType.JSON)
		.log().all();
		
	}

}
