package stepDefinition;

import apiDefinition.AddUserAPI;
import apiDefinition.DeleteUserAPI;
import apiDefinition.GetTokenAPI;
import apiDefinition.GetUserAPI;
import apiDefinition.ManageUserAPI;
import apiDefinition.UpdateUserAPI;
import apiDefinition.UserLoginAPI;
import apiDefinition.UserRegistrationAPI;
import apiDefinition.VerifyTokenAPI;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

public class StepDefinitionFile {

	@Steps
	GetTokenAPI getTokenAPI;

	@Steps
	VerifyTokenAPI verifyTokenAPI;

	@Steps
	GetUserAPI getUserAPI;

	@Steps
	AddUserAPI addUserAPI;

	@Steps
	UpdateUserAPI updateUserAPI;

	@Steps
	UserRegistrationAPI userRegistrationAPI;

	@Steps
	UserLoginAPI userLoginAPI;

	@Steps
	DeleteUserAPI deleteUserAPI;

	@Steps
	ManageUserAPI manageUserAPI;

	// GetToken API

	@Given("I send a request to GetToken API endpoint")
	public void i_send_a_request_to_endpoint() {

		getTokenAPI.getToken();

	}

	@Then("GetToken API should return status {int}")
	public void the_api_should_return_status(Integer int1) {

		SerenityRest.restAssuredThat(response -> response.statusCode(int1));

	}

	@Then("Response schema should be as per swagger requirements of GetToken API")
	public void response_schema_should_be_as_per_swagger_requirements() {
		getTokenAPI.validateSchema();

	}

	// VerifyToken API

	@Given("I send a request to VerifyToken endpoint")
	public void i_send_a_request_to_verify_token_endpoint() {

		verifyTokenAPI.verifyToken();

	}

	@Then("VerifyToken API should return status {int}")
	public void verify_token_api_should_return_status(Integer int1) {
		SerenityRest.restAssuredThat(response -> response.statusCode(int1));

	}

	@Then("Response schema should be as per swagger requirements of VerifyToken API")
	public void response_schema_should_be_as_per_swagger_requirements_of_verify_token_api() {

		verifyTokenAPI.validateSchema();

	}

	// GetUser API
	@Given("I send a request to GetUser endpoint")
	public void i_send_a_request_to_get_user_endpoint() {

		getUserAPI.GetUser();

	}

	@Then("GetUser API should return status {int}")
	public void get_user_api_should_return_status(Integer int1) {

		SerenityRest.restAssuredThat(response -> response.statusCode(int1));

	}

	@Then("Response schema should be as per swagger requirements of GetUser API")
	public void response_schema_should_be_as_per_swagger_requirements_of_get_user_api() {

		getUserAPI.validateSchema();

	}

	// AddUser API
	@Given("I send a request to AddUser endpoint")
	public void i_send_a_request_to_add_user_endpoint() {
		addUserAPI.addUser();
	}

	@Then("AddUser API should return status {int}")
	public void add_user_api_should_return_status(Integer int1) {
		SerenityRest.restAssuredThat(response -> response.statusCode(int1));
	}

	@Then("Response schema should be as per swagger requirements of AddUser API")
	public void response_schema_should_be_as_per_swagger_requirements_of_add_user_api() {
		addUserAPI.validateSchema();
	}

	// UpdateUser API

	@Given("I send a request to UpdateUser endpoint")
	public void i_send_a_request_to_update_user_endpoint() {
		updateUserAPI.updateUser();
	}

	@Then("UpdateUser API should return status {int}")
	public void update_user_api_should_return_status(Integer int1) {
		SerenityRest.restAssuredThat(response -> response.statusCode(int1));
	}

	// UserRegistration API

	@Given("I send a request to UserRegistration endpoint")
	public void i_send_a_request_to_user_registration_endpoint() {
		userRegistrationAPI.registerUser();
	}

	@Then("UserRegistration API should return status {int}")
	public void user_registration_api_should_return_status(Integer int1) {
		SerenityRest.restAssuredThat(response -> response.statusCode(int1));
	}

	// UserLogin API

	@Given("I send a request to UserLogin endpoint")
	public void i_send_a_request_to_user_login_endpoint() {
		userLoginAPI.userLogin();
	}

	@Then("UserLogin API should return status {int}")
	public void user_login_api_should_return_status(Integer int1) {
		SerenityRest.restAssuredThat(response -> response.statusCode(int1));
	}

	@Then("Response schema should be as per swagger requirements of UserLogin API")
	public void response_schema_should_be_as_per_swagger_requirements_of_user_login_api() {
		userLoginAPI.validateSchema();
	}

	// DeleteUser API

	@Given("I send a request to DeleteUser endpoint")
	public void i_send_a_request_to_delete_user_endpoint() {
		deleteUserAPI.DeleteUser();
	}

	@Then("DeleteUser API should return status {int}")
	public void delete_user_api_should_return_status(Integer int1) {
		SerenityRest.restAssuredThat(response -> response.statusCode(int1));
	}

	// ManageUser API

	@Given("I send a request to ManageUser endpoint")
	public void i_send_a_request_to_manage_user_endpoint() {

		manageUserAPI.ManageUser(userLoginAPI.userLogin());

	}

	@Then("ManageUser API should return status {int}")
	public void manage_user_api_should_return_status(Integer int1) {
		SerenityRest.restAssuredThat(response -> response.statusCode(int1));
	}

	@Then("Response schema should be as per swagger requirements of ManageUser API")
	public void response_schema_should_be_as_per_swagger_requirements_of_manage_user_api() {
		manageUserAPI.validateSchema();
	}

}
