package different.ways.to.post.a.request;

import static org.junit.Assert.assertThat;

import java.util.Random;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreateProjectUsingJSONobject {
	
	//step 1: create data
	@Test
	public void postaRequest() {
		
		baseURI="http://localhost:8084";
		Random ran = new Random();
		int random = ran.nextInt(500);
		
		JSONObject jobj=new JSONObject();
		jobj.put("createdBy", "amir");
		jobj.put("projectName", "actor__"+random);
		jobj.put("status", "ongoing");
		jobj.put("teamSize", 15);
		//
	
			given()
			.body(jobj)
			.contentType(ContentType.JSON)
			
			.when()
			.post("/addProject")
			.then()
			.assertThat().statusCode(201)
			.log().all();
	

}
}