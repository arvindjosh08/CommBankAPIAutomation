package apiDefinition;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.junit.Assert.assertThat;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import io.restassured.response.Response;
import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.util.EnvironmentVariables;

public class DeleteUserAPI {

	private static String DELETE_USER_ENDPOINT = "https://supervillain.herokuapp.com/v1/user";
	public Response response;
	private EnvironmentVariables environmentVariables;
		
	@Step("Calling DeleteUser API to delete a user")
	public void DeleteUser() {
		
		
		String passtoken =  EnvironmentSpecificConfiguration.from(environmentVariables)
                .getProperty("access.token");

		response = SerenityRest.given()
				.header("authorization",passtoken)
				.header("delete-key","delete-key")
				.contentType("application/json")
				.when()
				.delete(DELETE_USER_ENDPOINT);

	}

}
