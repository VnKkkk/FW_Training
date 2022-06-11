package steps.dataBase;

import common.DBActions;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.sql.SQLException;

public class DataBaseSteps {

    private DBActions dbActions;

    public DataBaseSteps(){
        dbActions = new DBActions();
    }


    @When("I get all existing Users information")
    public void iGetAllExistingUsersInformation() throws SQLException{
        dbActions.getAllUsers();

    }

    @When("I create a new user with the following information:")
    public void iCreateANewUserWithTheFollowingInformation(DataTable table) throws SQLException {
            dbActions.creatingNewUser(table);
    }

    @Then("I can select the user using his email address")
    public void iCanSelectTheUserUsingHisEmailAddress() throws SQLException {
        dbActions.assertingUserIsCreated();
    }

    @Given("A user is registered through the DataBase")
    public void aUserIsRegisteredThroughTheDataBase() throws SQLException {

        dbActions.creatingNewDefaultUser();
    }

    @When("I update the user's first and last name with: {string}, {string}")
    public void iUpdateTheUserSFirstAndLastNameWith(String firstName, String lastName) throws SQLException {
        dbActions.updateUserDetails(firstName, lastName);
    }

    @Then("all the users are displayed")
    public void allTheUsersAreDisplayed() {
        dbActions.assertAllUsersAreDisplayed();
    }

    @Then("I should receive the user's updated information")
    public void iShouldReceiveTheUserSUpdatedInformation() throws SQLException {
        dbActions.assertingUserNameAndSirNameAreUpdated();
    }

    @When("I Delete the user")
    public void iDeleteTheUser() throws SQLException {
        dbActions.deleteUser();
    }

    @Then("I should not be able to select the user")
    public void iShouldNotBeAbleToSelectTheUser() throws SQLException {
        dbActions.asserUserIsDeleted();
    }
}
