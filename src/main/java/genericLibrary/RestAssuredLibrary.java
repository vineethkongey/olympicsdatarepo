package genericLibrary;

import static io.restassured.RestAssured.*;

import io.restassured.response.Response;

public class RestAssuredLibrary {
	
	
	public String getJsonData(Response response, String path) 
	{
		
		String jsonData=response.jsonPath().get(path);
		return jsonData;
	
		}
	
		
	public void logAll(Response response) 
	{
			
		response.then().log().all();
	}


	
	
	}

