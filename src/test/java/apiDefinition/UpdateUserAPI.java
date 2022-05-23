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

public class UpdateUserAPI {

	private static String UPDATE_USER_ENDPOINT = "https://supervillain.herokuapp.com/v1/user";
	public Response response;
	private EnvironmentVariables environmentVariables;

	@Step("Calling UpdateUser API to update an existing user")
	public void updateUser() {

		JSONObject data = new JSONObject();
		data.put("username", "crypto");
		data.put("score", "600");

		String passtoken =  EnvironmentSpecificConfiguration.from(environmentVariables)
                .getProperty("access.token");
		response = SerenityRest.given()
				.header("authorization",passtoken)
				.contentType("application/json")
				.body(data.toString())
				.put(UPDATE_USER_ENDPOINT);

	}

}
