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


public class Tests_PUT_PATCH {
	// Utilizamos el post para crear recursos en un servidor
	
	@Test
	public void test_3_put() {
		
		
		JSONObject request = new JSONObject();
		
		request.put("name", "Blas");
		request.put("job", "Dev");
		
		
		//System.out.println(request);
		//System.out.println(request.toJSONString());
		
		String ENDPOINT = "https://reqres.in/api/users/2";
		
		// Apunto al endpoint PUT y le envio la request e imprimo el log
		// con PATCH es exactamente igual salvo que tengo que utilizar .patch(ENDPOINT)
		given()
			.header("Content-Type", "application/json")
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(request.toJSONString())
		.when()
			.put(ENDPOINT)
		.then()
			.statusCode(200)
		.log().all();
	}
}