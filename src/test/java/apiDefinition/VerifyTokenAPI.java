package apiDefinition;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.junit.Assert.assertThat;

import java.util.UUID;

import org.json.JSONObject;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class VerifyTokenAPI {

	private static String VERIFY_TOKEN_ENDPOINT = "https://supervillain.herokuapp.com/auth/verifytoken";
	public Response response;

	@Step("Calling VerifyToken API to verify the validity of existing access token")
	public void verifyToken() {

		response = SerenityRest.given().header("authorization",
				"eyJhbGciOiJIUzUxMiIsInR5cCI6IkpXVCJ9.eyJrZXkiOiJyYW0iLCJlbWFpbCI6ImFydmluZGpvc2gwOEBnbWFpbC5jb20iLCJpYXQiOjE2NTMxNTI5NjQsImV4cCI6MTY1MzQxMjE2NH0.PMTwm-SUT_5OsI0cYhK6W9XS1t5Zc6frAvb_zKfQO-Kacnx-ry9uq6cRrKz-kwnrqyYginWPWSb-UH5bX8Sg6A")
				.contentType("application/json").when().get(VERIFY_TOKEN_ENDPOINT);

	}

	@SuppressWarnings("deprecation")
	@Step("API response schema validation")
	public void validateSchema() {

		String responseBody = response.getBody().asString();
		assertThat(responseBody, matchesJsonSchemaInClasspath("VerifyTokenAPISchema.json"));

	}

}
