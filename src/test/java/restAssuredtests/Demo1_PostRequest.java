package restAssuredtests;

import java.util.HashMap;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class Demo1_PostRequest {

	public static HashMap<String, String> map = new HashMap<>();

	@BeforeClass
	public void postData() {
		map.put("ReplacementAmVehicleId", "08d87546-f585-90d8-6b6e-fe000100011c");
		map.put("Vin", "WA1UFAFL4EA058776");
		map.put("ModelCode", RestUtils.getModelCode());
		map.put("ModelYear", RestUtils.getModelYear());

		RestAssured.baseURI = "https://offers-private-apollo.nonprod.kube.network";
		RestAssured.basePath = "/non-sticky-offer";

	}

	@Test
	public void testPost() {
		given()
		.contentType("text/html")
		.body(map)
		
		.when()
			.post()
			
		.then()
		
		.statusCode(200)
		.and()
		.body("cashValue", equalTo("1500"))
		.and()
		.body("isPrivateIncentive", equalTo("false"));

	}

}
