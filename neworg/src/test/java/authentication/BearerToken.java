package authentication;

import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class BearerToken {
	@Test
	public void bearer() {
		
		baseURI = "https://api.github.com";
		HashMap m = new HashMap();
		m.put("name", "pari");
		
		given().auth().oauth2("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")
		.body(m).contentType(ContentType.JSON)
		.when().post("/user/repos")
		.then().log().all();
		
		
	}

}
