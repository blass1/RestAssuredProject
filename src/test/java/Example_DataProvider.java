
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.simple.JSONObject;


public class Example_DataProvider {
	
	
	@DataProvider(name = "DataForPost")
	public Object[][] dataForPost() {
		
		Object[][] data = new Object[2][4];
		
		data[0][0] = "Pepita";
		data[0][1] = "Pistolera";
		data[0][2] = " Admistrativo";
		data[0][3] = 3;
		
		data[1][0] = "Jona";
		data[1][1] = "Archer";
		data[1][2] = " Tecnico";
		data[1][3] = 3;
		
		return data;
	}
	
	
	@Test (dataProvider = "DataForPost")
	void test_post_DP(String name, String lastName, String rol, int project) {
		
		baseURI = "http://localhost:3000";
		
		JSONObject request = new JSONObject();
		
		request.put("name", name);
		request.put("lastname", lastName);
		request.put("rol", rol);
		request.put("Project", project);
		
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

	
	
	@DataProvider(name = "DataForPost2")
	public Object[][] dataForPost2() {
		
		return new Object[][] {
			{"Josesita", "Manuarte", "UI/UX", 66},
			{"Raul", "Gaspar", "UI/UX", 66}
		};
	}
	
	
	@Test (dataProvider = "DataForPost2")
	void test_post_DP2(String name, String lastName, String rol, int project) {
		
		baseURI = "http://localhost:3000";
		
		JSONObject request = new JSONObject();
		
		request.put("name", name);
		request.put("lastname", lastName);
		request.put("rol", rol);
		request.put("Project", project);
		
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
	
	
	@DataProvider(name = "DataForDelete")
	public Object[] dataForDelete() {
		
		return new Object[] {
			10,11
		};
	}
	
	@Test(dataProvider = "DataForDelete")
	public void test_delete_DP(int userId) {
		
		baseURI = "http://localhost:3000";
		
		when()
			.delete("/users/"+userId)
		.then()
			.statusCode(200)
		.log().all();
	}
}