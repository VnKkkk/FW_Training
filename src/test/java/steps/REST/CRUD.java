package steps.REST;

import common.RestActions;
import dataProviders.ConfigReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

public class CRUD {

    private ConfigReader configReader;
    private RestActions restActions;
    private Response response;

    public CRUD() {
        configReader = new ConfigReader();
        restActions = new RestActions();

    }

    @When("I perform a {string} request to {string}")
    public void iPerformARequestTo(String resource, String path) {

//        if (resource.equalsIgnoreCase("GET")) {
//            restActions.getResource(path);
//        } else if (resource.equalsIgnoreCase("POST")) {
            restActions.postResource(path);
//        }
    }

    @Then("I should receive all users")
    public void iShouldReceiveAllUsers() {

        restActions.returnBody();
    }

    @And("Status code {string} with a message {string}")
    public void statusCodeWithAMessage(String statusCode, String statusMessage) {
        restActions.returnStatusCode(statusCode, statusMessage);
    }

    @Then("I should receive a user with the specific id")
    public void iShouldReceiveAUserWithTheSpecificId() {

        restActions.returnBody();
    }

    @And("I filled in the following username and password:{string}, {string}")
    public void iFilledInTheFollowingUsernameAndPassword(String username, String password) {

    }
}
