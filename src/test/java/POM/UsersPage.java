package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class UsersPage {

    private WebDriver webDriver;

    public UsersPage(WebDriver webDriver) {

        this.webDriver = webDriver;
    }

    List<WebElement> emailFields = webDriver.findElements(By.xpath("//tr/td[6]"));
    List<WebElement> deleteFields = webDriver.findElements(By.xpath("//tr/td[7]"));

    public void deleteUser(String userName) {

        for (int i = 0; i <= emailFields.size() - 1; i++) {
            if (emailFields.get(i).getText().contains(userName)) {
                deleteFields.get(i).click();
                break;
            }
        }
    }
}
