package APIs;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class APIWorker {
	
	public String GetAccessToken() {
		
		String token = "";
		
		baseURI = "https://reqres.in/api/login";
		
		JSONObject request = new JSONObject();
		
		request.put( "email", "eve.holt@reqres.in");
		request.put("password", "cityslicka");
		
		token = given()
			.header("Content-Type", "application/json")
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(request.toJSONString())
		.when()
			.post(/*"/api/login"*/)
		.then()
			.statusCode(200)
			.extract()
			.body()
			.asString().substring(10, 27);
		
		System.out.println("bearer "+token);
		return "bearer "+token;
	}
	
	@Test
	void Test_Get () {
		
		baseURI = "https://reqres.in/api/users/2";
		
		String response = given()
				.header("Content-Type", "application/json", "Authorization", GetAccessToken())
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
			.when()
				.get()
			.then()
				.statusCode(200)
			.extract()
			.body()
			.asString();
		
		System.out.println(response);
	}
	
}
