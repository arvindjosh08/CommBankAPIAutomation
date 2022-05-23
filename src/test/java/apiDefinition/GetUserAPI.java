package apiDefinition;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.junit.Assert.assertThat;


import io.restassured.response.Response;
import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.util.EnvironmentVariables;

public class GetUserAPI {

	private static String GET_USER_ENDPOINT = "https://supervillain.herokuapp.com/v1/user";
	public Response response;
	private EnvironmentVariables environmentVariables;

	@Step("Calling GetUser API to see all the registered users")
	public void GetUser() {
		
		String passtoken =  EnvironmentSpecificConfiguration.from(environmentVariables)
                .getProperty("access.token");

		try {
			response = SerenityRest.given()
					.header("authorization",passtoken)
					.contentType("application/json")
					.when()
					.get(GET_USER_ENDPOINT);
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
