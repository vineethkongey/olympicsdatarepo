package different.ways.to.post.a.request;

import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreateAProjectUsingHashMap {
	
	@Test
	public void post() {
		//step1 : create necessary data
		HashMap m=new HashMap();
		m.put("createdBy", "samurai");
		m.put("projectName", "bangladesh");
		m.put("status", "on going");
		m.put("teamSize", 1);
		
		//send request
		given()
		.body(m)
		.contentType(ContentType.JSON)
		
		.when()
		.post("http://localhost:8084/addProject")
		.then()
		.assertThat().statusCode(201)
		.log().all();
		
		
	}

}
