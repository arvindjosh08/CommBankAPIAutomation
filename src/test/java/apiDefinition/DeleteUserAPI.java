package apiDefinition;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.junit.Assert.assertThat;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class DeleteUserAPI {

	private static String DELETE_USER_ENDPOINT = "https://supervillain.herokuapp.com/v1/user";
	public Response response;

	@Step("Calling DeleteUser API to delete a user")
	public void DeleteUser() {
		
		

		response = SerenityRest.given()
				.header("authorization","eyJhbGciOiJIUzUxMiIsInR5cCI6IkpXVCJ9.eyJrZXkiOiJyYW0iLCJlbWFpbCI6ImFydmluZGpvc2gwOEBnbWFpbC5jb20iLCJpYXQiOjE2NTMxNTI5NjQsImV4cCI6MTY1MzQxMjE2NH0.PMTwm-SUT_5OsI0cYhK6W9XS1t5Zc6frAvb_zKfQO-Kacnx-ry9uq6cRrKz-kwnrqyYginWPWSb-UH5bX8Sg6A")
				.header("delete-key","delete-key")
				.contentType("application/json")
				.when()
				.delete(DELETE_USER_ENDPOINT);

	}

}
