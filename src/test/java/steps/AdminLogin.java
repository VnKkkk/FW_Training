package steps;

import common.BaseClass;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class AdminLogin extends BaseClass {
    public AdminLogin() {
    }

    @Given("The LogInPage is opened")
    public void theLogInPageIsOpened() {
        webDriver.get(loginUrl);
    }

    @When("The username {string} is filled in")
    public void theUsernameIsFilledIn(String username) {
//        WebElement usernameField = webDriver.findElement(By.id("username"));
//        usernameField.sendKeys(username);
    }

    @And("the password {string} is filled in")
    public void thePasswordIsFilledIn(String arg0) {
    }

    @Then("User is logged successfully")
    public void userIsLoggedSuccessfully() {
    }
}
