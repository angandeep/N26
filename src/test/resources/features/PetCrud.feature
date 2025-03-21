Feature: CRUD Operations on Pet Endpoint in Swagger Petstore

  Scenario: Create a new pet
    Given the Petstore API is available
    When the user creates a pet with ID "1001" and name "Fluffy"
    Then the pet is created successfully with status code 200

  Scenario: Read an existing pet
    Given the Petstore API is available
    When the user retrieves the pet with ID "1001"
    Then the pet details show name "Fluffy" with status code 200

  Scenario: Update an existing pet
    Given the Petstore API is available
    When the user updates the pet with ID "1001" to name "FluffyUpdated"
    Then the pet is updated successfully with status code 200

  Scenario: Delete an existing pet
    Given the Petstore API is available
    When the user deletes the pet with ID "1001"
    Then the pet is deleted successfully with status code 200