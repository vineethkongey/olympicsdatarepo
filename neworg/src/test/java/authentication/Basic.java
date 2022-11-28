package authentication;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class Basic {
	@Test
	public void basicAuth() {
		 baseURI = "http://coop.apps.symfonycasts.com";
		given()
		.auth()
		.basic("infotokvineeth@gmail.com", "aries@101197")
		.when()
		.get("/login")
		.then().log().all();
		
	}

}
