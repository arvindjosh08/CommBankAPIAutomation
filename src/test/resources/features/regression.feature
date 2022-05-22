Feature: Regression testing of SuperHeroes and SuperVillain API's
  I want to use this template for my feature file

  #  GetToken API
  Scenario: Verify that user is able register his application using /auth/gentoken API
    Given I send a request to GetToken API endpoint
    Then GetToken API should return status 200
    And Response schema should be as per swagger requirements of GetToken API

  #  VerifyToken API
  Scenario: Verify that access token is valid using VerifyToken API
    Given I send a request to VerifyToken endpoint
    Then VerifyToken API should return status 200
    And Response schema should be as per swagger requirements of VerifyToken API

  #  GetUser API
  Scenario: Verify that GetUser API is returning all the users
    Given I send a request to GetUser endpoint
    Then GetUser API should return status 200
    And Response schema should be as per swagger requirements of GetUser API

  #  AddUser API
  Scenario: Verify that user is able to add a new user using AddUser API
    Given I send a request to AddUser endpoint
    Then AddUser API should return status 201
    And Response schema should be as per swagger requirements of AddUser API

  #  UserRegistration API
  Scenario: Verify that user is able to register in COVID application using UserRegistration API
    Given I send a request to UserRegistration endpoint
    Then UserRegistration API should return status 200

  #  UserLogin API
  Scenario: Verify that user is able to login using UserLogin API
    Given I send a request to UserLogin endpoint
    Then UserLogin API should return status 200
    And Response schema should be as per swagger requirements of UserLogin API

  #  DeleteUser API
  Scenario: Verify that user is able to delete user using DeleteUser API
    Given I send a request to DeleteUser endpoint
    Then DeleteUser API should return status 204

  #  ManageUser API
  Scenario: Verify user login authentication access token using ManageUser API
    Given I send a request to ManageUser endpoint
    Then ManageUser API should return status 200
    And Response schema should be as per swagger requirements of ManageUser API