import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class TestNGParallelTests2 {

    //WebDriver driver;

    @BeforeClass
    void setUpClass() {
        System.out.println("BeforeClass----------->");
        System.setProperty("webdriver.gecko.driver","/Users/thara/Work/Selenium/geckodriver");
    }

    @Test
    void searchTest() {
        WebDriver driver = new FirefoxDriver();
        driver.get("http://www.google.com");

        WebElement element = driver.findElement(By.name("q"));
        element.sendKeys("Selenium WebDriver");
        element.submit();

        Assert.assertTrue(driver.getTitle().startsWith("Selenium WebDriver"));

    }
}
