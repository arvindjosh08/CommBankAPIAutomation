package apiDefinition;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.junit.Assert.assertThat;

import java.util.UUID;

import org.json.JSONObject;

import io.restassured.response.Response;
import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.util.EnvironmentVariables;

public class UserLoginAPI {

	private static String USER_LOGIN_ENDPOINT = "https://supervillain.herokuapp.com/auth/user/login";
	public Response response;
	private EnvironmentVariables environmentVariables;

	@Step("Calling UserLogin API to generate access token to login")
	public String userLogin() {

		JSONObject data = new JSONObject();
		data.put("username", "crypto");
		data.put("password", "crypto");

		String passtoken =  EnvironmentSpecificConfiguration.from(environmentVariables)
                .getProperty("access.token");
		response = SerenityRest.given()
				.header("authorization",passtoken)
				.contentType("application/json")
				.body(data.toString())
				.post(USER_LOGIN_ENDPOINT);

		return response.getBody().jsonPath().getJsonObject("token");

	}

	@SuppressWarnings("deprecation")
	@Step("API response schema validation")
	public void validateSchema() {

		String responseBody = response.getBody().asString();
		assertThat(responseBody, matchesJsonSchemaInClasspath("UserLoginAPISchema.json"));

	}

}
