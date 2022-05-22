package apiDefinition;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.junit.Assert.assertThat;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class GetUserAPI {

	private static String GET_USER_ENDPOINT = "https://supervillain.herokuapp.com/v1/user";
	public Response response;

	@Step("Calling GetUser API to see all the registered users")
	public void GetUser() {

		response = SerenityRest.given().header("authorization",
				"eyJhbGciOiJIUzUxMiIsInR5cCI6IkpXVCJ9.eyJrZXkiOiJyYW0iLCJlbWFpbCI6ImFydmluZGpvc2gwOEBnbWFpbC5jb20iLCJpYXQiOjE2NTMxNTI5NjQsImV4cCI6MTY1MzQxMjE2NH0.PMTwm-SUT_5OsI0cYhK6W9XS1t5Zc6frAvb_zKfQO-Kacnx-ry9uq6cRrKz-kwnrqyYginWPWSb-UH5bX8Sg6A")
				.contentType("application/json").when().get(GET_USER_ENDPOINT);

	}

	@SuppressWarnings("deprecation")
	@Step("API response schema validation")
	public void validateSchema() {

		String responseBody = response.getBody().asString();
		assertThat(responseBody, matchesJsonSchemaInClasspath("GetUserAPISchema.json"));

	}

}
