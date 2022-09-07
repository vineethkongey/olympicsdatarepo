package practiceCRUDwithoutBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class CreateProjectTest {
	
	@Test
	public void createProjectTest() {
		
		/*step 1: create the data necessary - data:request body*/
			JSONObject jobj=new JSONObject();
			jobj.put("createdBy", "pantheon11");
			jobj.put("projectName", "intel");
			jobj.put("status","on going");
			jobj.put("teamsize", 5);
			
			/*Step 2: send the request*/
			RequestSpecification req = RestAssured.given();//given:preconditions
			req.body(jobj);
			req.contentType(ContentType.JSON);
			
			Response response = req.post("http://localhost:8084/addProject");
			
			/*step 3: validate the response*/
			System.out.println(response.prettyPeek());
			
			ValidatableResponse validate = response.then();
			validate.log().all();
		
	}
	
}
