package POM;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.Locale;

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

        return webDriver.findElement(By.xpath("//a[@class=\"dropdown-toggle\"]"));
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
}
