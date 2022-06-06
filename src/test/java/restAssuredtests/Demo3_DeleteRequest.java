package restAssuredtests;

import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
//import static org.hamcrest.Matchers.*;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Demo3_DeleteRequest {
	
	@Test
	public void deleteEmployeeRecord() {
		
		RestAssured.baseURI = "https://offers-private-apollo.nonprod.kube.network";
		RestAssured.basePath = "delete/non-sticky-offer"; // Dummy Request
		
		Response reponse =
		given()
		
		.when()
			.delete()
		.then()
			.statusCode(200)
			.statusLine("HTTP/1.1 200 OK")
			.log().all()
			.extract().response();
		
		String jsonAsString = reponse.asString();
		Assert.assertEquals(jsonAsString.contains("Successfully! deleted Records"), true);
		
		
	}

}
