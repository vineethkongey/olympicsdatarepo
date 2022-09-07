package parameters;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class PathParameters {
	@Test
	public void pathParameters() {
		
		baseURI="http://localhost";
		port=8084;
		
		//step 1: pre requisites
		given()
		.pathParam("pid", "TY_PROJ_608")
		//step 2: send the request
		.when()
		.get("/projects/{pid}")
		//validate the response
		.then()
		.assertThat().statusCode(200).log().all();
		
		
	}
}
