import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.simple.JSONObject;


public class Examples {
	
	
	
	@Test
	void test_get() {
		
		baseURI = "http://localhost:3000";
		
		given()
			.get("/users")
		.then()
			.statusCode(200)
			.log().all();
	}
	
	@Test
	void test_getParam() {
		
		baseURI = "http://localhost:3000";
		
		given()
			.param("name", "ProjectOne")
			.get("/projects")
		.then()
			.statusCode(200)
			.log().all();
	}
	
	@Test
	void test_post() {
		
		baseURI = "http://localhost:3000";
		
		JSONObject request = new JSONObject();
		
		request.put("name", "Manuel");
		request.put("lastname", "Zaraza");
		request.put("rol", "Programmer");
		request.put("Project", 4);
		
		given()
			.header("Content-Type", "application/json")
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(request.toJSONString())
		.when()
			.post("/users")
		.then()
			.statusCode(201)
			.log().all();
	}
	
	@Test
	void test_patch() {
		
		baseURI = "http://localhost:3000";
		
		JSONObject request = new JSONObject();
		
		request.put("name", "Cosme");
		request.put("lastname", "Fulanito");
		request.put("rol", "Actor");
		request.put("Project", 2);
		
		given()
			.header("Content-Type", "application/json")
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(request.toJSONString())
		.when()
			.patch("/users/5")
		.then()
			.statusCode(200)
			.log().all();
	}
	
	@Test
	public void test_put() {
		
		
		JSONObject request = new JSONObject();
		
		request.put("name", "Pim");
		request.put("lastname", "Pam");
		request.put("Project", 2);
		
		baseURI = "http://localhost:3000";
		
		given()
			.header("Content-Type", "application/json")
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(request.toJSONString())
		.when()
			.put("users/3")
		.then()
			.statusCode(200)
		.log().all();
	}
	
	@Test
	public void test_delete() {
		
		baseURI = "http://localhost:3000";

		when()
			.delete("users/4")
		.then()
			.statusCode(200)
		.log().all();
	}
	
}