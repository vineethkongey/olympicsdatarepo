package restassuredpost;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class GetAllProjects {
	@Test
	public void getAllProject() {
		
		when()
		.get("https://reqres.in/api/users?page=2")
		.then()
		.assertThat().statusCode(200).log().all();
		

	}

}
