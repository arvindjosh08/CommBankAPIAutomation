package apiDefinition;


import java.util.UUID;

import org.json.JSONObject;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.junit.Assert.assertThat;

import io.restassured.response.Response;

import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.util.EnvironmentVariables;

public class GetTokenAPI {

	
	public Response response;
	private EnvironmentVariables environmentVariables;
	
	@Step("Calling GetToken API to register an application")
	public void getToken() {

		UUID uuid = UUID.randomUUID();
		JSONObject data = new JSONObject();
		data.put("key", uuid);
		data.put("email", "abcd@gmail.com");

		String gettoken =  EnvironmentSpecificConfiguration.from(environmentVariables)
                .getProperty("get.token.endpoint");
		
		response = SerenityRest
				.given()
				.contentType("application/json")
				.body(data.toString())
				.post(gettoken);

	}

	@SuppressWarnings("deprecation")
	@Step("API response schema validation")
	public void validateSchema() {

		String responseBody = response.getBody().asString();
		assertThat(responseBody, matchesJsonSchemaInClasspath("GetTokenAPISchema.json"));

	}

}
