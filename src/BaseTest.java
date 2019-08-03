import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.util.ArrayList;
import java.util.List;

public class BaseTest {

    List<WebDriver> driverPool = new ArrayList<WebDriver>();

    @BeforeSuite
    void setUpSuite() {
        System.setProperty("webdriver.chrome.driver","/Users/thara/Work/Selenium/chromedriver");
        System.setProperty("webdriver.gecko.driver","/Users/thara/Work/Selenium/geckodriver");
    }

    WebDriver getDriver() {//overloaded method with default values
        return getDriver(BrowserType.CHROME,"http://www.google.com");
    }

    WebDriver getDriver(BrowserType type, String BaseURL) {
        WebDriver driver =  DriverFactory.getInstance().getDriver(type);
        driver.get(BaseURL);
        driverPool.add(driver);
        return driver;
    }

    @AfterSuite
    void TearDownSuite() {
        for(WebDriver driver :driverPool ) {
            //driver.quit();
        }
    }

}
