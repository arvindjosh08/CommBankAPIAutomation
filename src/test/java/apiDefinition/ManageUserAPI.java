package apiDefinition;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.junit.Assert.assertThat;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class ManageUserAPI {

	private static String MANAGE_USER_ENDPOINT = "https://supervillain.herokuapp.com/v1/user/crypto";
	public Response response;

	@Step("Calling ManageUser API to verify the user login authentication token ")
	public void ManageUser(String token) {

		response = SerenityRest.given().header("authorization", token).contentType("application/json").when()
				.get(MANAGE_USER_ENDPOINT);

	}

	@SuppressWarnings("deprecation")
	@Step("API response schema validation")
	public void validateSchema() {

		String responseBody = response.getBody().asString();
		assertThat(responseBody, matchesJsonSchemaInClasspath("GetUserAPISchema.json"));

	}

}
