package restassuredpost;

import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;




public class PostReq {
	@Test
	public void m1() {
		HashMap m = new HashMap();
		m.put("name", "pari");
		m.put("job", "test engineer");
		
		given()
		.body(m)
		.contentType(ContentType.JSON)
		
		.when()
		.post("https://reqres.in/api/users")
		
		.then().assertThat().log().all();
		
	}

}
