package practice.authentication;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class BasicAuthenticationPractice {
	
	@Test
	public void basicAuth() {
		baseURI="http://localhost";
		port=8084;
		
		given()
		.auth().basic("rmgyantra", "rmgy@9999")
		.when().get("/login")
		.then().log().all();
		
	}
	@Test
	public void preEmptive() {
		baseURI="http://localhost";
		port=8084;
		given()
		.auth().preemptive().basic("rmgyantra", "rmgy@9999")
		.when().get("/login")
		.then().log().all();
	}

}
