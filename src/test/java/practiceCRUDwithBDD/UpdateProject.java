package practiceCRUDwithBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class UpdateProject {
		
	@Test
	public void updateprojectTest() {
		baseURI="http://localhost:8084";
		//step 1: create data
				JSONObject jobj= new JSONObject();
				jobj.put("createdBy", "kashish");
				jobj.put("projectName", "hp");
				jobj.put("status", "created");
				jobj.put("teamSize", 2000);
				
		//step 2: send request
			given()
			.body(jobj)
			.contentType(ContentType.JSON)
			.when()
			.put("/projects/TY_PROJ_1406")
			.then()
			.log().all();
				
	}
}
