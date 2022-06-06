package restAssuredtests;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
//import static org.hamcrest.Matchers.*;

public class Demo5_BasicValidations_Json {
	//1. Test Status Code
	
	@Test(priority=1)
	public void testStatusCode() {
		given()
		
		.when()
		
			.get("http://jsonplaceholder.typicode.com/posts/5")
		.then()
			.statusCode(200);
			//.log().all(); //log response
		
	}
	
	//2. Log Response
	
	@Test(priority=2)
	public void testLogging() {
		given()
		
		.when()
			.get("http://jsonplaceholder.typicode.com/posts/5")
			
		.then()
			.statusCode(200)
			.log().all();
	}
	
	//3. Verifying Single content in response body
	@Test(priority=1)
	public void testSingleContent() {
		given()
		
		.when()
		
			.get("http://ergast.com/api/f1/2008/circuits.json")
		.then()
			.statusCode(200);
			//.body(.MRData.CircuitTable.Circuits[1].circuitName, equalTo("Albert Park Grand Prix Circuit"))
}
	
	//4. Verifying Multiple content in response body
		@Test(priority=3)
		public void testMultipleContent() {
			given()
			
			.when()
			
				.get("http://ergast.com/api/f1/2008/circuits.json")
			.then()
				.statusCode(200);
				//.body(.MRData.CircuitTable.Circuits[1].circuitName, hasItems("Albert Park Grand Prix Circuit", "Bahrain International Circuit"))
	}
		
		//5. Setting parameters and headers
		@Test(priority=1)
		public void testParamsHeader() {
			given()
				.param("Keys", "Values")
				.header("MyHeader", "Indian")
			
			.when()
			
				.get("http://ergast.com/api/f1/2008/circuits.json")
			.then()
				.statusCode(200)
				.log().all();
				
		}
}
