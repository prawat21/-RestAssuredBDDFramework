package restAssuredtests;

import org.apache.commons.lang3.RandomStringUtils;

public class RestUtils {

	public static String getFirstName() {
		String generatedString = RandomStringUtils.randomAlphabetic(1);
		return ("Puneet" + generatedString);
	}

	public static String getLastName() {
		String generatedString = RandomStringUtils.randomAlphabetic(1);
		return ("Rawat" + generatedString);
	}
	
	public static String getUserName() {
		String generatedString = RandomStringUtils.randomAlphabetic(1);
		return ("Puneet" + generatedString);
	}
	
	public static String getPassword() {
		String generatedString = RandomStringUtils.randomAlphabetic(1);
		return ("Hello123" + generatedString);
	}
	
	public static String getEmail() {
		String generatedString = RandomStringUtils.randomAlphabetic(1);
		return (generatedString + "@gmail.com");
	}
	
	public static String getModelCode() {
		String generatedString = RandomStringUtils.randomAlphabetic(1);
		return (generatedString + "abc");
	}
	
	public static String getModelYear() {
		String generatedString = RandomStringUtils.randomAlphabetic(1);
		return (generatedString + "21");
	}
}
