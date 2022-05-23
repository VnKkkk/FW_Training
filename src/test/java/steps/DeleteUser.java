package steps;

import POM.HomePage;
import POM.LoginPage;
import POM.RegisterPage;
import POM.UsersPage;
import common.BaseClass;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DeleteUser extends BaseClass {

    RegisterPage registerPage;
    HomePage homePage;
    LoginPage loginPage;
    UsersPage usersPage;

    String userName;

    public DeleteUser() {

        this.registerPage = new RegisterPage(webDriver);
        this.homePage = new HomePage(webDriver);
        this.loginPage = new LoginPage(webDriver);
        this.usersPage = new UsersPage(webDriver);
    }

    @And("A user is registered with the following details")
    public void aUserIsRegisteredWithTheFollowingDetails(String title, String firstName, String sirName, String email, String password, String country, String city) {

        this.userName = email;

        registerPage.fillInRegistrationDetails(title, firstName, sirName, email, password, country, city);
        registerPage.termsCheckbox().click();
        registerPage.registerButton().click();
    }

    @And("I logout from the the account")
    public void iLogoutFromTheTheAccount() {

        homePage.logoutFromAccount();
    }

    @When("I login with the following admin details: {string} and {string}")
    public void iLoginWithTheFollowingAdminDetailsAnd(String userName, String password) {

        loginPage.fillInUsername(userName);
        loginPage.filInPassword(password);
        loginPage.clickLoginButton();
    }

    @And("I click on the Users on the admin page")
    public void iClickOnTheUsersOnTheAdminPage() {

        homePage.ClickUsersButton();
    }

    @And("I click on the delete button next to the user")
    public void iClickOnTheDeleteButtonNextToTheUser() {

        usersPage.deleteUser(userName);
    }

    @Then("The user should be deleted")
    public void theUserShouldBeDeleted() {
    }
}
