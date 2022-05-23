package apiDefinition;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.junit.Assert.assertThat;
import io.restassured.response.Response;
import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.util.EnvironmentVariables;

public class VerifyTokenAPI {

	
	public Response response;
	private EnvironmentVariables environmentVariables;
	
	@Step("Calling VerifyToken API to verify the validity of existing access token")
	public void verifyToken() {
		
		String verifytoken =  EnvironmentSpecificConfiguration.from(environmentVariables)
                .getProperty("verify.token.endpoint");
		String passtoken =  EnvironmentSpecificConfiguration.from(environmentVariables)
                .getProperty("access.token");
		
		response = SerenityRest.given()
				.header("authorization",passtoken)
				.contentType("application/json")
				.when()
				.get(verifytoken);

	}

	@SuppressWarnings("deprecation")
	@Step("API response schema validation")
	public void validateSchema() {

		String responseBody = response.getBody().asString();
		assertThat(responseBody, matchesJsonSchemaInClasspath("VerifyTokenAPISchema.json"));

	}

}
