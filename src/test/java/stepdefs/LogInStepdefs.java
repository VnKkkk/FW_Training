package stepdefs;

import common.BaseClass;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LogInStepdefs extends BaseClass {

    private BaseClass baseClass;

    public LogInStepdefs(BaseClass baseClass) {
        this.baseClass = baseClass;
    }

    public LogInStepdefs() {
    }

    @Given("The LogInPage is opened")
    public void theLogInPageIsOpened() {

        baseClass.webDriver.get(baseClass.Url);

    }

    @When("The username {string} is filled in")
    public void theUsernameIsFilledIn(String arg0) {
    }

    @And("the password {string} is filled in")
    public void thePasswordIsFilledIn(String arg0) {
    }

    @Then("User is logged successfully")
    public void userIsLoggedSuccessfully() {
    }
}
