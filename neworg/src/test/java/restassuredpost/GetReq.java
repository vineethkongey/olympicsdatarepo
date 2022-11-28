package restassuredpost;

import javax.annotation.meta.When;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;

public class GetReq {
	//id=61
	public void get() {
		
		when()
		.post("https://reqres.in/api/users/61")
		.then()
		.assertThat().statusCode(200);
		
	}

}
