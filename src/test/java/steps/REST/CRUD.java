package steps.REST;

import com.github.javafaker.Faker;
import common.RestActions;
import dataProviders.ConfigReader;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.json.simple.JSONObject;

public class CRUD {


    private RestActions restActions;
    private Faker faker;
    private JSONObject requestParams;

    public CRUD() {
        restActions = new RestActions();
        requestParams = new JSONObject();
        faker = new Faker();
    }

    @When("I perform a {string} request to {string}")
    public void iPerformARequestTo(String resource, String path) {




        if (resource.equalsIgnoreCase("GET")) {
            restActions.getResource(path);
        }
        else if (resource.equalsIgnoreCase("POST")) {
            restActions.postResourceWithJson(path, requestParams);
        }
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

    @And("I use the following details:")
    public void iUseTheFollowingDetails(DataTable table) {

            this.requestParams = restActions.fillInRegistrationDetails(table);


    }
}
