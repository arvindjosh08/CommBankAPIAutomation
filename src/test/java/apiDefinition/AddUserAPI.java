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

public class AddUserAPI {

	private static String ADD_USER_ENDPOINT = "https://supervillain.herokuapp.com/v1/user";
	public Response response;
	private EnvironmentVariables environmentVariables;

	
	@Step("Calling AddUser API to add a new user")
	public void addUser() {

		UUID uuid = UUID.randomUUID();
		JSONObject data = new JSONObject();
		data.put("username", uuid);
		data.put("score", "600");
		
		String passtoken =  EnvironmentSpecificConfiguration.from(environmentVariables)
                .getProperty("access.token");

		response = SerenityRest.given()
				.header("authorization",passtoken)
				.contentType("application/json")
				.body(data.toString())
				.post(ADD_USER_ENDPOINT);

	}

	@SuppressWarnings("deprecation")
	@Step("API response schema validation")
	public void validateSchema() {

		String responseBody = response.getBody().asString();
		assertThat(responseBody, matchesJsonSchemaInClasspath("AddUserAPISchema.json"));

	}

}
