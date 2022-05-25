package POM;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePage {

    public HomePage() {
    }

    @FindBy(xpath = "//a[@href=\"logout.php?logout\"]")
    WebElement logoutButton;

    @FindBy(how = How.XPATH, using = "//a[@data-toggle=\"dropdown\"]")
    WebElement loginBar;

    @FindBy(xpath = "//*[text()=\"Users\"]")
    WebElement usersButton;

    public void logoutFromAccount() {

        loginBar.click();
        logoutButton.click();

    }

    public void ClickUsersButton() {

        usersButton.click();
    }

    public void assertionLogin(String text) {

     Assert.assertTrue(loginBar.getText().toLowerCase().contains(text));
    }
}
