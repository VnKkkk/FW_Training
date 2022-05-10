package stepdefs;

import common.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;


public class UIHooks extends BaseClass {

    private BaseClass baseClass;

    public UIHooks(BaseClass baseClass){
        this.baseClass = baseClass;
    }

    public UIHooks(){}

    @Before
    public void setUp() {

        WebDriverManager.chromedriver().setup();
        baseClass.webDriver = new ChromeDriver();

    }



    @After
    public void tearDown() {
        if (baseClass.webDriver != null) {
            baseClass.webDriver.close();
        }
    }

}
