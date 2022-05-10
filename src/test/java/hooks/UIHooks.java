package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class UIHooks {
    private WebDriver webDriver;

    public UIHooks(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.get("http://localhost:8080/login.php");
    }



    @After
    public void tearDown() {
        if (webDriver != null) {
            webDriver.close();
        }
    }

}
