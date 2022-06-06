package serializationDeserialization;

import java.util.HashMap;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class OffersNoSerialization {
	
	public HashMap<String, String> map = new HashMap();
	
	// POST Request
	@Test(priority = 1)
	public void validateOffersRequest() {
		map.put("ReplacementAmVehicleId","08d87547-009e-f080-4c16-7a000100002d");
		map.put("CurrentAmVehicleId", "08d67b3b-6496-8323-dc01-b60001000290");
		map.put("CustomerZipCode", "80127");
		map.put("LegacyDealerId", "AU0052");
		map.put("DealerZipCode", "07060");
		map.put("SupportedTerms", "[36]");
		map.put("EndOfTheLeaseInUTC", null);
		map.put("LeaseTerm", "1");
		map.put("ManualSelectedEligibleIncentives", "[]");
		map.put("ReplacementMsrp", null);
		map.put("IgnoreCache", "true");
		map.put("CustomerNumber", "134182");
		map.put("VIN", "WAUENAF45JA232478");
		
		given()
		.log().all()
		.contentType(ContentType.JSON)
		.body(map)
		
		.when()
			.log().all()
			.post("https://offers-private-apollo.nonprod.kube.network/offers")
			
		.then()
			.log().all()
			.statusCode(200)
			.assertThat()
			.body("cashBonus", equalTo("1250"));
					
	}

}
