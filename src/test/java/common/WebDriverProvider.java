package common;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverProvider {

    public static WebDriver webDriver;

    public static WebDriver GetDriverInstance() {
        WebDriverManager.chromedriver().setup();

        webDriver = new ChromeDriver();
        ScenarioContext.setContext(Enums.WEBDRIVER, webDriver);
        return webDriver;
    }
}
