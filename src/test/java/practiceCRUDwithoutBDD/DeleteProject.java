package practiceCRUDwithoutBDD;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DeleteProject {
		@Test
	public void deleteProjectTest() {
		
		//step 1: create data
		
		//step 2: send request
		Response response = RestAssured.delete("http://localhost:8084/projects/TY_PROJ_1211");
		
		//step 3: validate response
		response.then().log().all();
		response.then().assertThat().statusCode(204);
		
		
	}
}
