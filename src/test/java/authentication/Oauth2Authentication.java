package authentication;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class Oauth2Authentication {
	
	@Test
	public void oauth2Authentication() {
		 Response resp = given()
		.formParam("client_id", "MySdet31CoopApp")
		.formParam("client_secret", "e2f726fc5cf4d60178d0f0e4735eb921")
		.formParam("grant_type", "client_credentials")
		.formParam("redirect_uri", "http://vineeth.com")
		.formParam("code", "authorization_code")
		
		.when()
		.post("http://coop.apps.symfonycasts.com/token");
		 resp.then().log().all();
		//capture the token from response
		//resp.jsonPath().get("acess")
	}
}
