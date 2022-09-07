package practiceCRUDwithoutBDD;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetAllProject {
	
	@Test
	public void getallProjectTest() {
		
		//step 1: create necessary data //given
		
		//step 2: send request //when
		Response response = RestAssured.get("http://localhost:8084/projects");
		
		//step 3: validate response//then
		response.then().log().all();
		
		
	}

}
