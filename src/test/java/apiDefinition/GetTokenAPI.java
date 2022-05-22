package apiDefinition;

import java.io.File;
import java.util.UUID;

import org.json.JSONObject;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.junit.Assert.assertThat;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class GetTokenAPI {

	private static String GET_TOKEN_ENDPOINT = "https://supervillain.herokuapp.com/auth/gentoken";
	public Response response;

	@Step("Calling GetToken API to register an application")
	public void getToken() {

		UUID uuid = UUID.randomUUID();
		JSONObject data = new JSONObject();
		data.put("key", uuid);
		data.put("email", "abcd@gmail.com");

		response = SerenityRest.given().contentType("application/json").body(data.toString()).post(GET_TOKEN_ENDPOINT);

	}

	@SuppressWarnings("deprecation")
	@Step("API response schema validation")
	public void validateSchema() {

		String responseBody = response.getBody().asString();
		assertThat(responseBody, matchesJsonSchemaInClasspath("GetTokenAPISchema.json"));

	}

}
