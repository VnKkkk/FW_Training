package actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class LoginPageActions {
    public LoginPageActions(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }
}
