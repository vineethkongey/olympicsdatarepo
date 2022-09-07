package responseValidation;

import org.testng.annotations.Test;

import io.restassured.response.Response;
import junit.framework.Assert;

import static io.restassured.RestAssured.*;

import java.util.List;

public class DynamicResponseValidation {
	
	@Test
	public void dynamicResponse() {
		
		String expData="TY_PROJ_2202";
		
		baseURI="http://localhost";
		port=8084;
		
		//step 2: send Request
		Response resp = when()
		.get("/projects");
		
		//step 3: capture all the project ids
		boolean flag=false;
		List<String> list = resp.jsonPath().get("projectId");
		for(String actData:list) {
			if(actData.equalsIgnoreCase(expData)) {
				flag=true;
				break;
			}
		}
		
		if(flag) {
			System.out.println();
		}
		else {
			System.out.println();
		}
		Assert.assertEquals(true, flag);
		long resTime = resp.getTime();
		System.out.println(resTime);
	}

}
