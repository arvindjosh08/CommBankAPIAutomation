package apiDefinition;



import org.json.JSONObject;

import io.restassured.response.Response;
import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.util.EnvironmentVariables;

public class UpdateUserAPI {

	
	public Response response;
	private EnvironmentVariables environmentVariables;

	@Step("Calling UpdateUser API to update an existing user")
	public void updateUser() {

		JSONObject data = new JSONObject();
		data.put("username", "crypto");
		data.put("score", "600");

		String passtoken =  EnvironmentSpecificConfiguration.from(environmentVariables)
                .getProperty("access.token");
		String updateuser =  EnvironmentSpecificConfiguration.from(environmentVariables)
                .getProperty("user.endpoint");
		
		response = SerenityRest.given()
				.header("authorization",passtoken)
				.contentType("application/json")
				.body(data.toString())
				.put(updateuser);

	}

}
