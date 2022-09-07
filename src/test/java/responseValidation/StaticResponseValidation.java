package responseValidation;

import org.testng.annotations.Test;

import io.restassured.response.Response;
import junit.framework.Assert;

import static io.restassured.RestAssured.*;

public class StaticResponseValidation {
	
	@Test
	public void staticResponse() {
		
		baseURI="http://localhost:8084";
		//step 1: createData
		//step 2:send a Request-get all projects
		Response resp = when()
		.get("/projects");
		
		//step 3: provide validation
		String expData = "TY_PROJ_1005";
		String actData=resp.jsonPath().get("[3].projectId");
		
		Assert.assertEquals(expData, actData);
		System.out.println("data verification successful");
		
		
		
	}

}
