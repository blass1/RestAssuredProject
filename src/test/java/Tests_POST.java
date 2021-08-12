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


public class Tests_POST {
	// Utilizamos el post para crear recursos en un servidor
	
	@Test
	public void test_1_post() {
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		// Aca creamos el objeto map de java que es parecido a los objetos
		// {name=Blas, job=Dev}
		map.put("name", "Blas");
		map.put("job", "Dev");
		
		System.out.println(map);
		
		// Para convertirlo usamos el paquete  de maven JSON.simple, tambien se puede utilizar Gson, Jackson, JSON
		// {"name":"Blas","job":"Dev"}
		JSONObject request = new JSONObject(map);
		
		System.out.println(request);
		System.out.println(request.toJSONString());
	}
	
	@Test
	public void test_2_post_JSONObject() {
		
	
		JSONObject request = new JSONObject();
		
		// De la misma manera que ponemos un put en el map de java podemos hacer con el JSONObject
		request.put("name", "Blas");
		request.put("job", "Dev");
		
		
		System.out.println(request);
		System.out.println(request.toJSONString());
		
		String ENDPOINT = "https://reqres.in/api/users";
		
		given()
			.body(request.toJSONString())
				.when()
					.post(ENDPOINT)
						.then()
							.statusCode(201);
	}
	
	@Test
	public void test_3_post_Header() {
		
		
		JSONObject request = new JSONObject();
		
		request.put("name", "Blas");
		request.put("job", "Dev");
		
		
		System.out.println(request);
		System.out.println(request.toJSONString());
		
		String ENDPOINT = "https://reqres.in/api/users";
		
		given()
			.header("Content-Type", "application/json")
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
						.body(request.toJSONString())
							.when()
								.post(ENDPOINT)
									.then()
										.statusCode(201);
	}
}
