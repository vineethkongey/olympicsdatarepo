package authentication;

import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class BearerToken {
	@Test
	public void bearerToken() {
		baseURI="https://api.github.com";
		//endpoint:: /user/repos
		JSONObject jobj = new JSONObject();
		jobj.put("name", "bearerTokenRest");
		jobj.put("description", "Rest in peace");
		
		given().auth().oauth2("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")
		.body(jobj).contentType(ContentType.JSON)
		
		.when().post("/user/repos")
		.then().log().all();
	
		
	}

}
