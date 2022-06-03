package common;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

public class UIHooks extends BaseClass {

    @Before("@web")

    public void setUp() {

        WebDriverManager.chromedriver().setup();

        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
    }

    @After("@web")
    public void tearDown() {
        if (webDriver != null) {
            webDriver.close();
        }
    }
}
