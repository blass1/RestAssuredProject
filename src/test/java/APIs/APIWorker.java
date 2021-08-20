package APIs;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import APIs.Body;
import Repositories.Repo_Endpoints;

public class APIWorker {
	
	public String GetAccessToken() {
		
		String token_resp = "";
		
		baseURI = "https://reqres.in/api/login";
		
		Body body = new Body();
		
		token_resp = given()
			.header("Content-Type", "application/json")
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(body.access())
		.when()
			.post()
		.then()
			.statusCode(200)
			.extract()
			.body()
			.asString();
		
		return "bearer "+ JsonPath.from(token_resp).get("token");
	}
	
	@Test
	void GET () {
		
		Repo_Endpoints endpoint = new Repo_Endpoints();
		baseURI = endpoint.ep_loginTest();
		
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
