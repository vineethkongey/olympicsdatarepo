package practiceCRUDwithoutBDD;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class UpdateProject {
	
	@Test
	public void updateProjectTest() {
		JSONObject jobj=new JSONObject();
		jobj.put("createdBy", "pantheon11");
		jobj.put("projectName", "intel");
		jobj.put("status","created");
		jobj.put("teamSize", 3);
		
		/*Step 2: send the request*/
		RequestSpecification req = RestAssured.given();
		req.body(jobj);
		req.contentType(ContentType.JSON);
		
		Response response = req.put("http://localhost:8084/projects/TY_PROJ_1211");
		//validate response
		response.then().log().all();
		response.then().assertThat().statusCode(200);
	}
}
