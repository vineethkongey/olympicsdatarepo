package parameters;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class QueryParameters {
	@Test
	public void queryparam() {
		
		baseURI="https://reqres.in";
		given()
		.queryParam("page", 3)
		.when()
		.get("/api/users")
		.then().log().all();
	
		
	}

}
