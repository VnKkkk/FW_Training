package stepdefs;

import hooks.UIHooks;
import io.cucumber.java.en.Given;

public class LogInStepdefs {

    private final UIHooks uiHooks = new UIHooks(null);

    @Given("The LogInPage is opened")
    public void theLogInPageIsOpened() {
        uiHooks.setUp();
    }

//    @When("The username {string} is filled in")
//    public void theUsernameIsFilledIn(String arg0) {
//    }
//
//    @And("the password {string} is filled in")
//    public void thePasswordIsFilledIn(String arg0) {
//    }
//
//    @Then("User is logged successfully")
//    public void userIsLoggedSuccessfully() {
//    }
}
