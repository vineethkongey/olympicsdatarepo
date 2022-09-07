package practice.authentication;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class BearerToken {
	
	@Test
	public void bearerTokenTest() {
		
		baseURI="https://api.github.com";
		JSONObject jobj=new JSONObject();
		jobj.put("name", "restapirepo");
		jobj.put("description", "rest");
		
		given().auth().oauth2("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")
		.body(jobj)
		.contentType(ContentType.JSON)
		.when().post("/user/repos")
		.then().log().all();
		
	}
}
