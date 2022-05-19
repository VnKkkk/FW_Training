package POM;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.NoSuchElementException;

public class LoginPage {
    private WebDriver webDriver;

    public LoginPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public WebElement userNameField() {

        return webDriver.findElement(By.xpath("//input[@name=\"email\"]"));
    }

    public WebElement passwordField() {

        return webDriver.findElement(By.xpath("//input[@name=\"pass\"]"));
    }

    public WebElement logInButton() {

        return webDriver.findElement(By.xpath("//button[@name=\"btn-login\"]"));
    }

    public WebElement loginBar() {

        return webDriver.findElement(By.className("dropdown-toggle"));
    }

    public WebElement registerButton() {

        return webDriver.findElement(By.xpath("//a[@href=\"register.php\"]"));
    }
    public void fillInUsername(String username) {

        userNameField().clear();
        userNameField().sendKeys(username);
    }

    public void filInPassword(String password) {

        passwordField().clear();
        passwordField().sendKeys(password);
    }

    public void retryClick(WebElement element) {

        int maxTries = 10;
        for (int i = 0; i <= maxTries; i++) {
            try {
                element.click();
                break;
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (i == maxTries) {
                    throw ex;
                }
            }
        }
    }

    public void clickLoginButton() {

        retryClick(logInButton());
    }

    public void assertionLogin(String text) {

        Assert.assertTrue(loginBar().getText().toLowerCase().contains(text));
    }

    public void clickRegisterButton() {

        retryClick(registerButton());
    }

    public boolean waitUntilElementNotDisplayed(final WebElement webElement) {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(5));
        ExpectedCondition elementIsDisplayed = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver arg0) {
                try {
                    webElement.isDisplayed();
                    return false;
                }
                catch (NoSuchElementException e ) {
                    return true;
                }
                catch (StaleElementReferenceException f) {
                    return true;
                }
            }
        };
        wait.until(elementIsDisplayed);
        return false;
    }

    public void assertNotPreset(){
        Assert.assertFalse(waitUntilElementNotDisplayed(loginBar()));
    }
}
