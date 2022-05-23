package apiDefinition;

import java.util.UUID;

import org.json.JSONObject;

import io.restassured.response.Response;
import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.util.EnvironmentVariables;

public class UserRegistrationAPI {

	
	public Response response;
	private EnvironmentVariables environmentVariables;

	@Step("Calling UserRegistration API to register a user")
	public void registerUser() {

		UUID uuid = UUID.randomUUID();
		JSONObject data = new JSONObject();
		data.put("username", uuid);
		data.put("password", uuid);
		
		String passtoken =  EnvironmentSpecificConfiguration.from(environmentVariables)
                .getProperty("access.token");
		String userregistration =  EnvironmentSpecificConfiguration.from(environmentVariables)
                .getProperty("user.registration.endpoint");
		response = SerenityRest.given()
				.header("authorization",passtoken)
				.contentType("application/json")
				.body(data.toString())
				.post(userregistration);

	}

}
