package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class RegisterPage {
    private WebDriver webDriver;

    private List<User>users=new ArrayList<>();

    public void addUser(User user) {

        users.add(user);
    }

    public RegisterPage(WebDriver webDriver) {

        this.webDriver = webDriver;
    }

    public WebElement firstNameField() {

        return webDriver.findElement(By.xpath("//input[@name=\"first_name\"]"));
    }

    private WebElement titleMrRadioButton() {

        return webDriver.findElement(By.xpath("//input[@value=\"Mr.\"]"));
    }

    private WebElement titleMrsRadioButton() {

        return webDriver.findElement(By.xpath("//input[@value=\"Mrs.\"]"));
    }

    public WebElement sirNameField() {

        return webDriver.findElement(By.xpath("//input[@name=\"sir_name\"]"));
    }

    public WebElement emailField() {

        return webDriver.findElement(By.xpath("//input[@name=\"email\"]"));
    }

    public WebElement passwordField() {

        return webDriver.findElement(By.xpath("//input[@name=\"pass\"]"));
    }

    public WebElement countryField() {

        return webDriver.findElement(By.xpath("//input[@name=\"country\"]"));
    }

    public WebElement cityField() {

        return webDriver.findElement(By.xpath("//input[@name=\"city\"]"));
    }

    public WebElement termsCheckbox() {

        return webDriver.findElement(By.xpath("//input[@id=\"TOS\"]"));
    }

    public WebElement registerButton() {

        return webDriver.findElement(By.name("signup"));
    }

    public void clickRadioButton(String text) {

        if (text.equalsIgnoreCase("Mr.")) {

            titleMrRadioButton().click();
        } else titleMrsRadioButton().click();
    }

}
