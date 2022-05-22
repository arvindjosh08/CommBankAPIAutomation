package apiDefinition;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.junit.Assert.assertThat;

import java.util.UUID;

import org.json.JSONObject;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class UpdateUserAPI {

	private static String UPDATE_USER_ENDPOINT = "https://supervillain.herokuapp.com/v1/user";
	public Response response;

	@Step("Calling UpdateUser API to update an existing user")
	public void updateUser() {

		JSONObject data = new JSONObject();
		data.put("username", "crypto");
		data.put("score", "600");

		response = SerenityRest.given()
				.header("authorization","eyJhbGciOiJIUzUxMiIsInR5cCI6IkpXVCJ9.eyJrZXkiOiJyYW0iLCJlbWFpbCI6ImFydmluZGpvc2gwOEBnbWFpbC5jb20iLCJpYXQiOjE2NTMxNTI5NjQsImV4cCI6MTY1MzQxMjE2NH0.PMTwm-SUT_5OsI0cYhK6W9XS1t5Zc6frAvb_zKfQO-Kacnx-ry9uq6cRrKz-kwnrqyYginWPWSb-UH5bX8Sg6A")
				.contentType("application/json")
				.body(data.toString())
				.put(UPDATE_USER_ENDPOINT);

	}

}
