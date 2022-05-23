package apiDefinition;



import io.restassured.response.Response;
import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.util.EnvironmentVariables;

public class DeleteUserAPI {

	
	public Response response;
	private EnvironmentVariables environmentVariables;
		
	@Step("Calling DeleteUser API to delete a user")
	public void DeleteUser() {
		
		
		String passtoken =  EnvironmentSpecificConfiguration.from(environmentVariables)
                .getProperty("access.token");
		String deleteuser =  EnvironmentSpecificConfiguration.from(environmentVariables)
                .getProperty("user.endpoint");

		response = SerenityRest.given()
				.header("authorization",passtoken)
				.header("delete-key","delete-key")
				.contentType("application/json")
				.when()
				.delete(deleteuser);

	}

}
