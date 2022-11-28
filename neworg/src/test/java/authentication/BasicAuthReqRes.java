package authentication;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.util.HashMap;

public class BasicAuthReqRes {
	@Test
	public void basic() {
		
		 baseURI = "https://reqres.in";
		given()
		.auth()
		.basic("infotokvineeth@reqres.in", "ciska")
		
	.when().post("/api/login")
	.then().assertThat().statusCode(200).log().all();
		
	}

}
