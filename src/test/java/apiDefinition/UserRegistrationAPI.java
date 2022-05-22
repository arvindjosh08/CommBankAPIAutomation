package apiDefinition;

import java.util.UUID;

import org.json.JSONObject;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class UserRegistrationAPI {

	private static String USER_REGISTRATION_ENDPOINT = "https://supervillain.herokuapp.com/auth/user/register";
	public Response response;

	@Step("Calling UserRegistration API to register a user")
	public void registerUser() {

		UUID uuid = UUID.randomUUID();
		JSONObject data = new JSONObject();
		data.put("username", uuid);
		data.put("password", uuid);

		response = SerenityRest.given().header("authorization",
				"eyJhbGciOiJIUzUxMiIsInR5cCI6IkpXVCJ9.eyJrZXkiOiJyYW0iLCJlbWFpbCI6ImFydmluZGpvc2gwOEBnbWFpbC5jb20iLCJpYXQiOjE2NTMxNTI5NjQsImV4cCI6MTY1MzQxMjE2NH0.PMTwm-SUT_5OsI0cYhK6W9XS1t5Zc6frAvb_zKfQO-Kacnx-ry9uq6cRrKz-kwnrqyYginWPWSb-UH5bX8Sg6A")
				.contentType("application/json").body(data.toString()).post(USER_REGISTRATION_ENDPOINT);

	}

}
