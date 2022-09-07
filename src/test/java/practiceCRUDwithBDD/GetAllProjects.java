package practiceCRUDwithBDD;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class GetAllProjects {
	
	@Test
	public void getAllProjects() {
		
		baseURI="http://localhost:8084";
		
		//step 1: create data
		
		//step 2: send request
		
		when()
		.get("/projects")
		
		.then()
		.assertThat().statusCode(200)
		.log().all();
	
	}

}
