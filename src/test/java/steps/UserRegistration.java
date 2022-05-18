package steps;

import POM.LoginPage;
import POM.RegisterPage;
import POM.User;
import com.github.javafaker.Faker;
import common.BaseClass;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.util.List;
import java.util.Map;


public class UserRegistration extends BaseClass {
    public UserRegistration() {
        loginPage = new LoginPage(webDriver);
        registerPage = new RegisterPage(webDriver);
        faker = new Faker();
    }

    private LoginPage loginPage;
    private RegisterPage registerPage;
    private String username;
    private Faker faker;

    @And("The register button is clicked")
    public void theRegisterButtonIsClicked() {

        loginPage.clickRegisterButton();
    }

    @When("The following details are filled in with")
    public void theFollowingDetailsAreFilledInWithTitleFirstNameSirNameEmailPasswordCountryCity(DataTable table) throws InterruptedException {
        List<Map<String, String>> data = table.asMaps(String.class, String.class);

            String email = faker.internet().emailAddress();


//        for (Map<String, String> columns : data) {
//
//            registerPage.addUser(new User(columns.get("title"), columns.get("firstName"), columns.get("sirName"), columns.get("email"), columns.get("password"), columns.get("country"), columns.get("city")));
//           String title = columns.get("title");
//            registerPage.clickRadioButton(title);
//
//         String firstName = columns.get("firstName");
//           registerPage.firstNameField().clear();
//            registerPage.firstNameField().sendKeys(firstName);
//            Thread.sleep(2000);
//
//            String sirName =
//        }

        String title = data.get(0).get("title");
        String firstName = data.get(0).get("firstName");
        String sirName = data.get(0).get("sirName");
//        String email = data.get(0).get("email");
        String password = data.get(0).get("password");
        String country = data.get(0).get("country");
        String city = data.get(0).get("city");

        this.username = email;
        registerPage.fillInRegistrationDetails(title, firstName, sirName, email, password, country, city);

    }

    @And("I agree with the terms of service is clicked")
    public void iAgreeWithTheTermsOfServiceIsClicked() {

        registerPage.termsCheckbox().click();
    }

    @And("The register button is clicked again")
    public void theRegisterButtonIsClickedAgain() {

        registerPage.registerButton().click();
    }

    @Then("The user is registered successfully")
    public void theUserIsRegisteredSuccessfully() {

        loginPage.assertionLogin(username);
    }

}
