package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

    private WebDriver webDriver;

    public HomePage(WebDriver webDriver) {

        this.webDriver = webDriver;
    }

    WebElement logoutButton = webDriver.findElement(By.xpath("//a[@href=\"logout.php?logout\"]"));
//    WebElement loginBar = webDriver.findElement(By.className("dropdown-toggle"));
    WebElement usersButton = webDriver.findElement(By.xpath("//*[text()=\"Users\"]"));

    public void logoutFromAccount() {

//        loginBar.click();
        logoutButton.click();

        }

        public void ClickUsersButton() {

        usersButton.click();
        }
    }
