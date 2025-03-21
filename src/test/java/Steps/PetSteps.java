package Steps;

import io.restassured.RestAssured;
import org.PetApiClient;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import org.testng.Assert;

public class PetSteps {
    private PetApiClient petApiClient;
    private Response response;

    @Given("the Petstore API is available")
    public void setupApi() {
        petApiClient = new PetApiClient();
        // Simple health check (optional)
        Response health = RestAssured.get("https://petstore3.swagger.io/api/v3/pet/0");
        Assert.assertTrue(health.statusCode() == 200 || health.statusCode() == 404, "API not available");
    }

    @When("the user creates a pet with ID {string} and name {string}")
    public void createPet(String petId, String name) {
        response = petApiClient.createPet(petId, name);
    }

    @When("the user retrieves the pet with ID {string}")
    public void getPet(String petId) {
        response = petApiClient.getPet(petId);
    }

    @When("the user updates the pet with ID {string} to name {string}")
    public void updatePet(String petId, String name) {
        response = petApiClient.updatePet(petId, name);
    }

    @When("the user deletes the pet with ID {string}")
    public void deletePet(String petId) {
        response = petApiClient.deletePet(petId);
    }

    @Then("the pet is created successfully with status code {int}")
    public void verifyCreate(int statusCode) {
        Assert.assertEquals(response.statusCode(), statusCode);
    }

    @Then("the pet details show name {string} with status code {int}")
    public void verifyGet(String expectedName, int statusCode) {
        Assert.assertEquals(response.statusCode(), statusCode);
        String actualName = response.jsonPath().getString("name");
        Assert.assertEquals(actualName, expectedName);
    }

    @Then("the pet is updated successfully with status code {int}")
    public void verifyUpdate(int statusCode) {
        Assert.assertEquals(response.statusCode(), statusCode);
    }

    @Then("the pet is deleted successfully with status code {int}")
    public void verifyDelete(int statusCode) {
        Assert.assertEquals(response.statusCode(), statusCode);
    }
}