package practiceCRUDwithoutBDD;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetSingleProject {
	
	@Test 
	public void getsingleprojectTest() {
		
		//step:1 create necessary data 
		
		//step 2: send request
		Response response = RestAssured.when().get("http://localhost:8084/projects/TY_PROJ_1403");
		
		//step 3: validate
		System.out.println(response.getHeaders());
		
	}

}
