import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;


public class Tests_DELETE {
	
	@Test
	public void test_delete() {
		
		
		String ENDPOINT = "https://reqres.in/api/users/2";
		
		when()
			.delete(ENDPOINT)
		.then()
			.statusCode(204)
		.log().all();
	}
}