package restAssuredtests;

import java.util.HashMap;
import static io.restassured.RestAssured.*;
//import static org.hamcrest.Matchers.*;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class Demo2_PutRequest {

	public static HashMap<String, String> map = new HashMap<String, String>();

	String empName = RestUtils.getUserName();
	String modelCode = RestUtils.getModelCode();
	String modelYear = RestUtils.getModelYear();

	@BeforeClass
	public void putData() {

		map.put("ReplacementAmVehicleId", "08d87546-f585-90d8-6b6e-fe000100011c");
		map.put("Vin", "WA1UFAFL4EA058776");
		map.put("ModelCode", RestUtils.getModelCode());
		map.put("ModelYear", RestUtils.getModelYear());

		RestAssured.baseURI = "https://offers-private-apollo.nonprod.kube.network";
		RestAssured.basePath = "update/non-sticky-offer"; // Dummy Request

	}
	@Test
	public void testPut() {
			
			given()
				.contentType("application/json")
				.body(map)
			.when()
				.put()
			.then()
				.statusCode(200)
				.log().all();
				
		}
}
