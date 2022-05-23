package apiDefinition;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.junit.Assert.assertThat;



import org.json.JSONObject;

import io.restassured.response.Response;
import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.util.EnvironmentVariables;

public class UserLoginAPI {

	
	public Response response;
	private EnvironmentVariables environmentVariables;

	@Step("Calling UserLogin API to generate access token to login")
	public String userLogin() {

		JSONObject data = new JSONObject();
		data.put("username", "crypto");
		data.put("password", "crypto");

		String passtoken =  EnvironmentSpecificConfiguration.from(environmentVariables)
                .getProperty("access.token");
		String userlogin =  EnvironmentSpecificConfiguration.from(environmentVariables)
                .getProperty("user.login.endpoint");
		response = SerenityRest.given()
				.header("authorization",passtoken)
				.contentType("application/json")
				.body(data.toString())
				.post(userlogin);

		return response.getBody().jsonPath().getJsonObject("token");

	}

	@SuppressWarnings("deprecation")
	@Step("API response schema validation")
	public void validateSchema() {

		String responseBody = response.getBody().asString();
		assertThat(responseBody, matchesJsonSchemaInClasspath("UserLoginAPISchema.json"));

	}

}
