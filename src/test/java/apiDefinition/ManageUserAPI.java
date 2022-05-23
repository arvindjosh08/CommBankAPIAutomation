package apiDefinition;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.junit.Assert.assertThat;

import io.restassured.response.Response;
import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.util.EnvironmentVariables;

public class ManageUserAPI {

	
	public Response response;
	private EnvironmentVariables environmentVariables;
	
	@Step("Calling ManageUser API to verify the user login authentication token ")
	public void ManageUser(String token) {

		String manageuser =  EnvironmentSpecificConfiguration.from(environmentVariables)
                .getProperty("manage.user.endpoint");
		response = SerenityRest
				.given()
				.header("authorization", token)
				.contentType("application/json")
				.when()
				.get(manageuser);

	}

	@SuppressWarnings("deprecation")
	@Step("API response schema validation")
	public void validateSchema() {

		String responseBody = response.getBody().asString();
		assertThat(responseBody, matchesJsonSchemaInClasspath("GetUserAPISchema.json"));

	}

}
