package responseValidation;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.response.Response;


import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class ResponseTimeValidationUsingHamCrest {
	
	@Test
	public void responseTimeValidation() {
	 baseURI="http://localhost";
	 port=8084;
	 
	 //step 2: send request
	 				Response resp = when()
	 				 .get("/projects");
	 				
	 //validate response time
	 		resp.then().time(Matchers.lessThan(500L),TimeUnit.MILLISECONDS);
	 			
	 				
	 				
	 				
	 				
//	 				  long actualTime = resp.getTime();
//	 				 resp.then().time(Matchers.lessThan(500L),TimeUnit.MILLISECONDS);
//	 		System.out.println(actualTime);		
	}

}
