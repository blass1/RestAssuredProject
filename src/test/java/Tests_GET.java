import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;


public class Tests_GET {
	
	@Test
	void test_statusCode() {
		
		String URL = "https://reqres.in/api/users?page=2";
		
		given()
			.get(URL)
				.then()
					.statusCode(200);
	}
	
	@Test
	void test_printResponse() {
		
		String URL = "https://reqres.in/api/users?page=2";
		
		given()
			.get(URL)
				.then()
					.statusCode(200)
						.log()
							.all();
	}
	
	@Test
	void test_responseEqual() {
		// Prueba donde verifico que sea status code 200 y el id en el index 2 (osea el 3ro) sea el id con key 9 y muestro todo
		String URL = "https://reqres.in/api/users?page=2";
		
		given()
			.get(URL)
				.then()
					.statusCode(200)
						.body("data.id[2]", equalTo(9))
							.log()
								.all();
	}
	
	@Test
	void test_respCodeIdFN() {
		// Verifico el cod 200, el id sea igual y aparte que el first_name de data tengan los values Michael y Lindsay
		String URL = "https://reqres.in/api/users?page=2";
		
		given()
			.get(URL)
				.then()
					.statusCode(200)
						.body("data.id[2]", equalTo(9))
							.body("data.first_name", hasItems("Michael", "Lindsay"));
	}
	
}