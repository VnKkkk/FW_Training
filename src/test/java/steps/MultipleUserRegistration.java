package steps;

import POM.LoginPage;
import POM.RegisterPage;
import common.BaseClass;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MultipleUserRegistration extends BaseClass {

    RegisterPage registerPage;
    LoginPage loginPage;

    public MultipleUserRegistration() {

        this.registerPage = new RegisterPage(webDriver);
        this.loginPage = new LoginPage(webDriver);
    }

    String email;

    @When("The following details are filled in with: {string}, {string}, {string}, {string}, {string}, {string}, {string}")
    public void theFollowingDetailsAreFilledInWithTitleFirstNameSirNameEmailPasswordCountryCity(String title, String firstName, String sirName, String email, String password, String country, String city) {

        this.email = email;
        registerPage.fillInRegistrationDetails(title, firstName, sirName, email, password, country, city);
    }


    @Then("The user is registered successfully.")
    public void theUserIsRegisteredSuccessfully() {

        loginPage.assertionLogin(email);
    }
}
