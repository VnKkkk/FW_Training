package common;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import POM.LoginPage;
import dataProviders.ConfigReader;

public class UIHooks extends BaseClass {

    @Before
    public void setUp() {

//        WebDriverManager.chromedriver().setup();
//
//        webDriver = new ChromeDriver();
//        webDriver.manage().window().maximize();
    }

    @After
    public void tearDown() {
        if (webDriver != null) {
            webDriver.close();
        }
    }
}
