package parameters;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class QueryParameters {
	
	@Test
	public void queryparameterTest() {
		baseURI ="https://reqres.in";
		
		//step 1: pre requisites
		given()
		.queryParam("page", 3)
		//step 2: send the request
		.when()
		.get("/api/users")
		//step:3 validate the response
		.then().log().all();
	}
}
