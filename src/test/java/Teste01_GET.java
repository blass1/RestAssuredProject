import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;


public class Teste01_GET {
	
	@Test
	void test_01() {
		
		String URL = "https://reqres.in/api/users?page=2";
		
		Response response = get(URL);
		
		System.out.println(response.asString());
		System.out.println(response.getBody());
		System.out.println(response.getStatusCode());
		System.out.println(response.getStatusLine());
		System.out.println(response.getHeader("content-type"));
		System.out.println(response.getTime());
		
		int statusCode = response.getStatusCode();
		
		Assert.assertEquals(statusCode, 200);
		
	}
	
	@Test
	void test_02() {
		
		String URL = "https://reqres.in/api/users?page=2";
		// Si el status code es 200 pasa la prueba
		given().get(URL).then().statusCode(200);
		
		// En esta prueba encadenamos y comprobamos que el status code sea 200 y
		// la key "data" (que es una lista de objetos), sea 8 el id de la posicion 1
		given()
			.get(URL)
				.then()
					.statusCode(200)
						.body("data.id[1]", equalTo(8));
		
	}

}
