package restAssuredtests;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Demo6_BasicValidations_XML {
	
	// 1. Verifying the single content in XML Response
	
	@Test(priority=1)
	public void testSingleContent() {
		given()
		
		.when()
			.get("http://thomas-bayer.com/sqlrest/CUSTOMER/15")
			
		.then()
			.body("CUSTOMER.ID", equalTo("15"))
			.log().all();
		
		
	}
	// 2. Verifying the multiple content in XML Response
	
		@Test(priority=2)
		public void testMultipleContent() {
			given()
			
			.when()
				.get("http://thomas-bayer.com/sqlrest/CUSTOMER/10")
				
			.then()
				.body("CUSTOMER.ID", equalTo("10"))
				.body("CUSTOMER.FIRSTNAME", equalTo("Sue"))
				.body("CUSTOMER.LASTNAME", equalTo("Fuller"))
				.body("CUSTOMER.STREET", equalTo("135 Upland Pl."))
				.body("CUSTOMER.CITY", equalTo("Dallas"));
				//.log().all();
					
		}
		// 3. Verifying all the content in XML Response in one go
		
			@Test(priority=3)
			public void testMultipleContentInOneGo() {
				given()
				
				.when()
					.get("http://thomas-bayer.com/sqlrest/CUSTOMER/10")
					
				.then()
					.body("CUSTOMER.text()", equalTo("10SueFuller135 Upland Pl.Dallas"));
					

			}
			
		//4. Find Values using XML Path in XML Response
			
			@Test(priority=3)
			public void testUsingXpath() {
				
given()
				
				.when()
					.get("http://thomas-bayer.com/sqlrest/CUSTOMER/10")
					// http://thomas-bayer.com/sqlrest/INVOICE/  Site for Testing XML Response
					
				.then()
					.body(hasXPath("/CUSTOMER/FIRSTNAME", containsString("Sue")))
					.body(hasXPath("/CUSTOMER/CITY[text()='Dallas']"))
					.log().all();
			}
}