package restAssuredtests;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Demo_GetRequest {

	
	@Test
public void getCircuitDetails() {
	
		given().
		when().
		get("http://ergast.com/api/f1/2008/circuits.json")
		.then()
		.statusCode(200).and()
		.statusLine("HTTP/1.1 200 OK").and()
		.assertThat().body("MRData.CircuitTable.Circuits.circuitId", hasSize(18)).and()
		.assertThat().body("MRData.CircuitTable.Circuits[2].circuitId", equalTo("catalunya")).and()
		.header("Content-Type", "application/json; charset=utf-8");
}
	
}
