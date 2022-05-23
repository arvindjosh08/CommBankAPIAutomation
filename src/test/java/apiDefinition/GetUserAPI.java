package apiDefinition;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.junit.Assert.assertThat;


import io.restassured.response.Response;
import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.util.EnvironmentVariables;

public class GetUserAPI {

	public Response response;
	private EnvironmentVariables environmentVariables;

	@Step("Calling GetUser API to see all the registered users")
	public void GetUser() {
		
		String passtoken =  EnvironmentSpecificConfiguration.from(environmentVariables)
                .getProperty("access.token");
		String getuser =  EnvironmentSpecificConfiguration.from(environmentVariables)
                .getProperty("user.endpoint");

		try {
			response = SerenityRest.given()
					.header("authorization",passtoken)
					.contentType("application/json")
					.when()
					.get(getuser);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@SuppressWarnings("deprecation")
	@Step("API response schema validation")
	public void validateSchema() {

		String responseBody = response.getBody().asString();
		assertThat(responseBody, matchesJsonSchemaInClasspath("GetUserAPISchema.json"));

	}

}
