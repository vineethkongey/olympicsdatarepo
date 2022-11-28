package requestchaining;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import com.google.gson.JsonObject;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.Random;

public class CreateAndGet {
	@Test
	public void requestchain() {
		baseURI="https://reqres.in";
		Random r = new Random();
		int num = r.nextInt(100);
		
		//create data
		JSONObject obj = new JSONObject();
		obj.put("name", "pari2");
		obj.put("address", "ooty");
		Response resp = given().body(obj).contentType(ContentType.JSON)
		.when().post("/api/users");
		String captureId = resp.jsonPath().get("id");
		System.out.println(captureId);
		//get data
		given().pathParam("pid",captureId )
		.when().get("/api/users?page=2")
		.then().assertThat().statusCode(200).log().all();
		
	}

}
